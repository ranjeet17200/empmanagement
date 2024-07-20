package com.empmanagement.empmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empmanagement.empmanagement.model.Employee;



@Repository 
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
      
}
