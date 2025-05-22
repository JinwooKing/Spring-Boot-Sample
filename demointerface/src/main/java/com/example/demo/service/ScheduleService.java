package com.example.demo.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.EmployeeData;
import com.example.demo.entity.EmployeeDto;
import com.example.demo.entity.LottoData;
import com.example.demo.repository.WeatherDataRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ScheduleService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WeatherDataRepository weatherDataRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${weather.api.url}")
    private String apiUrl;

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${lotto.scheduler.enabled:false}")
    private boolean lottoSchedulerEnabled;
    

    //@Scheduled(fixedRate = 1000 * 5)
    public void fetchWeatherDataAPI() {
         try{
            String url = String.format("%s?ServiceKey=%s", apiUrl, apiKey);

            log.info(url); 
            String response = restTemplate.getForObject(url, String.class);
            log.info(response); 
            JsonNode root = objectMapper.readTree(response);
            
         }catch(Exception e){
             System.err.println("Error fetching weather data: " + e.getMessage());
         }
    }

    //@Scheduled(fixedRate = 1000 * 10)
    public void fetchWeatherDataDb() {
         try{
            weatherDataRepository.findAll().forEach(weatherData -> {
                log.info("Weather Data: " + weatherData.toString());
            });
            
         }catch(Exception e){
             System.err.println("Error fetching weather data: " + e.getMessage());
         }
    }

    //@Scheduled(fixedRate = 1000 * 5)
    public void fetchLottoDataAPI() {
        if (!lottoSchedulerEnabled) return; // 동작 차단

        try{
            String url = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=1";

            log.info(url); 
            LottoData lottoData = restTemplate.getForObject(url, LottoData.class);
            log.info(lottoData.toString());            

         }catch(Exception e){
             System.err.println("Error fetching Lotto data: " + e.getMessage());
         }
    }

    //@Scheduled(fixedRate = 1000 * 5)
    public void fetchEmployeeDataAPI() {
        try{
            String url = "http://localhost:8080/employee/1";

            log.info(url); 
            EmployeeData employeeData = restTemplate.getForObject(url, EmployeeData.class);
            log.info(employeeData.toString());            

         }catch(Exception e){
             System.err.println("Error fetching Employee data: " + e.getMessage());
         }
    }

    //@Scheduled(fixedRate = 1000 * 5)
    public void fetchEmployeesDataAPI() {
        try{
            String url = "http://localhost:8080/employee";

            log.info(url); 
            EmployeeData[] employeeDatas = restTemplate.getForObject(url, EmployeeData[].class);
            for(EmployeeData employeeData : employeeDatas) {
                log.info(employeeData.toString());
            }

         }catch(Exception e){
             System.err.println("Error fetching Employee data: " + e.getMessage());
         }
    }

    //@Scheduled(fixedRate = 1000 * 1000)
    public void InsertEmployeeDataAPI() {
        try{
            String url = "http://localhost:8080/employee";

            log.info(url); 

            EmployeeDto employee = new EmployeeDto();
            employee.setId(1);
            employee.setName("jinwoo");
            employee.setDescription("devloper");

            HttpHeaders headers = new org.springframework.http.HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<EmployeeDto> request = new HttpEntity<>(employee, headers);
            
            String response = restTemplate.postForObject(url, request, String.class);
                log.info(response);

         }catch(Exception e){
             System.err.println("Error fetching Employee data: " + e.getMessage());
         }
    }
}
