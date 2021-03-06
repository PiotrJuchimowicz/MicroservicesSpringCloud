package com.company.loss.messaging;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EnableRabbit
public class NotificationApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(NotificationApplication.class).web(WebApplicationType.SERVLET).run(args);
    }

}
