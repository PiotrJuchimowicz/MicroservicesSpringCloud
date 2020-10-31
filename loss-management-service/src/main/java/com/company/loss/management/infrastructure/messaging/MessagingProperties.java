package com.company.loss.management.infrastructure.messaging;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class MessagingProperties {

    @Value("${loss.closed.queue.name}")
    private String queueName;
    @Value("${loss.closed.exchange.name}")
    private String lossClosedExchangeName;
    @Value("${loss.closed.routing.key}")
    private String lossClosedExchangeKey;

    public String queueName() {
        return queueName;
    }

    public String exchangeName() {
        return lossClosedExchangeName;
    }

    public String exchangeKey() {
        return lossClosedExchangeKey;
    }
}
