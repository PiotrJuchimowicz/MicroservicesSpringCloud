package com.company.loss.adjusters.domain.port.outgoing;

public interface LossConnector {

    boolean existLossesByAdjuster(String adjusterId);
}
