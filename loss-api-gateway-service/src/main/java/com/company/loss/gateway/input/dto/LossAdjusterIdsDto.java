package com.company.loss.gateway.input.dto;

public class LossAdjusterIdsDto {
    private String lossId;
    private String adjusterId;

    public String getLossId() {
        return lossId;
    }

    public void setLossId(String lossId) {
        this.lossId = lossId;
    }

    public String getAdjusterId() {
        return adjusterId;
    }

    public void setAdjusterId(String adjusterId) {
        this.adjusterId = adjusterId;
    }

    @Override
    public String toString() {
        return "LossAdjusterIdsDto{" +
                "lossId='" + lossId + '\'' +
                ", adjusterId='" + adjusterId + '\'' +
                '}';
    }
}
