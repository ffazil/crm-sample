package com.tracebucket.crm.test.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by sadath on 23-Jan-15.
 */
@Configuration
@ComponentScan(basePackages = {"com.tracebucket.crm.service.impl"}, scopedProxy = ScopedProxyMode.INTERFACES)
@EnableTransactionManagement(proxyTargetClass = true)
public class ServiceTestConfig {
    @Bean
    public Mapper mapper() {
        return new DozerBeanMapper();
    }

    @Bean
    public ObjectMapper objectMapper()
    {
        return new ObjectMapper();
    }
}
