package com.company.loss.management.infrastructure.persistence;

import com.company.loss.management.domain.port.outgoing.LossRepository;
import com.company.loss.management.domain.business.Loss;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
class LossRepositoryJpa implements LossRepository {

    private final LossSpringRepository repository;

    LossRepositoryJpa(LossSpringRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Loss loss) {
        repository.save(loss);
    }

    @Override
    public Optional<Loss> getOne(String id) {
        return repository.findById(UUID.fromString(id));
    }

    @Override
    public Set<Loss> get() {
        return new HashSet<>(repository.findAll());
    }

    @Override
    public Set<Loss> getLossesByAdjuster(String adjusterId) {
        return repository.findByLossAdjusterId(UUID.fromString(adjusterId));
    }

}
