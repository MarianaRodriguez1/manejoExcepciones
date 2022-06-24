package com.santander.manejoExcepciones.utils;

import com.santander.manejoExcepciones.exception.QueuePublisherException;

public class QueuePublisher {

    public static boolean postToAQueue() throws QueuePublisherException {
        try{
            //this method should post a message in a queue
            return true;
        }
        catch (Exception e){
            throw new QueuePublisherException();
        }

    }
}
