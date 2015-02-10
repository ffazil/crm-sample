package com.tracebucket.crm.test.config;

import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import reactor.core.Environment;
import reactor.core.Reactor;
import reactor.core.spec.Reactors;
import reactor.spring.context.config.EnableReactor;

/**
 * Created by ffl on 12-01-2015.
 */
@Configuration
@EnableReactor
@EnableSpringConfigured
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.tracebucket.infrastructure.cqrs.support", "com.tracebucket.infrastructure.event.domain", "com.tracebucket.infrastructure.ddd.support", "com.tracebucket.infrastructure.ddd.domain"})
public class InfrastructureTestConfig {

    @Bean
    public Reactor commandBus(Environment env) {
        // implicit Environment is injected into bean def method
        return Reactors.reactor().env(env).get();
    }

    @Bean
    public Reactor eventBus(Environment env) {
        // implicit Environment is injected into bean def method
        return Reactors.reactor().env(env).get();
    }


}
