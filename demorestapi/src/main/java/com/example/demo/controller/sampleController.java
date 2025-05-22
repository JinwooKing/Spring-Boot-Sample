package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.sampleService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

/// This is a sample controller class that handles HTTP requests
/// @author JINWOO 
/// @version 1.0
/// @since 2025-04-17
@RestController
@Slf4j
public class sampleController {

    @Autowired
    private sampleService sampleService;

    @GetMapping("/health")
    public String getHealth() {
        return "Hello World!";
    }

    //#region Sample Code for ibatis
    @GetMapping("/employee")
    public List<EmployeeDto> getEmployeeList() {
        return sampleService.getEmployeeList();
    }

    @GetMapping("/employee/{id}")
    public EmployeeDto getEmployeeById(@PathVariable String id) {
        return sampleService.getEmployeeById(id);
    }

    @PostMapping("/employee")
    public String insertEmployee(@RequestBody EmployeeDto employee) {
        sampleService.insertEmployee(employee);
        return "ok";
    }

    @PutMapping("/employee")
    public String updateEmployee(@RequestBody EmployeeDto employee) {
        sampleService.updateEmployee(employee);
        return "ok";
    }

    @DeleteMapping("/employee")
    public String deleteEmployee(@RequestBody String id) {
        sampleService.deleteEmployee(id);
        return "ok";
    }
    
    //#endregion
    //#region Sample Code for Mapping
    // @GetMapping("/sample")
    // public String getSample(@RequestParam(value = "param", defaultValue = "default") String param) {
    //     log.info("Sample method called with param: " + param);
    //     return new String("Hello World! " + param);
    // }
    
    // @GetMapping("/sample2")
    // public String getSample2(@RequestParam String param) {
    //     log.info("Sample2 method called with param: " + param);
    //     return new String("Hello World! " + param);
    // }

    // @GetMapping("/sample3")
    // public String getSample3(@RequestParam("param") String param, @RequestParam("param2") String param2) {
    //     log.info("Member method called with param: " + param);
    //     log.info("Member method called with param2: " + param2);
    //     return "ok";
    // }

    // @GetMapping("/sample4/{param}")
    // public String getCompay(@PathVariable("param") String param) {
    //     log.info("Company method called with param: " + param);
    //     return new String(param);
    // }
    
    // @PostMapping("/sample5")
    // public String postItem(@RequestBody String item) {  
    //     log.info("Item method called with item: " + item);
    //     return item;
    // }
    
    // @PostMapping("/sample6")
    // public String postMethodName(@RequestBody EmployeeDto employee) {
    //     log.info("Item method called with item: " + employee.toString());
    //     return "ok";
    // }
    //#endregion
}
