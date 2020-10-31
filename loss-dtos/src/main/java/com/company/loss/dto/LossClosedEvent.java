package com.company.loss.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class LossClosedEvent implements Serializable {

    private String lossId;
    private String adjusterId;
    private LocalDateTime closeDate;
}
