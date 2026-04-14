package com.example.Spring_Security.advice;

import com.example.Spring_Security.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException e){
        ApiError apiConfig = new ApiError(HttpStatus.NOT_FOUND,e.getLocalizedMessage());
        return new ResponseEntity<>(apiConfig, HttpStatus.NOT_FOUND);
    }
}
