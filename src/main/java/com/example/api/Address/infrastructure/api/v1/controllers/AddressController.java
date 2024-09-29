package com.example.api.Address.infrastructure.api.v1.controllers;

import com.example.api.Address.domain.address.usecases.AddressIntegration;
import com.example.api.Address.infrastructure.api.v1.controllers.doc.AddressControllerSwagger;
import com.example.api.Address.infrastructure.api.v1.exceptions.CepFormatInvalidException;
import com.example.api.Address.infrastructure.api.v1.exceptions.AddressNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("api/v1/address")
@CrossOrigin(origins = "http://localhost:8083/*")
@RequiredArgsConstructor
public class AddressController implements AddressControllerSwagger {

    private final AddressIntegration addressIntegration;

    @Override
    @GetMapping("/{cep}")
    public ResponseEntity<Object> findAddressByCep(@PathVariable("cep") final String cep) throws URISyntaxException {
        return ResponseEntity.ok(addressIntegration.findAddressByCep(cep));
    }
}
