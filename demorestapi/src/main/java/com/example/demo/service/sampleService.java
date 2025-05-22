package com.example.demo.service;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.mapper.EmployeeMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class sampleService {

    @Autowired
    private EmployeeMapper employeeMapper;

    //#region Sample code for ibatis ibatis
    public List<EmployeeDto> getEmployeeList() {
        List<HashMap<String, Object>> response = employeeMapper.getEmployeeList();
        List<EmployeeDto> employeeList = new ArrayList<EmployeeDto>();

        for (HashMap<String, Object> item : response) {
            EmployeeDto employee = new EmployeeDto();
            employee.setId((int)item.get("ID"));
            employee.setName((String)item.get("NAME"));
            employee.setDescription((String)item.get("DESCRIPTION"));
            employeeList.add(employee);
        }
        
        return employeeList;
    }
    
    public EmployeeDto getEmployeeById(String id) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        
        HashMap<String, Object> response = employeeMapper.getEmployeeById(paramMap);

        EmployeeDto employee = new EmployeeDto();
        employee.setId((int)response.get("ID"));
        employee.setName((String)response.get("NAME"));
        employee.setDescription((String)response.get("DESCRIPTION"));    
        
        return employee;
    }

    public void insertEmployee(EmployeeDto employee) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", employee.getId());
        paramMap.put("name", employee.getName());
        paramMap.put("description", employee.getDescription());
        employeeMapper.insertEmployee(paramMap);
    }

    public void updateEmployee(EmployeeDto employee) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", employee.getId());
        paramMap.put("name", employee.getName());
        paramMap.put("description", employee.getDescription());
        employeeMapper.updateEmployee(paramMap);
    }

    public void deleteEmployee(String id) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        employeeMapper.deleteEmployee(paramMap);
    }

    //#endregion
    //#region Sample Code
    public boolean registerItem(EmployeeDto itemDto) {
        log.info("service running");
        log.info("Item registered: " + itemDto.toString());

        //Todo: Implement the logic to register the item
        return true;
    }
    //#endregion
    
}
