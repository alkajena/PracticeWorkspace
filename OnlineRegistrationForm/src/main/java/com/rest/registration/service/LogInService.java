package com.rest.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.resgistration.dao.LogInDao;

@Service
public class LogInService {
	
	@Autowired
	LogInDao dao;
	
	public boolean validateCredential(String userName,String password){
		return dao.validateCredential(userName,password);
	}

}
