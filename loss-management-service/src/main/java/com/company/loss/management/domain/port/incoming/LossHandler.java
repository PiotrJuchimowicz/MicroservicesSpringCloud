package com.company.loss.management.domain.port.incoming;

import com.company.loss.management.domain.business.Loss;

import java.util.Optional;
import java.util.Set;

public interface LossHandler {

    void create(Loss loss);

    void proceed(String lossId, String adjusterId);

    void close(String lossId, String adjusterId);

    Optional<Loss> getOne(String id);

    Set<Loss> get();

    Boolean existLossesByAdjuster(String adjusterId);
}
