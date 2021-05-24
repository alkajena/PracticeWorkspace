package com.rest.registration.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rest.registration.dto.LogInDTO;
import com.rest.registration.service.LogInService;
import com.rest.resgistration.dao.LogInDao;

@RestController
@PropertySource(value="classpath:application.properties")
public class LogInController {
	
	@Autowired
	Environment env;
	
	
	@Autowired
	LogInService logInservice;
	
	@Autowired
	LogInDao logInDao;
	/*@RequestMapping(value="/LogIn",method=RequestMethod.GET)
	public String validateCredential(@RequestParam(value = "UserName") String userName,@RequestParam(value="Password") String password){
		if(userName!=null && password!=null){
			return "success";
		}
		return "failure";
	}*/
	/*@RequestMapping(value="/LogIn",method=RequestMethod.GET)
	public String validateCredential(HttpServletRequest request){
		Object userName=request.getParameter("UserName");
		Object password=request.getParameter("Password");
		if(userName!=null && password!=null){
			return "success";
		}
		return "failure";
	}*/
	
	@RequestMapping(value="/LogIn",method=RequestMethod.GET)
	public ModelAndView validateCredential(@ModelAttribute ("LogInDTO") LogInDTO dto){
		if(dto.getUserName()!=null && dto.getPassword()!=null){
			String userName=dto.getUserName();
			String password=dto.getPassword();
			
			boolean valid=logInservice.validateCredential(userName, password);
			if(valid){
				List<String> degreeList=new ArrayList<>();
				String degreeListString=env.getProperty("DegreeList");
				degreeList=Arrays.asList(degreeListString.split(","));
				ModelAndView mv=new ModelAndView();
				mv.addObject("DegreeList", degreeList);
				mv.setViewName("registrationForm");
				return mv;
			}
			//return "success";
		}
		ModelAndView mv=new ModelAndView();
		mv.addObject("failure");
		return mv;
	}

}
