package com.config;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.task.dto.ErrorDTO;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDTO validationErrors() {
        return new ErrorDTO("ERR_VALID", "No se pudo", getClass());
    }
}
