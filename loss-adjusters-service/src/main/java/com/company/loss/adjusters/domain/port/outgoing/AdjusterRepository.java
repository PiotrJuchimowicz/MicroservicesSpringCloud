package com.company.loss.adjusters.domain.port.outgoing;

import com.company.loss.adjusters.domain.bussiness.Adjuster;

import java.util.Optional;
import java.util.Set;

public interface AdjusterRepository {

    void save(Adjuster adjuster);

    Optional<Adjuster> getOne(String id);

    Set<Adjuster> get();

    void remove(String id);
}
