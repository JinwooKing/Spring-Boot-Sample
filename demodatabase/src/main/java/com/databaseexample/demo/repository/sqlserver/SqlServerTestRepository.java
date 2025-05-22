package com.databaseexample.demo.repository.sqlserver;

import org.springframework.data.jpa.repository.JpaRepository;

import com.databaseexample.demo.entity.WeatherData;

public interface  SqlServerTestRepository extends JpaRepository<WeatherData, Long>{

}
