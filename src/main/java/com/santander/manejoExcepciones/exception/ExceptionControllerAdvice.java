package com.santander.manejoExcepciones.exception;

import com.santander.manejoExcepciones.dto.ErrorResponse;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DbException.class)
    public ErrorResponse handlerException(DbException dbException){
        logger.info("DataBase error");
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),dbException.getMessage(), LocalDate.now());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(EmailSenderException.class)
    public ErrorResponse handlerException(EmailSenderException emailSenderException){
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),emailSenderException.getMessage(), LocalDate.now());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(FileWriterException.class)
    public ErrorResponse handlerException(FileWriterException fileWriterException){
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),fileWriterException.getMessage(), LocalDate.now());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(QueuePublisherException.class)
    public ErrorResponse handlerException(QueuePublisherException queuePublisherException){
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),queuePublisherException.getMessage(), LocalDate.now());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RepositoryException.class)
    public ErrorResponse handlerException(RepositoryException repositoryException){
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),repositoryException.getMessage(), LocalDate.now());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SlackNotificationException.class)
    public ErrorResponse handlerException(SlackNotificationException slackNotificationException){
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),slackNotificationException.getMessage(), LocalDate.now());
    }






}
