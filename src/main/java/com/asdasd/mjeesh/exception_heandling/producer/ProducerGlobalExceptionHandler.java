package com.asdasd.mjeesh.exception_heandling.producer;

import com.asdasd.mjeesh.exception_heandling.EntityIncorrectData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProducerGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EntityIncorrectData> noSuchExceptionHandle(NoSuchProducerException exception) {
        EntityIncorrectData data = new EntityIncorrectData(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
