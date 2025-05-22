package com.databaseexample.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.databaseexample.demo.repository.oracle.OracleTestRepository;
import com.databaseexample.demo.repository.postgre.PostgreTestRepository;
import com.databaseexample.demo.repository.sqlserver.SqlServerTestRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private OracleTestRepository oracleTestRepository;

	@Autowired
	private PostgreTestRepository postgreTestRepository;

	@Autowired
	private SqlServerTestRepository sqlServerTestRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		oracleTestRepository.findAll().forEach(oracleTest -> {
			System.out.println("Found oracleTest: " + oracleTest);
		});

		postgreTestRepository.findAll().forEach(postgreTest -> {
			System.out.println("Found postgreTest: " + postgreTest);
		});

		sqlServerTestRepository.findAll().forEach(sqlServerTest -> {
			System.out.println("Found sqlServerTest: " + sqlServerTest);
		});
	}
}
