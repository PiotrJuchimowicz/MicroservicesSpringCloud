package com.company.loss.messaging.input;

import com.company.loss.dto.LossClosedEvent;
import com.company.loss.messaging.handler.NotificationHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
class LossClosedRabbitConsumer {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private final NotificationHandler handler;

    LossClosedRabbitConsumer(NotificationHandler handler) {
        this.handler = handler;
    }

    @RabbitListener(queues = "${loss.closed.queue.name}")
    void received(LossClosedEvent event) {
        log.info("Received message {} ", event);
        handler.processNotification(event);
        log.info("Processed message {} ", event);
    }
}
