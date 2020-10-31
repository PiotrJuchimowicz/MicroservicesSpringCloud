package com.company.loss.adjusters.domain.bussiness;

import com.company.loss.adjusters.domain.port.incoming.AdjusterHandler;
import com.company.loss.adjusters.domain.port.outgoing.AdjusterRepository;
import com.company.loss.adjusters.domain.port.outgoing.LossConnector;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
class AdjusterDomainService implements AdjusterHandler {

    private final AdjusterRepository repository;
    private final LossConnector lossConnector;

    AdjusterDomainService(AdjusterRepository repository, LossConnector lossConnector) {
        this.repository = repository;
        this.lossConnector = lossConnector;
    }

    @Override
    public void save(Adjuster adjuster) {
        repository.save(adjuster);
    }

    @Override
    public Optional<Adjuster> getOne(String id) {
        return repository.getOne(id);
    }

    @Override
    public Set<Adjuster> get() {
        return repository.get();
    }

    @Override
    public void remove(String id) {
        final boolean existLossByAdjuster = lossConnector.existLossesByAdjuster(id);
        if(existLossByAdjuster) {
            throw new AdjusterRemovalException("Adjuster can not be removed. Has unclosed losses");
        }

        repository.remove(id);
    }

    @Override
    public void addAddress(String id, AdjusterAddress adjusterAddress) {
        final Optional<Adjuster> adjusterOptional = repository.getOne(id);
        adjusterOptional.orElseThrow(() -> new IllegalArgumentException("Cant find adjuster with id %s" + id))
                .addAddress(adjusterAddress);
    }
}
