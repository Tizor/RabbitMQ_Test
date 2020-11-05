package app.service;

import app.entity.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

import java.util.Arrays;


@Component
public class RabbitListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final Logger logger = Logger.getLogger(RabbitListener.class);



    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "TestQueue")
    public void processQueue1(User message) {
        logger.info("Get message from TestQueue " + message.toString());
    }

}
