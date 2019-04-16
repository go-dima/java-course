package com.example.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConf {
    public String topicExchangeName = "myTopic";
    private String queueA = "queueA";
    private String queueB = "queueB";
    public String routingKeyA = "mq.A";
    public String routingKeyB = "mq.B";

    @Bean
    public Queue queueA() {
        return new Queue(queueA, false); //false means not-durable
    }

    @Bean
    public Queue queueB() {
        return new Queue(queueB, false); //false means not-durable
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    public Binding bindingA() {
        return BindingBuilder.bind(queueA()).to(exchange()).with(routingKeyA);
    }

    @Bean
    public Binding bindingB() {
        return BindingBuilder.bind(queueB()).to(exchange()).with(routingKeyB);
    }
}
