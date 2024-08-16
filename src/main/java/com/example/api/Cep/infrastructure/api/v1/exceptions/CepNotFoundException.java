package com.example.api.Cep.infrastructure.api.v1.exceptions;

public class CepNotFoundException extends RuntimeException{

    public CepNotFoundException(String message) {
        super(message);
    }
}
