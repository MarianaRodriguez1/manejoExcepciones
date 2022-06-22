package com.santander.manejoExcepciones.service;

import com.santander.manejoExcepciones.entity.UserEntity;
import com.santander.manejoExcepciones.exception.DbConectionException;
import com.santander.manejoExcepciones.repository.UserRepository;
import com.santander.manejoExcepciones.utils.EmailSender;
import com.santander.manejoExcepciones.utils.FileWriter;
import com.santander.manejoExcepciones.utils.QueuePublisher;
import com.santander.manejoExcepciones.utils.SlackNotificationSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public void addUser() throws DbConectionException{
        if (checkUserExistence())
            EmailSender.sendEmail();
        else{
            userRepository.save(new UserEntity());
            SlackNotificationSender.sendSlackNotification();
            QueuePublisher.postToAQueue();
        }
        FileWriter.writeFile();
    }

    private boolean checkUserExistence(){
        //this method should return true if the user exists, or false if not
        return true;
    }




}
