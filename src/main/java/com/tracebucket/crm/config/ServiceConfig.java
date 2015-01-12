package com.tracebucket.crm.config;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import reactor.core.Environment;
import reactor.core.Reactor;
import reactor.core.spec.Reactors;
import reactor.spring.context.config.EnableReactor;

/**
 * Created by vishwa on 24-11-2014.
 */
@Configuration
@ComponentScan(basePackages = {"com.tracebucket.crm.service.impl"}, scopedProxy = ScopedProxyMode.INTERFACES)
@EnableTransactionManagement(proxyTargetClass = true)
public class ServiceConfig {



}
