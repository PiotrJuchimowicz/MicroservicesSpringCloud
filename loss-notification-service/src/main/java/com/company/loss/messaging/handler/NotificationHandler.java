package com.company.loss.messaging.handler;

import com.company.loss.dto.LossClosedEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationHandler {

    private final NotificationProcessor notificationProcessor;

    NotificationHandler(NotificationProcessor notificationProcessor) {
        this.notificationProcessor = notificationProcessor;
    }

    @Transactional
    public void processNotification(LossClosedEvent event) {
        notificationProcessor.processNotification(event);
    }
}
