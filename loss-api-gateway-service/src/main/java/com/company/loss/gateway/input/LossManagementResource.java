package com.company.loss.gateway.input;

import com.company.loss.dto.LossDto;
import com.company.loss.gateway.infrastructure.client.LossManagementFeignClient;
import com.company.loss.gateway.input.dto.IdDto;
import com.company.loss.gateway.input.dto.LossAdjusterDto;
import com.company.loss.gateway.input.dto.LossAdjusterIdsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/loss-management")
public class LossManagementResource {

    private final LossManagementFeignClient feignClient;

    LossManagementResource(LossManagementFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    @PostMapping("/new")
    public void create(@RequestBody LossAdjusterDto lossAdjusterDto) {
        feignClient.create(lossAdjusterDto.getLossDto(), lossAdjusterDto.getAdjusterId());
    }

    @PutMapping("/proceed")
    public void proceed(@RequestBody LossAdjusterIdsDto ids) {
        feignClient.proceed(ids.getLossId(), ids.getAdjusterId());
    }

    @PutMapping("/close")
    public void close(@RequestBody LossAdjusterIdsDto ids) {
        feignClient.close(ids.getLossId(), ids.getAdjusterId());
    }

    @GetMapping
    public ResponseEntity<LossDto> getOne(@RequestBody IdDto lossId) {
        return feignClient.getOne(lossId.value());
    }

    @GetMapping("/all")
    public List<LossDto> get() {
        return feignClient.getAll();
    }
}
