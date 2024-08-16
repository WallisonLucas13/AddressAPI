package com.example.api.Cep.infrastructure.api.v1.controllers.doc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.URISyntaxException;

public interface CepControllerSwagger {

    ResponseEntity<Object> findAddressByCep(@PathVariable("cep") String cep) throws URISyntaxException;
}
