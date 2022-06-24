package com.santander.manejoExcepciones.utils;

import com.santander.manejoExcepciones.exception.SlackNotificationException;

public class SlackNotificationSender {

    public static boolean sendSlackNotification() throws SlackNotificationException {
        try{
            //this method should send a slack notification
            return true;
        }
        catch (Exception e){
            throw new SlackNotificationException();
        }

    }
}
