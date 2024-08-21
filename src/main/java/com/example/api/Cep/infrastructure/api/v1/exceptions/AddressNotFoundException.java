package com.example.api.Cep.infrastructure.api.v1.exceptions;

public class AddressNotFoundException extends RuntimeException{

    public AddressNotFoundException(String message) {
        super(message);
    }
}
