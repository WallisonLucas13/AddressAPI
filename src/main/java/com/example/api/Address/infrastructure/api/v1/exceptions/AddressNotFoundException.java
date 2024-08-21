package com.example.api.Address.infrastructure.api.v1.exceptions;

public class AddressNotFoundException extends RuntimeException{

    public AddressNotFoundException(String message) {
        super(message);
    }
}
