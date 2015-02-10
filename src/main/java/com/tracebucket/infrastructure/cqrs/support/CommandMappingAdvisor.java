package com.tracebucket.infrastructure.cqrs.support;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * Created by ffl on 10-02-2015.
 */
@Aspect
@Configurable
public class CommandMappingAdvisor {
    private static Logger log = LoggerFactory.getLogger(CommandMappingAdvisor.class);

    @Autowired
    private CommandControllerHelper commandControllerHelper;

    @AfterReturning(value = "@annotation(com.tracebucket.infrastructure.cqrs.annotation.CommandMapping)", returning = "result")
    public void publishEvent(JoinPoint joinPoint, Object result){
        log.info(result.toString());
    }
}
