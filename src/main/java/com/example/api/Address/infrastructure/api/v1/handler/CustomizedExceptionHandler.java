package com.example.api.Address.infrastructure.api.v1.handler;

import com.example.api.Address.infrastructure.api.v1.exceptions.AddressNotFoundException;
import com.example.api.Address.infrastructure.api.v1.exceptions.CepFormatInvalidException;
import com.example.api.Address.infrastructure.api.v1.responses.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomizedExceptionHandler {

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerAddressNotFound(final AddressNotFoundException ex,
                                                                final HttpServletRequest request) {
        final ErrorResponse errorResponse = buildErrorResponse(ex.getHttpStatus(), ex.getMessage(), request);
        return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
    }
    @ExceptionHandler(CepFormatInvalidException.class)
    public ResponseEntity<ErrorResponse> handlerCepFormatInvalid(final CepFormatInvalidException ex,
                                                                final HttpServletRequest request) {
        final ErrorResponse errorResponse = buildErrorResponse(ex.getHttpStatus(), ex.getMessage(), request);
        return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
    }

    private ErrorResponse buildErrorResponse(final HttpStatus httpStatus,
                                             final String message,
                                             final HttpServletRequest request){
        return new ErrorResponse(
                httpStatus.getReasonPhrase(),
                message,
                request.getServletPath()
        );
    }
}
