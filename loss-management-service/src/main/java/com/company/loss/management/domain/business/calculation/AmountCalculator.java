package com.company.loss.management.domain.business.calculation;

import com.company.loss.management.domain.business.LossType;

import java.math.BigDecimal;

public interface AmountCalculator {

    BigDecimal calculateAmount(LossType lossType, BigDecimal amountBeforeTaxes);
}
