package com.company.loss.adjusters.application;

import com.company.loss.adjusters.domain.port.incoming.AdjusterHandler;
import com.company.loss.adjusters.domain.bussiness.Adjuster;
import com.company.loss.adjusters.domain.bussiness.AdjusterAddress;
import com.company.loss.dto.AdjusterAddressDto;
import com.company.loss.dto.AdjusterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class AdjusterManager {

    private final AdjusterHandler adjusterHandler;
    private final AdjusterAssembler adjusterAssembler;

    AdjusterManager(AdjusterHandler adjusterHandler) {
        this.adjusterHandler = adjusterHandler;
        adjusterAssembler = new AdjusterAssembler();
    }

    @Transactional
    public void save(AdjusterDto adjusterDto) {
        final Adjuster adjuster = adjusterAssembler.toAdjuster(adjusterDto);
        adjusterHandler.save(adjuster);
    }

    @Transactional
    public void remove(String id) {
        adjusterHandler.remove(id);
    }

    @Transactional(readOnly = true)
    public Optional<AdjusterDto> getOne(String id) {
        Optional<Adjuster> adjuster = adjusterHandler.getOne(id);
        return adjuster.map(adjusterAssembler::toAdjusterDto);
    }

    @Transactional(readOnly = true)
    public List<AdjusterDto> get() {
        Set<Adjuster> adjusters = adjusterHandler.get();
        return adjusterAssembler.toAdjustersDto(adjusters);
    }

    @Transactional
    public void addAddress(String id, AdjusterAddressDto addressDto) {
        final UUID uuid = addressDto.getId() == null ? null : UUID.fromString(addressDto.getId());
        AdjusterAddress adjusterAddress = new AdjusterAddress(uuid, addressDto.getCountry(), addressDto.getCity(), addressDto.getStreet(),
                        addressDto.getFlatNumber());
        adjusterHandler.addAddress(id, adjusterAddress);
    }
}
