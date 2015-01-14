package com.tracebucket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.HttpStatus;

/**
 * Created by ffl on 08-01-2015.
 */
@Configuration
@ComponentScan(basePackages = "com.tracebucket.config")
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)
@EnableAutoConfiguration
public class AppStarter {

    @Value("${server.contextPath}")
    private String contextPath;

    @Value("${server.port:8080}")
    private String port;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(Integer.valueOf(port));
        factory.setContextPath(contextPath);
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notfound.html"));
        return factory;
    }



    public static void main(String[] args) {
        SpringApplication.run(AppStarter.class, args);
    }
}
