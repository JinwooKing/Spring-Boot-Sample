package com.databaseexample.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.databaseexample.demo.entity.WeatherData;

public interface WeatherRepository extends JpaRepository<WeatherData, Long> {
        
} 