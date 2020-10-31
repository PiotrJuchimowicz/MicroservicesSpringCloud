package com.company.loss.management.domain.business;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "LOSS_ADJUSTER")
public class LossAdjuster {

    @EmbeddedId
    private LossAdjusterId id;
    private LocalDateTime modificationDate;

    @MapsId("lossId")
    @ManyToOne
    @JoinColumn(name = "loss_Id")
    private Loss loss;

    //jpa
    public LossAdjuster() {
    }

    public LossAdjuster(LossAdjusterId id, Loss loss) {
        this.id = id;
        this.loss = loss;
    }

    public LossAdjusterId id() {
        return id;
    }

    @PrePersist
    @PreUpdate
    void updateModificationDate() {
        this.modificationDate = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LossAdjuster that = (LossAdjuster) o;
        return id.equals(that.id) &&
                loss.equals(that.loss);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loss);
    }
}
