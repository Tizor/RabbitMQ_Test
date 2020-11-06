package app.service;

import app.entity.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

@Component
public class RabbitListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private UserService userService;

    private static final Logger logger = Logger.getLogger(RabbitListener.class);



    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "FirstTestQueue")
    public void processQueue1(User message) {
        logger.info("Get message from FirstTestQueue " + message.toString());
        userService.changeUserMessageFromFirstQueue(message);
        logger.info("Send message from FirstTestQueue to SecondTestQueue" + message.toString());

    }

    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "SecondTestQueue")
    public void processQueue2(User message) {
        logger.info("Worker 1: Get message from SecondTestQueue " + message.toString());
    }

    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "SecondTestQueue")
    public void processQueue3(User message) {
        logger.info("Worker 2: Get message from SecondTestQueue " + message.toString());
    }

    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "FanoutTestQueue_1")
    public void processQueue4(User message) {
        logger.info("Worker 3: Get message from FanoutTestQueue_1 " + message.toString());
    }

    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "FanoutTestQueue_2")
    public void processQueue5(User message) {
        logger.info("Worker 4: Get message from FanoutTestQueue_2 " + message.toString());
    }

    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "ThirdDirectQueue")
    public void processQueue6(User message) {
        logger.info("Worker 5: Get message from ThirdDirectQueue " + message.toString());
    }

    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "FourthDirectQueue")
    public void processQueue7(User message) {
        logger.info("Worker 6: Get message from FourthDirectQueue " + message.toString());
    }

    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "ThirdTestQueue")
    public void processQueue8(User message) {
        logger.info("Worker 7: Get message from ThirdTestQueue" + message.toString());
    }

    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "FifthTestQueue")
    public void processQueue9(User message) {
        logger.info("Worker 8: Get message from FifthTestQueue" + message.toString());
    }



}
