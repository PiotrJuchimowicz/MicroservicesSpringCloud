package com.company.loss.management.domain.port.outgoing;

import com.company.loss.management.domain.business.Loss;

import java.util.Optional;
import java.util.Set;

public interface LossRepository {

    void save(Loss loss);

    Optional<Loss> getOne(String id);

    Set<Loss> get();

    Set<Loss> getLossesByAdjuster(String adjusterId);
}
