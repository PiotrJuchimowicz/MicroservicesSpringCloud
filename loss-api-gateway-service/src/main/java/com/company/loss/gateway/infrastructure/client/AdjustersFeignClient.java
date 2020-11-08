package com.company.loss.gateway.infrastructure.client;

import com.company.loss.dto.AdjusterAddressDto;
import com.company.loss.dto.AdjusterDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("adjusters-service/adjusters")
public interface AdjustersFeignClient {

    @PostMapping
    void save(@RequestBody AdjusterDto adjuster);

    @DeleteMapping("/{id}")
    ResponseEntity<String> remove(@PathVariable("id") String id);

    @GetMapping("/{id}")
    ResponseEntity<AdjusterDto> getOne(@PathVariable("id") String id);

    @GetMapping
    List<AdjusterDto> getAll();

    @PatchMapping("/address")
    void addAddress(@RequestParam("id") String id, @RequestBody AdjusterAddressDto addressDto);
}
