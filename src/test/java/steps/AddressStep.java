package steps;

import com.example.api.Address.domain.address.inputs.AddressInput;
import com.example.api.Address.domain.address.models.AddressModel;
import com.example.api.Address.infrastructure.restservice.RestClientAdapter;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

@Log4j2
public class AddressStep {

    private RestClient restClient;
    private URI baseUri;
    private ResponseEntity<AddressModel> response;

    @Before
    public void setup(){
        this.restClient = RestClient.create();
    }

    @Given("que faço uma consulta a base URL")
    public void setBaseUrl() {
        this.baseUri = URI.create("http://localhost:8081/");
    }

    @Given("que faço uma consulta GET ao path: {string}")
    public void que_faço_uma_consulta_ao_path(String path){
        this.baseUri = UriComponentsBuilder
                .fromUri(baseUri)
                .path(path)
                .build()
                .toUri();
    }
    @When("realizo a busca de endereço pelo cep: {string}")
    public void realizo_a_busca_de_endereço_pelo_cep(String cep) throws URISyntaxException, HttpClientErrorException{
        var uri = UriComponentsBuilder
                .fromUri(baseUri)
                .path("/{cep}")
                .buildAndExpand(cep)
                .toUri();

        try {
            this.response = restClient.get()
                    .uri(uri)
                    .retrieve()
                    .toEntity(AddressModel.class);

        }catch(HttpClientErrorException e){
            this.response = ResponseEntity.status(e.getStatusCode()).build();
        }

    }
    @Then("o end point deve retornar status OK e uma UF válida")
    public void recebo_um_endereço_válido() {
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(this.response.getBody());
        Assertions.assertNotNull(this.response.getBody().getUf());
    }

    @Then("o end point deve retornar status BAD_REQUEST ao passar cep com formato inválido")
    public void recebo_um_bad_request() {
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Assertions.assertNull(this.response.getBody());
    }

    @Then("o end point deve retornar status NOT_FOUND ao buscar por cep inexistente")
    public void recebo_um_not_found() {
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        Assertions.assertNull(this.response.getBody());
    }

}
