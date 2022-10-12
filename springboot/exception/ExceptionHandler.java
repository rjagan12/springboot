package com.i2i.springboot.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler extends RuntimeException {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = NullListException.class )
    public String exceptionHandler(NullListException exception) {

        return " INVALID RECORD " + exception.getMessage();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
            (value = MethodArgumentNotValidException.class)
    public String exceptionHandler(MethodArgumentNotValidException exception) {

        return "INVALID INPUT " + exception.getMessage();
    }

}
