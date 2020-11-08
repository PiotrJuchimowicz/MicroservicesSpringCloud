package com.company.loss.gateway.infrastructure.client;

import com.company.loss.dto.LossDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("management-service/loss")
public interface LossManagementFeignClient {

    @PostMapping("/new")
    void create(@RequestBody LossDto loss, @RequestParam("adjusterId") String adjusterId);

    @PutMapping("/proceed")
    void proceed(@RequestParam("lossId") String lossId, @RequestParam("adjusterId") String adjusterId);

    @PutMapping("/close")
    void close(@RequestParam("lossId") String lossId, @RequestParam("adjusterId") String adjusterId);

    @GetMapping
    ResponseEntity<LossDto> getOne(@RequestParam("lossId") String lossId);

    @GetMapping("/all")
    List<LossDto> getAll();

    @GetMapping("/exist-losses-by-adjuster")
    ResponseEntity<Boolean> existLossesByAdjuster(@RequestParam("adjusterId") String adjusterId);
}
