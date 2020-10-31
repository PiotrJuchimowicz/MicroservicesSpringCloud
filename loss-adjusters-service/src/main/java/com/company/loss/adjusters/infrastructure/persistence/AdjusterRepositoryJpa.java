package com.company.loss.adjusters.infrastructure.persistence;

import com.company.loss.adjusters.domain.port.outgoing.AdjusterRepository;
import com.company.loss.adjusters.domain.bussiness.Adjuster;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
class AdjusterRepositoryJpa implements AdjusterRepository {

    private final AdjusterSpringRepository repository;

    AdjusterRepositoryJpa(AdjusterSpringRepository repository) {
        this.repository = repository;
    }

    public void save(Adjuster adjuster) {
        repository.save(adjuster);
    }

    @Override
    public Optional<Adjuster> getOne(String id) {
        return repository.findById(UUID.fromString(id));
    }

    @Override
    public Set<Adjuster> get() {
        return new HashSet<>(repository.findAll());
    }

    @Override
    public void remove(String id) {
        repository.deleteById(UUID.fromString(id));
    }

}
