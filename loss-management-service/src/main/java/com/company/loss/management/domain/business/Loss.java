package com.company.loss.management.domain.business;

import com.company.loss.management.domain.business.calculation.AmountCalculator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "LOSS")
public class Loss extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    private LossType type;

    @Enumerated(EnumType.STRING)
    private LossStatus status;

    private String description;

    @Column(name = "return_amount_before_taxes")
    private BigDecimal returnAmountBeforeTaxes;

    @Column(name = "return_amount_after_taxes")
    private BigDecimal returnAmountAfterTaxes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "victim_id")
    private Victim victim;

    @OneToMany(mappedBy = "loss", cascade = CascadeType.ALL)
    private Set<LossAdjuster> lossAdjusters;

    //jpa
    public Loss() {
    }

    public Loss(UUID id, LossType lossType, String description,
                BigDecimal returnAmountBeforeTaxes, Victim victim, UUID adjusterId) {
        super(id);
        this.type = lossType;
        this.status = LossStatus.NEW;
        this.description = description;
        this.returnAmountBeforeTaxes = returnAmountBeforeTaxes;
        this.victim = victim;
        this.lossAdjusters = new HashSet<>(Arrays.asList(new LossAdjuster(new LossAdjusterId(this.id(), adjusterId), this)));
    }

    public Set<String> adjusterIds() {
       return this.lossAdjusters().stream()
                .map(lossAdjuster -> lossAdjuster.id().adjusterId().toString())
                .collect(Collectors.toSet());
    }

    public void proceed(AmountCalculator calculator, String adjusterId) {
        if(status != LossStatus.NEW) {
            throw new IllegalStateException("Loss must be NEW");
        }

        //calculation
        this.returnAmountAfterTaxes = calculator.calculateAmount(this.type, this.returnAmountBeforeTaxes);
        this.lossAdjusters.add(new LossAdjuster(new LossAdjusterId(this.id(), UUID.fromString(adjusterId)), this));
        this.status = LossStatus.PROCEEDING;
    }

    public void close(String adjusterId) {
        if(status != LossStatus.PROCEEDING) {
            throw new IllegalStateException("Loss must be PROCEEDING");
        }

        this.status = LossStatus.CLOSED;
        this.lossAdjusters.add(new LossAdjuster(new LossAdjusterId(this.id(), UUID.fromString(adjusterId)), this));
        //todo Piotr notyfikacja?
    }

    public LossType type() {
        return type;
    }

    public LossStatus status() {
        return status;
    }

    public String description() {
        return description;
    }

    public BigDecimal returnAmountBeforeTaxes() {
        return returnAmountBeforeTaxes;
    }

    public BigDecimal returnAmountAfterTaxes() {
        return returnAmountAfterTaxes;
    }

    public Victim victim() {
        return victim;
    }

    public Set<LossAdjuster> lossAdjusters() {
        return lossAdjusters;
    }
}
