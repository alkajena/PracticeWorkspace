package com.rest.resgistration.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Driver;
import com.rest.registration.dto.LogInDTO;
import com.rest.registration.dto.LogInWrapper;

@Repository
@PropertySource(value="classpath:application.properties")
public class LogInDao {
	
	String dbUrl=null;
	String userName=null;
	String password=null;
	Driver driverClass=null;

	@Autowired
	Environment env;
	
	@PostConstruct
	public void init() throws SQLException{
		dbUrl=env.getProperty("spring.datasource.url");
		userName=env.getProperty("spring.datasource.username");
		password=env.getProperty("spring.datasource.password");
		driverClass= new com.mysql.jdbc.Driver();
	}
	
	public boolean validateCredential(String userName, String password) {
		SimpleDriverDataSource dataSource=new SimpleDriverDataSource();
		dataSource.setDriver(driverClass);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		dataSource.setUrl(dbUrl);
		JdbcTemplate template=new JdbcTemplate(dataSource);
		String sql="SELECT * FROM lOGIN";
		List<LogInDTO> dtoList=template.query(sql, new LogInWrapper());
		for(LogInDTO dto:dtoList){
			if(dto.getUserName().equals("userName") && dto.getPassword().equals("password")){
				return true;
			}
		}
		return false;
	}
	
	

}
