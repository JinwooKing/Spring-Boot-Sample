package com.databaseexample.demo.repository.oracle;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.databaseexample.demo.entity.WeatherData;

public interface OracleTestRepository extends JpaRepository<WeatherData, Long> {

}
