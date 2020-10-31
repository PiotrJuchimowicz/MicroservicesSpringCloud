package com.company.loss.management.domain.business;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class LossAdjusterId implements Serializable {

    @Column(name = "loss_id")
    private UUID lossId;

    @Column(name = "adjuster_id")
    private UUID adjusterId;

    //jpa
    public LossAdjusterId() {
    }

    public LossAdjusterId(UUID lossId, UUID adjusterId) {
        this.lossId = lossId;
        this.adjusterId = adjusterId;
    }

    public UUID lossId() {
        return lossId;
    }

    public UUID adjusterId() {
        return adjusterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LossAdjusterId that = (LossAdjusterId) o;
        return lossId.equals(that.lossId) &&
                adjusterId.equals(that.adjusterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lossId, adjusterId);
    }

}
