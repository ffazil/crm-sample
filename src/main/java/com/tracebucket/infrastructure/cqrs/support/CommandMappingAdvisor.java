package com.tracebucket.infrastructure.cqrs.support;

import com.tracebucket.infrastructure.cqrs.annotation.CommandMapping;
import com.tracebucket.infrastructure.ddd.annotation.PersistChanges;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Method;
import java.util.Arrays;

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
        Object[] args = joinPoint.getArgs();
        CommandWrapper commandWrapper = (CommandWrapper) Arrays.asList(args).stream()
                .filter(a -> a instanceof CommandWrapper)
                .findFirst()
                .get();
        Command command = commandWrapper.getCommand();

        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method method = ms.getMethod();
        CommandMapping annotation = AnnotationUtils.getAnnotation(method, CommandMapping.class);

        log.info(command.getData().toString());
        log.info(annotation.toString());
    }
}
