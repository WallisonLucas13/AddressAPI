package com.example.api.Cep.infrastructure.restservice;

import com.example.api.Cep.domain.cep.converters.CepConverter;
import com.example.api.Cep.domain.cep.inputs.CepInput;
import com.example.api.Cep.domain.cep.models.CepModel;
import com.example.api.Cep.domain.cep.ports.CepPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@Component
public class CepAdapter implements CepPort {

    private final String viacep_URL;

    private final String viacep_response_PREFIX;

    private final RestTemplate restTemplate;

    public CepAdapter(@Value("${api.viacep.url}") String viacep_URL,
                      @Value("${api.viacep.response.format.prefix}") String viacep_response_PREFIX,
                      RestTemplate restTemplate){

        this.viacep_URL = viacep_URL;
        this.viacep_response_PREFIX = viacep_response_PREFIX;
        this.restTemplate = restTemplate;
    }

    @Override
    public CepModel findByCep(String validCep) throws URISyntaxException {

        var uri = new URI(this.viacep_URL + validCep + this.viacep_response_PREFIX);

        var res = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                CepInput.class
        ).getBody();

        if ((res == null) || (res.getCep() == null))return null;

        return CepConverter.inputToModel(res);
    }
}
