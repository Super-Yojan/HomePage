package com.joarch.User.Dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import com.joarch.User.Dao.UserDao;
import com.joarch.User.model.User;

@Component("userDao")
public class UserDaoImpl implements UserDao {

	ApplicationContext context = new ClassPathXmlApplicationContext("com/joarch/User/Dao/impl/config.xml");

	JdbcTemplate template = (JdbcTemplate) context.getBean("jdbcTemplate");

	public List<User> getUserForLogin(final User user) {
		String sql = "select * from user where userName=? and password=? ";
		List<User> result = template.query(sql, new PreparedStatementSetter() {

			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, user.getUserName());
				ps.setString(2, user.getUserPass());

			}
		}, new UserRowMapper());
		// System.out.println(result);
		return result;
	}

	public int addUser(User user) {

		System.out.println("im at user Dao impl addUser");
		String sql = "insert into user values(?,?,?,?,?,?,?,?)";
		int result = template.update(sql, user.getEmail(), user.getFirstName(), user.getLastName(), user.getUserName(),
				user.getPhoneNo(), user.getUserPass(), user.isActive(),user.getHascode());
		System.out.println(result);
		return result;
	}

	public User getUser(final String email) {
		String sql = "select * from user where email=?";
		List<User> result = template.query(sql, new PreparedStatementSetter() {

			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, email);
			}
		}, new UserRowMapper());

		if (result.isEmpty()) {
			return null;
		} else {
			return result.get(0);
		}
	}

	public int activate(final String key1, final String key2) {
		String sql ="select * from user where email=? and hashcode=?";
		List<User> result = template.query(sql, new PreparedStatementSetter() {

			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, key1);
				ps.setString(2, key2);
			}
			
		}, new UserRowMapper());
		if(!result.isEmpty()) {
			String sql2 = "update user set verified='1' where email=? and hashcode=?";
			int activate = template.update(sql2,key1,key2);
			return activate;
		}
	
		return 0;
	
	}

}
