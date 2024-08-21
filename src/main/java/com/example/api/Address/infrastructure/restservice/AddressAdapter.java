package com.example.api.Address.infrastructure.restservice;

import com.example.api.Address.domain.address.converters.AddressConverter;
import com.example.api.Address.domain.address.inputs.AddressInput;
import com.example.api.Address.domain.address.models.AddressModel;
import com.example.api.Address.domain.address.ports.AddressPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@Component
public class AddressAdapter implements AddressPort {

    private final String viacep_URL;

    private final String viacep_response_PREFIX;

    private final RestTemplate restTemplate;

    public AddressAdapter(@Value("${api.viacep.url}") String viacep_URL,
                          @Value("${api.viacep.response.format.prefix}") String viacep_response_PREFIX,
                          RestTemplate restTemplate){

        this.viacep_URL = viacep_URL;
        this.viacep_response_PREFIX = viacep_response_PREFIX;
        this.restTemplate = restTemplate;
    }

    @Override
    public AddressModel findAddressByCep(String validCep) throws URISyntaxException {

        var uri = new URI(this.viacep_URL + validCep + this.viacep_response_PREFIX);
        log.info("URI criada com sucesso! - {}", uri);

        var req = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                AddressInput.class
        );
        var res = req.getBody();

        log.info("Requisição enviada, status da resposta - {}", req.getStatusCode());
        if ((res == null) || (res.getCep() == null))return null;

        log.info("Endereço retornado com sucesso!");
        return AddressConverter.inputToModel(res);
    }
}
