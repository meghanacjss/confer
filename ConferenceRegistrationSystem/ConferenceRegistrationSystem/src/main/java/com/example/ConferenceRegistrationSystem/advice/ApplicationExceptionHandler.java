package com.example.ConferenceRegistrationSystem.advice;

import com.example.ConferenceRegistrationSystem.exception.UserNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String ,String> handleInvalidArgument(ConstraintViolationException ex){

        Map<String,String>errorMap = new HashMap<>();
        ex.getConstraintViolations().stream().forEach(i-> errorMap.put(String.valueOf(i.getPropertyPath()),i.getMessage()));
        return errorMap;
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String,String>handleBusinessException(UserNotFoundException ex){
        Map<String,String>errorMap = new HashMap<>();
        errorMap.put("errorMessage",ex.getMessage());
        return errorMap;
    }
}

