package com.company.loss.management.domain.business;

import com.company.loss.management.domain.port.incoming.LossHandler;
import com.company.loss.management.domain.port.outgoing.LossRepository;
import com.company.loss.management.domain.business.calculation.AmountCalculator;
import com.company.loss.management.domain.port.outgoing.NotificationSender;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Component
class DomainService implements LossHandler {

    private final LossRepository repository;
    private final AmountCalculator amountCalculator;
    private final NotificationSender notificationSender;

    DomainService(LossRepository repository, AmountCalculator amountCalculator, NotificationSender notificationSender) {
        this.repository = repository;
        this.amountCalculator = amountCalculator;
        this.notificationSender = notificationSender;
    }

    @Override
    public void create(Loss loss) {
        repository.save(loss);
    }

    @Override
    public void proceed(String lossId, String adjusterId) {
        final Loss loss = repository.getOne(lossId).orElseThrow(IllegalStateException::new);
        loss.proceed(amountCalculator, adjusterId);
    }

    @Override
    public void close(String lossId, String adjusterId) {
        final Loss loss = repository.getOne(lossId).orElseThrow(IllegalStateException::new);
        loss.close(adjusterId);
        this.notificationSender.lossClosedEvent(lossId, adjusterId, LocalDateTime.now());
    }

    @Override
    public Optional<Loss> getOne(String id) {
        return repository.getOne(id);
    }

    @Override
    public Set<Loss> get() {
        return repository.get();
    }

    @Override
    public Boolean existLossesByAdjuster(String adjusterId) {
        return !repository.getLossesByAdjuster(adjusterId).isEmpty();
    }
}
