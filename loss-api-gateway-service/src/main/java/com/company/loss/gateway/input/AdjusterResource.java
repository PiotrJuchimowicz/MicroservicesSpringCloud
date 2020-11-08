package com.company.loss.gateway.input;

import com.company.loss.dto.AdjusterAddressDto;
import com.company.loss.dto.AdjusterDto;
import com.company.loss.gateway.infrastructure.client.AdjustersFeignClient;
import com.company.loss.gateway.input.dto.IdDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/adjusters")
public class AdjusterResource {

    private final AdjustersFeignClient feignClient;

    AdjusterResource(AdjustersFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    @PostMapping
    public void save(@RequestBody AdjusterDto adjuster) {
       feignClient.save(adjuster);
    }

    @DeleteMapping
    public ResponseEntity<String> remove(@RequestBody IdDto id) {
        return feignClient.remove(id.value());
    }

    @GetMapping
    public ResponseEntity<AdjusterDto> getOne(@RequestBody IdDto id) {
        return feignClient.getOne(id.value());
    }

    @GetMapping("/all")
    public List<AdjusterDto> getAll() {
       return feignClient.getAll();
    }

    @PatchMapping("/address")
    public void addAddress(@RequestBody IdDto id, @RequestBody AdjusterAddressDto addressDto) {
        feignClient.addAddress(id.value(), addressDto);
    }
}
