package com.example.demo.dto;

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
