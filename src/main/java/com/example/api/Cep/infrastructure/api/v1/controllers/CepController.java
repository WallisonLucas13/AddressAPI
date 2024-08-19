package com.example.api.Cep.infrastructure.api.v1.controllers;

import com.example.api.Cep.domain.cep.usecases.CepIntegration;
import com.example.api.Cep.infrastructure.api.v1.controllers.doc.CepControllerSwagger;
import com.example.api.Cep.infrastructure.api.v1.exceptions.CepFormatInvalidException;
import com.example.api.Cep.infrastructure.api.v1.exceptions.CepNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("api/v1/cep")
@CrossOrigin(origins = "http://localhost/")
@RequiredArgsConstructor
public class CepController implements CepControllerSwagger {

    private final CepIntegration cepIntegration;

    @Override
    @GetMapping("/{cep}")
    public ResponseEntity<Object> findAddressByCep(@PathVariable("cep") String cep) throws URISyntaxException {
        try{
            return ResponseEntity.ok(cepIntegration.findEnderecoByCep(cep));
        }
        catch(CepFormatInvalidException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        catch(CepNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
