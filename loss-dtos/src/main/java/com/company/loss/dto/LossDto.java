package com.company.loss.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class LossDto {

    private String id;
    private String lossType;
    private String lossStatus;
    private String description;
    private BigDecimal returnAmountBeforeTaxes;
    private BigDecimal returnAmountAfterTaxes;
    private VictimDto victim;
    private Set<String> adjusterIds;
}
