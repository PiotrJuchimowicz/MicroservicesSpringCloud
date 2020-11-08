package com.company.loss.gateway.input.dto;

import com.company.loss.dto.LossDto;

public class LossAdjusterDto {
    private LossDto lossDto;
    private String adjusterId;

    public LossDto getLossDto() {
        return lossDto;
    }

    public void setLossDto(LossDto lossDto) {
        this.lossDto = lossDto;
    }

    public String getAdjusterId() {
        return adjusterId;
    }

    public void setAdjusterId(String adjusterId) {
        this.adjusterId = adjusterId;
    }

    @Override
    public String toString() {
        return "LossAdjusterDto{" +
                "lossDto=" + lossDto +
                ", adjusterId='" + adjusterId + '\'' +
                '}';
    }
}
