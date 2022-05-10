package com.techelevator.event;

import org.springframework.data.rest.webmvc.RepositoryRestExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice(basePackageClasses = RepositoryRestExceptionHandler.class)
public class ValidationExceptionHandler {

    public static final String MESSAGE_KEY = "message";

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<Map<String, String>> handleValidationException(ValidationException e) {
        Map<String, String> response = new HashMap<>();
        response.put(MESSAGE_KEY, e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}