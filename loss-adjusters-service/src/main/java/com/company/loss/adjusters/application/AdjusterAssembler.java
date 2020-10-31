package com.company.loss.adjusters.application;

import com.company.loss.adjusters.domain.bussiness.Adjuster;
import com.company.loss.adjusters.domain.bussiness.AdjusterAccount;
import com.company.loss.adjusters.domain.bussiness.AdjusterAddress;
import com.company.loss.dto.AdjusterAccountDto;
import com.company.loss.dto.AdjusterAddressDto;
import com.company.loss.dto.AdjusterDto;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

class AdjusterAssembler {

    Adjuster toAdjuster(AdjusterDto adjusterDto) {
        final UUID uuid = adjusterDto.getId() == null ? null : UUID.fromString(adjusterDto.getId());
        return new Adjuster(uuid, adjusterDto.getName(), adjusterDto.getSurname(), toAdjusterAccount(adjusterDto),
                toAdjusterAddresses(adjusterDto.getAddresses()));
    }


    AdjusterDto toAdjusterDto(Adjuster adjuster) {
        return new AdjusterDto(adjuster.id().toString(), adjuster.firstName(), adjuster.lastName(),
                new AdjusterAccountDto(adjuster.id().toString(), adjuster.account().privateEmail(),
                        adjuster.account().businessEmail()), toAdjusterAddressesDto(adjuster.addresses()));
    }

    List<AdjusterDto> toAdjustersDto(Set<Adjuster> adjusters) {
        return adjusters.stream()
                .map(this::toAdjusterDto)
                .collect(Collectors.toList());
    }

    private AdjusterAccount toAdjusterAccount(AdjusterDto adjusterDto) {
        final UUID uuid = adjusterDto.getAccount().getId() == null
                ? null : UUID.fromString(adjusterDto.getId());
        return new AdjusterAccount(uuid, adjusterDto.getAccount().getPrivateEmail(),
                adjusterDto.getAccount().getBusinessEmail());
    }

    private List<AdjusterAddressDto> toAdjusterAddressesDto(Set<AdjusterAddress> addresses) {
        return addresses.stream()
                .map(address -> new AdjusterAddressDto(address.id().toString(), address.country(), address.city(),
                        address.street(), address.flatNumber()))
                .collect(Collectors.toList());
    }

    private Set<AdjusterAddress> toAdjusterAddresses(List<AdjusterAddressDto> addressDtos) {
        return addressDtos.stream()
                .map(addressDto -> new AdjusterAddress(
                        addressDto.getId() == null ? null : UUID.fromString(addressDto.getId()),
                        addressDto.getCountry(), addressDto.getCity(), addressDto.getStreet(),
                        addressDto.getFlatNumber()))
                .collect(Collectors.toSet());
    }
}
