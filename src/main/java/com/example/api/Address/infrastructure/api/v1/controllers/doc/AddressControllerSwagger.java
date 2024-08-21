package com.example.api.Address.infrastructure.api.v1.controllers.doc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.URISyntaxException;

public interface AddressControllerSwagger {

    ResponseEntity<Object> findAddressByCep(@PathVariable("address") String cep) throws URISyntaxException;
}
