package com.asdasd.mjeesh.exception_heandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EntityIncorrectData> allExceptionHandle(Exception exception) {
        EntityIncorrectData data = new EntityIncorrectData(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}
