package com.santander.manejoExcepciones.exception;

public class SlackServerConectionException extends RuntimeException{
    public SlackServerConectionException(){
        super("Slack server unavailable");
    }
}
