package app.service;

import app.entity.User;
import app.repository.UserRepo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public Collection<User> getUserList(){
        return userRepo.getUserByFetch();
    }

    public User getUserById(Long id){
        return userRepo.getUserFetchByUserId(id);
    }

    public void sendStringMessage(String message){
        rabbitTemplate.convertAndSend("FirstTestQueue", message.getBytes());
    }

    public void sendUserMessage(User user) {
        rabbitTemplate.convertAndSend("FirstTestQueue", user);
    }

    public void changeUserMessageFromFirstQueue(User user) {
        user.setNotes(null);
        rabbitTemplate.convertAndSend("SecondTestQueue", user);
    }



}
