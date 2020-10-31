package com.company.loss.messaging.persistence;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "NOTIFICATION")
class Notification {

    @EmbeddedId
    private NotificationId id;
    @Enumerated(EnumType.STRING)
    private NotificationType type;
    private LocalDateTime closeDate;

    //jpa
    private Notification() {
    }

    public Notification(NotificationId id, LocalDateTime closeDate, NotificationType notificationType) {
        this.id = id;
        this.closeDate = closeDate;
        this.type = notificationType;
    }

    public NotificationId id() {
        return id;
    }

    public LocalDateTime closeDate() {
        return closeDate;
    }

    public NotificationType type() {
        return type;
    }
}
