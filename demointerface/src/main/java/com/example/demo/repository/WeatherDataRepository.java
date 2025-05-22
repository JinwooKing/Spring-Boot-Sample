package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.WeatherData;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
}
