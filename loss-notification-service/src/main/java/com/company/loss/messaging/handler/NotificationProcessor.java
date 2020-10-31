package com.company.loss.messaging.handler;

import com.company.loss.dto.LossClosedEvent;

public interface NotificationProcessor {

    void processNotification(LossClosedEvent notification);
}
