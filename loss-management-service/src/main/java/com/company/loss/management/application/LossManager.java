package com.company.loss.management.application;

import com.company.loss.dto.LossDto;
import com.company.loss.management.domain.port.incoming.LossHandler;
import com.company.loss.management.domain.business.Loss;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class LossManager {

    private final LossHandler handler;
    private final LossAssembler assembler;

    LossManager(LossHandler handler) {
        this.handler = handler;
        this.assembler = new LossAssembler();
    }

    @Transactional
    public void create(LossDto lossDto, String adjusterId) {
        final Loss loss = assembler.toLoss(lossDto, adjusterId);
        handler.create(loss);
    }

    @Transactional
    public void proceed(String lossId, String adjusterId) {
        handler.proceed(lossId, adjusterId);
    }

    @Transactional
    public void close(String lossId, String adjusterId) {
        handler.close(lossId, adjusterId);
    }

    @Transactional(readOnly = true)
    public Optional<LossDto> getOne(String lossId) {
        final Optional<Loss> lossOptional = handler.getOne(lossId);
        return lossOptional.map(assembler::toLossDto);
    }

    @Transactional(readOnly = true)
    public List<LossDto> get() {
        final Set<Loss> losses = handler.get();
        return assembler.toLossDtos(losses);
    }

    @Transactional
    public Boolean existLossesByAdjuster(String adjusterId) {
        return handler.existLossesByAdjuster(adjusterId);
    }
}
