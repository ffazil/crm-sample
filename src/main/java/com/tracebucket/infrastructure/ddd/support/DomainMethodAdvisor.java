package com.tracebucket.infrastructure.ddd.support;

import com.tracebucket.infrastructure.ddd.annotation.DomainMethod;
import com.tracebucket.infrastructure.ddd.domain.BaseAggregateRoot;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import java.lang.reflect.Method;

/**
 * @author FFL
 * @since 29-01-2015
 * @version 0.1
 *
 * DomainMethodAdvisor creates and adds domain events to a queue, whenever a domain method is intercepted.
 */
@Aspect
@Configurable
public class DomainMethodAdvisor {

    private static Logger log = LoggerFactory.getLogger(DomainMethodAdvisor.class);

    @Autowired
    private EventRegistry eventRegistry;



    /*@After("@annotation(com.tracebucket.infrastructure.ddd.annotation.DomainMethod)")
    public void invoke(JoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method m = ms.getMethod();

        DomainMethod method = m.getAnnotation(DomainMethod.class);
        String event = method.event();

        BaseAggregateRoot aggregateRoot = (BaseAggregateRoot) joinPoint.getTarget();
        aggregateRoot.fireEvent(event);

        log.info("Adding  " + event + " " + aggregateRoot.toString());
    }*/

    @After("@annotation(com.tracebucket.infrastructure.ddd.annotation.DomainMethod)")
    public void invoke(JoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method m = ms.getMethod();

        DomainMethod method = m.getAnnotation(DomainMethod.class);
        String event = method.event();

        BaseAggregateRoot aggregateRoot = (BaseAggregateRoot) joinPoint.getTarget();
        eventRegistry.addEvent(aggregateRoot, event);


    }
}
