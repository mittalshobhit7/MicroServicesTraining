
package com.firstproject2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.firstproject2.model.Employee;
import com.firstproject2.repositories.EmployeeRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@RestController
public class TestController {

	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@RequestMapping(value="/employee",method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod="getDataFallBack")
	public List<Employee> getAllEmployees(){
		Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC,"createdAt");
		return employeeRepository.findAll(sortByCreatedAtDesc);
	}
	
	@RequestMapping(value = "/employee1", method = RequestMethod.GET)
	public Employee firstPage() {
		
		Employee emp = new Employee();
//		emp.setName("empl");
//		emp.setDesignation("manager");
//		emp.setEmpId("1");
//		emp.setSalary(3000);
//		
		return emp;
	}
	
	public Employee getDataFallBack(){
		Employee emp = new Employee();
		emp.setName("fallback-ep1");
		emp.setCity("fallback-manager");
		
		emp.setEmail("fallback-1");
		
		return emp;
	}
} 
