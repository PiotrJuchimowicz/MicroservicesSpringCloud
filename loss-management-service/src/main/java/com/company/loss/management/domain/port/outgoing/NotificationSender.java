package com.company.loss.management.domain.port.outgoing;

import java.time.LocalDateTime;

public interface NotificationSender {

    void lossClosedEvent(String lossId, String adjusterId, LocalDateTime closeDate);
}
