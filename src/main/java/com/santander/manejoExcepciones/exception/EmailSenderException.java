package com.santander.manejoExcepciones.exception;

public class EmailSenderException extends Exception{
    public EmailSenderException(){
        super("Email sender error");
    }
}
