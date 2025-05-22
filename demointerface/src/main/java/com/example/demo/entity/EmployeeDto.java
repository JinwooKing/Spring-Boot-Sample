package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

public class EmployeeDto {
    @Getter
    @Setter
    private int id;  

    @Getter
    @Setter
    private String name;   
    
    @Getter
    @Setter
    private String description;
}
