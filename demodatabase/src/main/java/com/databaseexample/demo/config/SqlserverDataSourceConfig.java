package com.databaseexample.demo.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SqlserverDataSourceConfig {


    @ConfigurationProperties("spring.datasource.sqlserver")
    @Bean
    public DataSourceProperties sqlserverDataSourceProperties()
    {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource sqlserverDataSource(){
        return sqlserverDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
