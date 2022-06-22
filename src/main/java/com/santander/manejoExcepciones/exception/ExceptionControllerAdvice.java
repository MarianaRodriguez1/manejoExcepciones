package com.santander.manejoExcepciones.exception;

import com.santander.manejoExcepciones.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DbConectionException.class)
    public ErrorResponse handlerException(DbConectionException dbConectionException){
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),dbConectionException.getMessage(), LocalDate.now());
    }

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(EmailServerConectionException.class)
    public ErrorResponse handlerException(EmailServerConectionException emailServerConectionException){
        return new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE.value(),emailServerConectionException.getMessage(), LocalDate.now());
    }

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(SlackServerConectionException.class)
    public ErrorResponse handlerException(SlackServerConectionException slackServerConectionException){
        return new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE.value(),slackServerConectionException.getMessage(), LocalDate.now());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(IOException.class)
    public ErrorResponse handlerException(IOException ioException){
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),ioException.getMessage(), LocalDate.now());
    }
}
