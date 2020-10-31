package com.company.loss.management.input;

import com.company.loss.dto.LossDto;
import com.company.loss.management.application.LossManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/loss")
class LossResource {

    private final LossManager manager;

    LossResource(LossManager manager) {
        this.manager = manager;
    }

    @PostMapping("/new")
    void create(@RequestBody LossDto loss, @RequestParam("adjusterId") String adjusterId) {
        manager.create(loss, adjusterId);
    }

    @PutMapping("/proceed")
    void proceed(@RequestParam("lossId") String lossId, @RequestParam("adjusterId") String adjusterId) {
        manager.proceed(lossId, adjusterId);
    }

    @PutMapping("/close")
    void close(@RequestParam("lossId") String lossId, @RequestParam("adjusterId") String adjusterId) {
        manager.close(lossId, adjusterId);
    }

    @GetMapping
    ResponseEntity<LossDto> getOne(@RequestParam("lossId") String lossId) {
        return manager.getOne(lossId).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    List<LossDto> get() {
        return manager.get();
    }

    @GetMapping("/exist-losses-by-adjuster")
    ResponseEntity<Boolean> existLossesByAdjuster(@RequestParam("adjusterId") String adjusterId) {
        return ResponseEntity.ok(manager.existLossesByAdjuster(adjusterId));
    }

}
