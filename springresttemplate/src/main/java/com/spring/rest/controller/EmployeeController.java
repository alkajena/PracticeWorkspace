package com.spring.rest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.rest.config.RestConfig;
import com.spring.rest.dto.Employee;
import com.spring.rest.dto.EmployeeResponse;
import com.spring.rest.service.EmployeeService;

@RestController
@RequestMapping("/Employee")
@PropertySource(value="classpath:application.properties")
public class EmployeeController {
	
	@Autowired
	RestConfig config;
	
	@Autowired
	Environment env;
	
	@Autowired
	EmployeeService service;
	
	@RequestMapping(value="/getEmployee",method=RequestMethod.GET)
	public EmployeeResponse getAllEmployeeRestClient(){
		EmployeeResponse response=null;
		ObjectMapper mapper=new ObjectMapper();
		String result= config.getRestTemplate().getForObject(env.getProperty("getEmployees.url"), String.class);
		try {
			response=mapper.readValue(result, EmployeeResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@RequestMapping(value="/getEmployeeById/{id}",method=RequestMethod.GET)
	public EmployeeResponse getEmployeeByIdRestClient(@PathVariable int id){
		EmployeeResponse response=null;
		ObjectMapper mapper=new ObjectMapper();
		String result= config.getRestTemplate().getForObject((env.getProperty("getEmployeeById.url"))+"/"+id, String.class);
		try {
			response=mapper.readValue(result, EmployeeResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@RequestMapping(value="/postEmployee",method=RequestMethod.POST)
	public EmployeeResponse createEmployee(@RequestBody Employee emp){
		EmployeeResponse response=null;
		ObjectMapper mapper=new ObjectMapper();
		String result= config.getRestTemplate().postForObject((env.getProperty("postEmployee.url")),emp,String.class);
		try {
			response=mapper.readValue(result, EmployeeResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@SuppressWarnings("null")
	@RequestMapping(value="/getEmployeeData",method=RequestMethod.GET)
	public EmployeeResponse getAllEmployee(){
		EmployeeResponse response=null;
		List<Employee> list=service.getAllemployee();
		if(list!=null){
			response=new EmployeeResponse();
			response.setStatus("success");
			response.setEmp(list);
		}
		return response;
	}
	
	@SuppressWarnings("null")
	@RequestMapping(value="/getEmployeeByIdData/{id}",method=RequestMethod.GET)
	public EmployeeResponse getEmployeeById(@PathVariable int id){
		EmployeeResponse response=null;
		List<Employee> list=service.getEmployeeById(id);
		if(list!=null){
			response=new EmployeeResponse();
			response.setStatus("success");
			response.setEmp(list);
		}
		return response;
	}
	
	@SuppressWarnings("null")
	@RequestMapping(value="/postEmployeeData",method=RequestMethod.POST)
	public EmployeeResponse createEmployeeData(@RequestBody Employee emp){
		EmployeeResponse response=null;
		List<Employee> list=service.CreateEmployee(emp);
		if(list!=null){
			response=new EmployeeResponse();
			response.setStatus("success");
			response.setEmp(list);
		}
		return response;
	}
}
