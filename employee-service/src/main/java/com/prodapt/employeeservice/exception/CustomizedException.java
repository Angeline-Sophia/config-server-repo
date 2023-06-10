package com.prodapt.employeeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomizedException extends RuntimeException{

    private String message;

    public CustomizedException(String message) {
        super(message);
    }
}
