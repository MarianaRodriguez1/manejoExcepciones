package com.santander.manejoExcepciones.utils;

import com.santander.manejoExcepciones.exception.FileWriterException;

public class FileWriter {

    public static boolean writeFile() throws FileWriterException {
        try{
            //this method should write to a file the operation
            return true;
        }
        catch(Exception e){
            throw new FileWriterException();
        }

    }
}
