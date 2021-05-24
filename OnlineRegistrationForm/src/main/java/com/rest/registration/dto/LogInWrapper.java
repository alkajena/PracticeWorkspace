package com.rest.registration.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LogInWrapper implements RowMapper<LogInDTO>{

	@Override
	public LogInDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		LogInDTO dto=new LogInDTO();
		dto.setUserName(rs.getString("userName"));
		dto.setPassword(rs.getString("password"));
		return dto;
	}

}
