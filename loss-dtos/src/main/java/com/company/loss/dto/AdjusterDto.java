package com.company.loss.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class AdjusterDto {

    private String id;
    private String name;
    private String surname;
    private AdjusterAccountDto account;
    private List<AdjusterAddressDto> addresses;
}
