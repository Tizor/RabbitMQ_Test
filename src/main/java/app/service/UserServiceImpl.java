package app.service;

import app.entity.User;
import app.repository.UserRepo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // Обычная очередь
    public void sendUserMessage(User user) {
        rabbitTemplate.convertAndSend("FirstTestQueue", user);
    }

    public void changeUserMessageFromFirstQueue(User user) {
        user.setNotes(null);
        rabbitTemplate.convertAndSend("SecondTestQueue", user);
    }
    // Очередь по подписке
    public void sendUserMessageToFanoutQueue(User user) {
        rabbitTemplate.convertAndSend("FanoutExchange","", user);
    }

    // Очередь по direct exchange и routing key
    public void sendUserMessageToDirectExchange(User user) {
        rabbitTemplate.convertAndSend("ThirdDirectExchange","Third", user);
    }

    // Очередь по topic exchange и routing key
    public void sendUserMessageToTopicExchange(User user) {
        rabbitTemplate.convertAndSend("FourthTopicExchange","third.third.rabbit", user);
    }

    // Вызов удаленных процедур
    public void sendUserMessageForRemoteProcedureCall(User user) {
        rabbitTemplate.convertSendAndReceive("FifthTestQueue", user);
    }
}
