package com.empmanagement.empmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empmanagement.empmanagement.dao.EmployeeRepository;
import com.empmanagement.empmanagement.model.Employee;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EmployeeController {
     
	@Autowired 
	private EmployeeRepository  employeeRepository;
	
	@PostMapping("/saveEmployee")
	 public String saveEmployee(@RequestBody  Employee employee ) {
		
		employeeRepository.save(employee);
		return "Data save successfully ";
	}
	
	@GetMapping("/getEmployeeDetails")
	public List<Employee> getEmployeeDetails(){
		
		return employeeRepository.findAll();
	}
	
	@GetMapping("/getEmployeeDetailsById/{empId}")
	public Optional<Employee> getEmployeeDetailsById(@PathVariable Integer empId) {
		
		return employeeRepository.findById(empId);
	}
	
	@DeleteMapping("/deleteEmployeeDetailsById/{empId}")
	public String deleteEmployeeDetailsById(@PathVariable Integer empId) {
		employeeRepository.deleteById(empId);
		return "Data deleted successfully";
	}
	
	@PutMapping("/updateEmployeeDetails")
	public void updateEmployeeDetails(@RequestBody Employee employee) {
		
		Employee employee1 = employeeRepository.findById(employee.getEmpId()).get();
		if(employee.getDeptName()!=null) {
			employee1.setDeptName(employee.getDeptName());
		}
		if(employee.getEmpName()!=null) {
			employee1.setEmpName(employee.getEmpName());

		}
		if(employee.getSalary() !=null) {
			employee1.setSalary(employee.getSalary());

		}
		
		employeeRepository.save(employee1);
		
	}
}
