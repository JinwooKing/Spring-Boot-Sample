package com.databaseexample.demo.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class OracleDataSourceConfig {

    @ConfigurationProperties("spring.datasource.oracle")
    @Bean
    public DataSourceProperties oracleDataSourceProperties()
    {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public DataSource oracleDataSource() {
        return oracleDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
