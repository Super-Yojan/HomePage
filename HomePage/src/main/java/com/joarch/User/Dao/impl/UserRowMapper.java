package com.joarch.User.Dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.joarch.User.model.User;


public class UserRowMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setEmail(rs.getString(1));
		user.setFirstName(rs.getString(2));
		user.setLastName(rs.getString(3));
		user.setPhoneNo(rs.getString(5));
		user.setUserName(rs.getString(4));
		user.setUserPass(rs.getString(6));
		user.setActive(rs.getBoolean(7));
		user.setHascode(rs.getString(8));
		return user;
	}

	

}
