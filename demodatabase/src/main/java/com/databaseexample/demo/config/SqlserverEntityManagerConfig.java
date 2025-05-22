package com.databaseexample.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
    basePackages = { "com.databaseexample.demo.repository.sqlserver" }
        ,entityManagerFactoryRef = "sqlserverEntityManagerFactoryBean"    
        ,transactionManagerRef = "sqlserverTransactionManager"
)
public class SqlserverEntityManagerConfig {

    @Bean
    LocalContainerEntityManagerFactoryBean sqlserverEntityManagerFactoryBean
    (EntityManagerFactoryBuilder entityManagerFactoryBuilder, @Qualifier("sqlserverDataSource") DataSource dataSource)
    {
        return entityManagerFactoryBuilder
                    .dataSource(dataSource)
                    .packages("com.databaseexample.demo.entity")
                    .build();
    }

    @Bean
    PlatformTransactionManager sqlserverTransactionManager(@Qualifier("sqlserverEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean emfb)
    {
        return new JpaTransactionManager(emfb.getObject());
    }
}
