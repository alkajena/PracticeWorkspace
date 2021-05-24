package com.spring.rest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import com.spring.rest.dto.Employee;


@Repository
@PropertySource(value="classpath:application.properties")
public class EmployeeDao {
	
	String driver=null;
	String dburl=null;
	String userName=null;
	String password=null;
	@Autowired
	private Environment env;
	
	@PostConstruct
	public void init(){
		 driver=env.getProperty("spring.datasource.driver-class-name");
		 dburl=env.getProperty("spring.datasource.url");
		 userName=env.getProperty("spring.datasource.username");
		 password=env.getProperty("spring.datasource.password");
	}
		
	
	public List<Employee> getAllEmployee(){
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		List<Employee> list=new ArrayList<Employee>();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(dburl, userName, password);
			String sql="select * from employee LIMIT 0,1000";
			 st=con.createStatement();
			 rs=st.executeQuery(sql);
			while(rs.next()){
				Employee em=new Employee();
				
				em.setId(rs.getInt(1));
				em.setName(rs.getString(2));
				em.setSalary(rs.getInt(3));
				em.setDept(rs.getString(4));
				list.add(em);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<Employee> getEmployeeById(int id){
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		Employee em=new Employee();
		List<Employee> list=new ArrayList<>();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(dburl, userName, password);
			String sql="select * from employee where id = ?";
			 st=con.prepareStatement(sql);
			 st.setInt(1, id);
			 rs=st.executeQuery();
			if(rs.next()){
				em.setId(rs.getInt(1));
				em.setName(rs.getString(2));
				em.setSalary(rs.getInt(3));
				em.setDept(rs.getString(4));
				list.add(em);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	 public List<Employee> CreateEmployee(Employee emp){
		 Connection con=null;
			PreparedStatement st=null;
			Employee em=new Employee();
			List<Employee> list=new ArrayList<>();
			try {
				Class.forName(driver);
				con=DriverManager.getConnection(dburl, userName, password);
				String sql="insert into employee values(?,?,?,?)";
				 st=con.prepareStatement(sql);
				 st.setInt(1, emp.getId());
				 st.setString(2, emp.getName());
				 st.setInt(3, emp.getSalary());
				 st.setString(4, emp.getDept());
				 int x=st.executeUpdate();
				list.add(emp);
				st.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return list;
	 }
}
