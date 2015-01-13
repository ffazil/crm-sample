package com.tracebucket.crm.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.beans.PropertyVetoException;

/**
 * User: ffl
 * Date: 4/3/14
 * Time: 4:00 PM
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.tracebucket.crm.repository.jpa", "com.tracebucket.infrastructure.ddd.repository.jpa"})
@EntityScan(basePackages = {"com.tracebucket.crm.common", "com.tracebucket.infrastructure.ddd.common"})
@PropertySource(value = "classpath:jpa.properties")
@EnableTransactionManagement(proxyTargetClass = true)
public class JPAConfig {
    private static final Logger log = LoggerFactory.getLogger(JPAConfig.class);

    @Value("${connection.driver_class}")
    private String driverClass;
    @Value("${connection.url}")
    private String jdbcUrl;
    @Value("${connection.username}")
    private String user;
    @Value("${connection.password}")
    private String password;
    @Value("${minPoolSize}")
    private String minPoolSize;
    @Value("${maxPoolSize}")
    private String maxPoolSize;
    @Value("${checkoutTimeout}")
    private String checkoutTimeout;
    @Value("${maxStatements}")
    private String maxStatements;
    @Value("${idleConnectionTestPeriod}")
    private String idleConnectionTestPeriod;
    @Value("${preferredTestQuery}")
    private String preferredTestQuery;
    @Value("${dialect}")
    private String dialect;
    @Value("${show_sql}")
    private String showSql;
    @Value("${generateDdl}")
    private String generateDdl;

    @Bean
    public HikariDataSource dataSource() throws PropertyVetoException
    {
        HikariConfig config = new HikariConfig();
        config.setMaximumPoolSize(Integer.parseInt(maxPoolSize));
        config.setDriverClassName(driverClass);
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(user);
        config.setPassword(password);

        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter()
    {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(Boolean.parseBoolean(showSql));
        jpaVendorAdapter.setGenerateDdl(Boolean.parseBoolean(generateDdl));
        jpaVendorAdapter.setDatabasePlatform(dialect);
        return jpaVendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException
    {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws PropertyVetoException
    {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        return factoryBean;
    }
}
