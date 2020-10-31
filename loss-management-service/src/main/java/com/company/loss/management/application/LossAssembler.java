package com.company.loss.management.application;

import com.company.loss.dto.LossDto;
import com.company.loss.dto.VictimDto;
import com.company.loss.management.domain.business.Loss;
import com.company.loss.management.domain.business.LossType;
import com.company.loss.management.domain.business.Victim;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

class LossAssembler {

    Loss toLoss(LossDto lossDto, String adjusterId) {
        final UUID uuid = lossDto.getId() == null ? null : UUID.fromString(lossDto.getId());
        return new Loss(uuid, LossType.valueOf(lossDto.getLossType()), lossDto.getDescription(), lossDto.getReturnAmountBeforeTaxes(),
                toVictim(lossDto.getVictim()), UUID.fromString(adjusterId));
    }

    LossDto toLossDto(Loss loss) {
        return new LossDto(loss.id().toString(), loss.type().name(), loss.status().name(), loss.description(),
                loss.returnAmountBeforeTaxes(), loss.returnAmountAfterTaxes(), toVictimDto(loss.victim()), loss.adjusterIds());
    }

    List<LossDto> toLossDtos(Set<Loss> losses) {
        return losses.stream()
                .map(this::toLossDto)
                .collect(Collectors.toList());
    }

    private Victim toVictim(VictimDto victimDto) {
        final UUID uuid = victimDto.getId() == null ? null : UUID.fromString(victimDto.getId());
        return new Victim(uuid, victimDto.getName(), victimDto.getSurname(), victimDto.getEmail());
    }

    private VictimDto toVictimDto(Victim victim) {
        return new VictimDto(victim.id().toString(), victim.name(), victim.surname(), victim.email());
    }
}
