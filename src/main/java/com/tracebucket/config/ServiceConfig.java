package com.tracebucket.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by vishwa on 24-11-2014.
 */
@Configuration
@ComponentScan(basePackages = {"com.tracebucket.crm.service.impl"}, scopedProxy = ScopedProxyMode.INTERFACES)
@EnableTransactionManagement(proxyTargetClass = true)
public class ServiceConfig {



}
