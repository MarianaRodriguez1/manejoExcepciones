package com.santander.manejoExcepciones.exception;

import com.santander.manejoExcepciones.dto.ErrorResponse;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.rmi.ServerException;
import java.rmi.server.ServerNotActiveException;
import java.time.LocalDate;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(java.io.IOException.class)
    public ErrorResponse handlerException(IOException ioException){
        logger.info("Input/output exception");
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),ioException.getMessage(), LocalDate.now());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(FileNotFoundException.class)
    public ErrorResponse handlerException(FileNotFoundException fileNotFoundException){
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),fileNotFoundException.getMessage(), LocalDate.now());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(EOFException.class)
    public ErrorResponse handlerException(EOFException eofException){
        logger.info("End of file exception");
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),eofException.getMessage(), LocalDate.now());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(FileAlreadyExistsException.class)
    public ErrorResponse handlerException(FileAlreadyExistsException fileAlreadyExistsException){
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),fileAlreadyExistsException.getMessage(), LocalDate.now());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RepositoryException.class)
    public ErrorResponse handlerException(RepositoryException repositoryException){
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),repositoryException.getMessage(), LocalDate.now());
    }

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
    @ExceptionHandler(ServerNotActiveException.class)
    public ErrorResponse handlerException(ServerNotActiveException serverNotActiveException){
        return new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE.value(),serverNotActiveException.getMessage(), LocalDate.now());
    }

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(ServerException.class)
    public ErrorResponse handlerException(ServerException serverException){
        return new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE.value(),serverException.getMessage(), LocalDate.now());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ErrorResponse handlerException(HttpClientErrorException.NotFound notFoundException){
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(),notFoundException.getMessage(), LocalDate.now());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ResponseStatusException.class)
    public ErrorResponse handlerException(ResponseStatusException responseStatusException){
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(),responseStatusException.getMessage(), LocalDate.now());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InterruptedException.class)
    public ErrorResponse handlerException(InterruptedException interruptedException){
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(),interruptedException.getMessage(), LocalDate.now());
    }




}
