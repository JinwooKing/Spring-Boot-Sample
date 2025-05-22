package com.databaseexample.demo.repository.postgre;

import org.springframework.data.jpa.repository.JpaRepository;

import com.databaseexample.demo.entity.WeatherData;

public interface PostgreTestRepository extends JpaRepository<WeatherData, Long> { 
   
} 
