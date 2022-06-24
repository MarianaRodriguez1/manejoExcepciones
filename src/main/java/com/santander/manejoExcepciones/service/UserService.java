package com.santander.manejoExcepciones.service;

import com.santander.manejoExcepciones.dto.UserDto;
import com.santander.manejoExcepciones.entity.UserEntity;
import com.santander.manejoExcepciones.exception.*;
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


    public void addUser(UserDto userDto) throws RepositoryException, DbException, EmailSenderException, SlackNotificationException, QueuePublisherException, FileWriterException {
        if (checkUserExistence())
            EmailSender.sendEmail();
        else{
            //map or receive from controller already mapped
            UserEntity user = userRepository.save(new UserEntity());
            if (user.getId() == null)
                throw new RepositoryException();
            SlackNotificationSender.sendSlackNotification();
            QueuePublisher.postToAQueue();
        }
        FileWriter.writeFile();
    }

    private boolean checkUserExistence() throws DbException {
        try{
            //this method should return true if the user exists, or false if not
            return true;
        }
        catch (Exception e){
            throw new DbException();
        }

    }




}
