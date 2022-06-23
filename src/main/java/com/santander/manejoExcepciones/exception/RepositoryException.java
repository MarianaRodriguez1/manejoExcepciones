package com.santander.manejoExcepciones.exception;

public class RepositoryException extends RuntimeException {
    public RepositoryException(){
        super("Repository Excepcion when you try save an user");
    }
}
