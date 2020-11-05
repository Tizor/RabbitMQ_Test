package app.service;

import app.entity.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class RabbitListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "TestQueue")
    public void processQueue1(User message) {
//        byte[] body = message.getBody();
        System.out.println(message.toString());
    }

}
