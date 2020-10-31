package com.company.loss.management.infrastructure.messaging;

import com.company.loss.dto.LossClosedEvent;
import com.company.loss.management.domain.port.outgoing.NotificationSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
class RabbitNotificationSender implements NotificationSender {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;
    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private final MessagingProperties properties;

    RabbitNotificationSender(RabbitTemplate rabbitTemplate, Queue queue, MessagingProperties messagingProperties) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
        this.properties = messagingProperties;
    }

    @Override
    public void lossClosedEvent(String lossId, String adjusterId, LocalDateTime closeDate) {
        final LossClosedEvent event = new LossClosedEvent(lossId, adjusterId, closeDate);
        log.info("Sending message {} to queue {} ", event, queue);
        this.rabbitTemplate.convertAndSend(properties.exchangeName(),  properties.exchangeKey(), event);
        log.info("Message sent");
    }
}
