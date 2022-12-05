package com.niit.jap.springBootApp.rabbitmqreciver;

import com.niit.jap.springBootApp.Domain.User;
import com.niit.jap.springBootApp.exception.UserNotFoundException;
import com.niit.jap.springBootApp.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    private UserService userService;
    @RabbitListener(queues = "user_queue")
    public  void  getDtoFromQueueAndAddToDb(UserDTO userDTO) throws UserNotFoundException{
        User user= new User();
        user.setEmailId(userDTO.getEmailId());
        user.setUserPassword(userDTO.getUserPassword());

        User user1 = (User) userService.saveUser(user);
        System.out.println("result = "+user1);
    }
}
