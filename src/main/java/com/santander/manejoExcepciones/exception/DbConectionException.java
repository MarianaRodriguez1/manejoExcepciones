package com.santander.manejoExcepciones.exception;

public class DbConectionException extends RuntimeException {
    public DbConectionException(){
        super("Error conecting to dataBase");
    }
}
