package com.example.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @RabbitListener(queues = "queueA")
    public void receiveMessageA(String msg) {
        System.out.println("Received on queueA:" + msg);
    }

    @RabbitListener(queues = "queueB")
    public void receiveMessageB(String msg) {
        System.out.println("Received on queueB:" + msg);
    }
}
