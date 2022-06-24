package com.santander.manejoExcepciones.exception;

public class DbException extends Exception {
    public DbException(){
        super("Error with the dataBase");
    }
}
