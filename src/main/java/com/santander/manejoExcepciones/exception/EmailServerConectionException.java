package com.santander.manejoExcepciones.exception;

public class EmailServerConectionException extends RuntimeException{
    public EmailServerConectionException(){
        super("Email server unavailable");
    }
}
