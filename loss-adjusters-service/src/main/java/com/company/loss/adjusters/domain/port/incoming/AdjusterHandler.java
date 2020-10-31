package com.company.loss.adjusters.domain.port.incoming;

import com.company.loss.adjusters.domain.bussiness.Adjuster;
import com.company.loss.adjusters.domain.bussiness.AdjusterAddress;

import java.util.Optional;
import java.util.Set;

public interface AdjusterHandler {

    void save(Adjuster adjuster);

    Optional<Adjuster> getOne(String id);

    Set<Adjuster> get();

    void remove(String id);

    void addAddress(String id, AdjusterAddress adjusterAddress);
}
