package com.spring.rest.dto;

import java.util.List;

public class EmployeeResponse {
	
	private String status;
	private List<Employee> emp;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Employee> getEmp() {
		return emp;
	}
	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}
	
	
}
