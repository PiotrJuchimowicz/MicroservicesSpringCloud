package com.company.loss.management.domain.business.calculation;

import com.company.loss.management.domain.business.LossType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
class AmountSimpleCalculator implements AmountCalculator {

    private static final BigDecimal ILLNESS_AMOUNT_MULTIPLIER = BigDecimal.valueOf(0.5);
    private static final BigDecimal ACCIDENT_AMOUNT_MULTIPLIER = BigDecimal.valueOf(0.3);
    private static final BigDecimal DESCRUTION_AMOUNT_MULTIPLIER = BigDecimal.valueOf(0.1);

    @Override
    public BigDecimal calculateAmount(LossType lossType, BigDecimal amountBeforeTaxes) {
        switch (lossType) {
        case ILLNESS:
            return amountBeforeTaxes.multiply(ILLNESS_AMOUNT_MULTIPLIER);
        case ACCIDENT:
            return amountBeforeTaxes.multiply(ACCIDENT_AMOUNT_MULTIPLIER);
        case DESTRUCTION:
            return amountBeforeTaxes.multiply(DESCRUTION_AMOUNT_MULTIPLIER);
        default:
            throw new UnsupportedOperationException("Unsupported loss type " + lossType);
        }
    }
}
