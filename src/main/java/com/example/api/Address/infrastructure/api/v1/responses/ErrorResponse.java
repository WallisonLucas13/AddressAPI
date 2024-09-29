package com.example.api.Address.infrastructure.api.v1.responses;

import lombok.Getter;

import java.sql.Timestamp;
import java.time.Instant;

@Getter
public class ErrorResponse {

    public ErrorResponse(final String status, final String message, final String path){
        this.timestamp = Timestamp.from(Instant.now());
        this.status = status;
        this.message = message;
        this.path = path;
    }

    private final Timestamp timestamp;
    private final String status;
    private final String message;
    private final String path;


}
