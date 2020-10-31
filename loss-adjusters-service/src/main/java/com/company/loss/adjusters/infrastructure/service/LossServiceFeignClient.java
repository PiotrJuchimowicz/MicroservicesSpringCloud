package com.company.loss.adjusters.infrastructure.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
//todo Piotr service discovery
@FeignClient(name = "loss-service", url = "http://localhost:8081/loss")
interface LossServiceFeignClient {

    @GetMapping("/exist-losses-by-adjuster")
    Boolean existLosesByAdjuster(@RequestParam("adjusterId") String adjusterId);
}
