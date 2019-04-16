package com.example.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    @Autowired
    private RabbitConf conf;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public  void send(String routingKey, String message) {
        System.out.printf("Sending %s on %s\n", message, routingKey);
        rabbitTemplate.convertAndSend(conf.topicExchangeName, routingKey , message);
    }
}
