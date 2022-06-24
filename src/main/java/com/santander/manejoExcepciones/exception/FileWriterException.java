package com.santander.manejoExcepciones.exception;

public class FileWriterException extends Exception{
    public FileWriterException(){
        super("Error with the file");
    }
}
