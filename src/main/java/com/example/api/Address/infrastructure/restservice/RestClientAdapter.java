package com.example.api.Address.infrastructure.restservice;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.net.URI;

@RequiredArgsConstructor
public class RestClientAdapter {

    private final RestClient restClient;

    public <T> T get(final URI uri, final Class<T> responseType){
       return restClient.get()
               .uri(uri)
               .retrieve()
               .body(ParameterizedTypeReference.forType(responseType));
    }
}
