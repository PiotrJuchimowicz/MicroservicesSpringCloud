package com.company.loss.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class AdjusterAddressDto {

    private String id;
    private String country;
    private String city;
    private String street;
    private String flatNumber;
}
