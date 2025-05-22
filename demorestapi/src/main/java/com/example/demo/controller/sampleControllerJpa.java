package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.service.sampleServiceJpa;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@Slf4j
public class sampleControllerJpa {
    
    @Autowired
    private sampleServiceJpa sampleServiceJpa;

    @GetMapping("/health2")
    public String getHealth() {
        return "Hello World!";
    }

    @GetMapping("/employee2")
    public List<EmployeeEntity> getEmployeeList() {
        return sampleServiceJpa.getEmployeeList();
    }

    @GetMapping("/empoloyee2/{id}")
    public EmployeeEntity getEmployeeByIdJpa(@PathVariable int id) {
        return sampleServiceJpa.getEmpoloyeeByIdJpa(id);
    }

    @PostMapping("/employee2")
    public String insertEmployeeJpa(@RequestBody EmployeeEntity employee) {
        sampleServiceJpa.insertEmployeeJpa(employee);
        return "ok";
    }

    @PutMapping("/employee2")
    public String updateEmployeeJpa(@RequestBody EmployeeEntity employee) {
        sampleServiceJpa.updateEmployeeJpa(employee);
        return "ok";
    }

    @DeleteMapping("/employee2")
    public String deleteEmployeeJpa(@RequestBody int id) {
        sampleServiceJpa.deleteEmployeeJpa(id);
        return "ok";
    }
}
