package com.tracebucket.infrastructure.cqrs.support;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Arrays;

/**
 * Created by ffl on 17-02-2015.
 */
@Aspect
@Configurable
public class CommandHandlerAdvisor {
    private static Logger log = LoggerFactory.getLogger(CommandHandlerAdvisor.class);

    @Autowired
    private CommandControllerHelper commandControllerHelper;

    @AfterReturning(value = "@annotation(com.tracebucket.infrastructure.cqrs.annotation.CommandHandler)", returning = "result")
    public void linkAndReturn(JoinPoint joinPoint, Object result){
        Object[] args = joinPoint.getArgs();
        Command command = (Command) Arrays.asList(args).stream()
                .filter(a -> a instanceof Command)
                .findFirst()
                .get();
        log.info(command.getCid());
        DeferredResult deferredResult = commandControllerHelper.fetch(command.getCid());
        deferredResult.setResult(result);
    }
}
