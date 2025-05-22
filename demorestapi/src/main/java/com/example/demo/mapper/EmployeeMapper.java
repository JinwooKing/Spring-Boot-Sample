package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {

    //#region sample code for ibatis 
    ArrayList<HashMap<String, Object>> getEmployeeList();

    HashMap<String, Object> getEmployeeById(HashMap<String, Object> paramMap);

    void insertEmployee(HashMap<String, Object> paramMap);

    void updateEmployee(HashMap<String, Object> paramMap);

    void deleteEmployee(HashMap<String, Object> paramMap);
    //#endregion
}
