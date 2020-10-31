package com.company.loss.management.infrastructure.messaging;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
class MessagingConfig {

    private final MessagingProperties properties;
    private final AmqpAdmin amqpAdmin;

    MessagingConfig(MessagingProperties properties, AmqpAdmin amqpAdmin) {
        this.properties = properties;
        this.amqpAdmin = amqpAdmin;
    }

    @PostConstruct
    public void createQueue() {
        amqpAdmin.declareQueue(notificationQueue());
    }

    @Bean
    Queue notificationQueue() {
        return QueueBuilder.durable(properties.queueName()).build();
    }

    @Bean
    DirectExchange directExchange() {
        return ExchangeBuilder.directExchange(properties.exchangeName()).build();
    }

    @Bean
    Binding binding(Queue notificationQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(notificationQueue).to(directExchange).with(properties.exchangeKey());
    }
}
