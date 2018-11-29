package com.drona.dronaapp.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not Found")
    @ExceptionHandler(NullPointerException.class)
    public void handleIOException() {
        System.out.println("Not found");
        //returning 404 error code
    }

    @ExceptionHandler(UserNotFoundException.class)
    ResponseEntity<String> badRequestHandlerMapper(UserNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(buildResponseJson(e.getMessage(), HttpStatus.NOT_FOUND.name()));
    }

    @ExceptionHandler(UserException.class)
    ResponseEntity<String> badRequestHandlerMapper(UserException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON).body(buildResponseJson(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.name()));
    }

    @ExceptionHandler(UserAuthException.class)
    ResponseEntity<String> badRequestHandlerMapper(UserAuthException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).contentType(MediaType.APPLICATION_JSON).body(buildResponseJson(e.getMessage(), HttpStatus.UNAUTHORIZED.name()));
    }

    private String buildResponseJson(String description, String code) {
        try {
            return new ObjectMapper().writeValueAsString(new HashMap<String, String>() {{
                put("errorCode", code);
                put("errorDescription", description);
            }});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
