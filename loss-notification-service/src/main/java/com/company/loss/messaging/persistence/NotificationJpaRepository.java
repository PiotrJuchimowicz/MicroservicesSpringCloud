package com.company.loss.messaging.persistence;

import com.company.loss.dto.LossClosedEvent;
import com.company.loss.messaging.handler.NotificationProcessor;
import org.springframework.stereotype.Repository;

@Repository
class NotificationJpaRepository implements NotificationProcessor {

    private final NotificationSpringRepository repository;

    NotificationJpaRepository(NotificationSpringRepository repository) {
        this.repository = repository;
    }

    @Override
    public void processNotification(LossClosedEvent event) {
        final Notification notification = new Notification(new NotificationId(event.getLossId(), event.getAdjusterId()),
                                                            event.getCloseDate(), NotificationType.CLOSED_LOSS);

        repository.save(notification);
    }
}
