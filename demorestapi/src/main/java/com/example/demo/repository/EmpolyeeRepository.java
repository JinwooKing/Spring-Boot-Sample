package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmpolyeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    
}
