package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repository.EmpolyeeRepository;

@Service
public class sampleServiceJpa {

    @Autowired
    private EmpolyeeRepository employeeRepository;

    public List<EmployeeEntity> getEmployeeList() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity getEmpoloyeeByIdJpa(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void insertEmployeeJpa(EmployeeEntity employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployeeJpa(EmployeeEntity employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployeeJpa(int id) {
        employeeRepository.deleteById(id);
    }
}
