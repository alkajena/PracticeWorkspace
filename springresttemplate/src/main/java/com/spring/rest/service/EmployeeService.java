package com.spring.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.dao.EmployeeDao;
import com.spring.rest.dto.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao dao;
	
	public List<Employee> getAllemployee(){
		return dao.getAllEmployee();
	}
	
	public List<Employee> getEmployeeById(int id){
		return dao.getEmployeeById(id);
	}
	
	public List<Employee> CreateEmployee(Employee emp){
		return dao.CreateEmployee(emp);
	}
}
