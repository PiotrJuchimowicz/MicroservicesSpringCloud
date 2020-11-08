package com.company.loss.configuration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HealthCheckResource {

    @GetMapping("/health-check")
    public ResponseEntity<String> healthCheck() {
        final String message = "configuration service is working";
        return ResponseEntity.ok(message);
    }

}
