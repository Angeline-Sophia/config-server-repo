package com.prodapt.employeeservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{
    HttpHeaders headers = new HttpHeaders();

    @ExceptionHandler(CustomizedException.class)
    public ResponseEntity<Object> customException(CustomizedException e,
                                                  WebRequest webRequest){

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                e.getMessage(),
                webRequest.getDescription(false),
                "NOT_FOUND"
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers)
                .body(errorDetails);
    }
}
