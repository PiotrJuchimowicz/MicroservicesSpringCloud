package com.company.loss.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class AdjusterAccountDto {

    private String id;
    private String privateEmail;
    private String businessEmail;
}
