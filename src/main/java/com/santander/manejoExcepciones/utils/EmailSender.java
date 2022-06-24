package com.santander.manejoExcepciones.utils;


import com.santander.manejoExcepciones.exception.EmailSenderException;

public class EmailSender {

    public static boolean sendEmail() throws EmailSenderException {
        try{
            //this method should send an email
            return true;
        }
        catch (Exception e){
            throw new EmailSenderException();
        }

    }
}
