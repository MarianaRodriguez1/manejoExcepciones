package com.santander.manejoExcepciones.exception;

import com.santander.manejoExcepciones.utils.QueuePublisher;

public class QueuePublisherException extends Exception{
    public QueuePublisherException(){
        super("Error traying to post to queue");
    }
}
