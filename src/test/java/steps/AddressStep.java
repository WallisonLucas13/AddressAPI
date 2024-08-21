package steps;

import com.example.api.Cep.domain.cep.inputs.AddressInput;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Log4j2
public class AddressStep {

    private RestTemplate restTemplate;

    private String url;

    private String cep;

    private ResponseEntity<AddressInput> response;

    @Before
    public void before(){
        this.restTemplate = new RestTemplate();
    }

    @Given("que faço uma consulta GET a url: {string}")
    public void que_faço_uma_consulta_get_a_url(String url){
        this.url = url;
    }
    @When("realizo a busca de endereço pelo cep: {string}")
    public void realizo_a_busca_de_endereço_pelo_cep(String cep) throws URISyntaxException, HttpClientErrorException{
        this.cep = cep;

        var uri = new URI(this.url + this.cep);

        try {
            this.response = this.restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    null,
                    AddressInput.class
            );
        }catch(HttpClientErrorException e){
            this.response = ResponseEntity.status(e.getStatusCode()).build();
        }

    }
    @Then("o end point deve retornar status OK e uma UF válida")
    public void recebo_um_endereço_válido() {
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(this.response.getBody());
        Assertions.assertNotNull(this.response.getBody().getUf());
        Assertions.assertEquals(this.cep, this.response.getBody().getCep());
    }

    @Then("o end point deve retornar status BAD_REQUEST ao passar cep com formato inválido")
    public void recebo_um_bad_request() {
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Assertions.assertNull(this.response.getBody());
    }

    @Then("o end point deve retornar status NOT_FOUND ao passar cep que não existe")
    public void recebo_um_not_found() {
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        Assertions.assertNull(this.response.getBody());
    }

}
