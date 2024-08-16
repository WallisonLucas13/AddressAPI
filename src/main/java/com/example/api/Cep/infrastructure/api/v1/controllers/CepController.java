package com.example.api.Cep.infrastructure.api.v1.controllers;

import com.example.api.Cep.domain.cep.usecases.CepIntegration;
import com.example.api.Cep.infrastructure.api.v1.controllers.doc.CepControllerSwagger;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping("api/v1/cep")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CepController implements CepControllerSwagger {

    private final CepIntegration cepIntegration;

    @Override
    @GetMapping("/{cep}")
    public ResponseEntity<Object> findAddressByCep(String cep) throws URISyntaxException {
        return ResponseEntity.ok(cepIntegration.findEnderecoByCep(cep));
    }
}
