package com.santander.manejoExcepciones.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/api/v1/users")
    //public ResponseEntity<Boolean> newUser(){
    public boolean newUser(){
        return true;
    }
}
