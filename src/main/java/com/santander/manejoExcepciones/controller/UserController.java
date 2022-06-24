package com.santander.manejoExcepciones.controller;


import com.santander.manejoExcepciones.dto.UserDto;
import com.santander.manejoExcepciones.exception.*;
import com.santander.manejoExcepciones.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    public UserController(){
        userService = new UserService();
    }

    @PostMapping("/api/v1/users")
    public boolean addUser(UserDto userDto) throws RepositoryException, EmailSenderException, SlackNotificationException, QueuePublisherException, DbException, FileWriterException {
        userService.addUser(userDto);
        return true;
    }
}
