package com.databaseexample.demo.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostgreDataSourceConfig {

    @ConfigurationProperties("spring.datasource.postgre")
    @Bean
    public DataSourceProperties postgreDataSourceProperties()
    {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource postgreDataSource() {
        return postgreDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
