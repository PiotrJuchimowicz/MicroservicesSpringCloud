package com.company.loss.messaging.persistence;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
class NotificationId implements Serializable {

    private String lossId;
    private String adjusterId;

    //jpa
    private NotificationId() {
    }

    public NotificationId(String lossId, String adjusterId) {
        this.lossId = lossId;
        this.adjusterId = adjusterId;
    }

    public String lossId() {
        return lossId;
    }

    public String adjusterId() {
        return adjusterId;
    }
}
