package com.santander.manejoExcepciones.exception;

public class SlackNotificationException extends Exception{
    public SlackNotificationException(){
        super("Slack Notification error");
    }
}
