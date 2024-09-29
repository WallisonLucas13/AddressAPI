package com.example.api.Address.infrastructure.api.v1.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CepFormatInvalidException extends RuntimeException{

    private final HttpStatus httpStatus;

    public CepFormatInvalidException(final HttpStatus httpStatus,
                                    final String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
