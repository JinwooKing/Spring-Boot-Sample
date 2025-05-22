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
    basePackages = { "com.databaseexample.demo.repository.oracle" }
        ,entityManagerFactoryRef = "oraclEntityManagerFactoryBean"    
        ,transactionManagerRef = "oracleTransactionManager"
)
public class OracleEntityManagerConfig {

    @Bean
    LocalContainerEntityManagerFactoryBean oraclEntityManagerFactoryBean
        (EntityManagerFactoryBuilder entityManagerFactoryBuilder
            ,@Qualifier("oracleDataSource") DataSource dataSource)
    {
        return entityManagerFactoryBuilder
                    .dataSource(dataSource)
                    .packages("com.databaseexample.demo.entity")
                    .build();
    }

    @Bean
    PlatformTransactionManager oracleTransactionManager(@Qualifier("oraclEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean emfb)
    {
        return new JpaTransactionManager(emfb.getObject());
    }
}
