package com.example.api.Cep.infrastructure.api.v1.exceptions;

public class CepFormatInvalidException extends RuntimeException{

    public CepFormatInvalidException(String message) {
        super(message);
    }
}
