package com.tracebucket.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by vishwa on 26-11-2014.
 */
@Configuration
@ComponentScan(basePackages = {"com.tracebucket.**.rest.controller"})
@EnableWebMvc
public class WebConfig {
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
