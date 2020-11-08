package com.company.loss.gateway.infrastructure.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution (* com.company.loss.gateway.input..*(..))")
    public void log(JoinPoint joinPoint) {
        log.info("Received request {}", joinPoint.getArgs());
    }
}
