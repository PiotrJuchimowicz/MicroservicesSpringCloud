package com.company.loss.demo;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DiscoveryApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DiscoveryApplication.class)
                .web(WebApplicationType.NONE).run(args);
    }

}
