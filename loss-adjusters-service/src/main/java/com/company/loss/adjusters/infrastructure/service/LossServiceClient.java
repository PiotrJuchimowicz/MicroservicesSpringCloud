package com.company.loss.adjusters.infrastructure.service;

import com.company.loss.adjusters.domain.port.outgoing.LossConnector;
import org.springframework.stereotype.Component;

@Component
class LossServiceClient implements LossConnector {

    private final LossServiceFeignClient feignClient;

    LossServiceClient(LossServiceFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    @Override
    public boolean existLossesByAdjuster(String adjusterId) {
        return feignClient.existLosesByAdjuster(adjusterId);
    }
}
