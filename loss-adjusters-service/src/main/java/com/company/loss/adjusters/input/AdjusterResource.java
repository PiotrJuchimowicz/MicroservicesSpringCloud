package com.company.loss.adjusters.input;

import com.company.loss.adjusters.application.AdjusterManager;
import com.company.loss.adjusters.domain.bussiness.AdjusterRemovalException;
import com.company.loss.dto.AdjusterAddressDto;
import com.company.loss.dto.AdjusterDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adjusters")
class AdjusterResource {

    private final AdjusterManager adjusterManager;

    AdjusterResource(AdjusterManager adjusterManager) {
        this.adjusterManager = adjusterManager;
    }

    @PostMapping
    void save(@RequestBody AdjusterDto adjuster) {
        adjusterManager.save(adjuster);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> remove(@PathVariable("id") String id) {
        try {
            adjusterManager.remove(id);
            return ResponseEntity.ok().build();
        } catch (AdjusterRemovalException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<AdjusterDto> getOne(@PathVariable("id") String id) {
        Optional<AdjusterDto> adjusterDto = adjusterManager.getOne(id);
        return adjusterDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    List<AdjusterDto> getAll() {
       return adjusterManager.get();
    }

    @PatchMapping("/address")
    void addAddress(@RequestParam("id") String id, @RequestBody AdjusterAddressDto addressDto) {
        adjusterManager.addAddress(id, addressDto);
    }
}
