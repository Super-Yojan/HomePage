package com.joarch.User.Dao;

import java.util.List;

import com.joarch.User.model.User;

public interface UserDao {
	
	int addUser(User user);
	List<User> getUserForLogin(User user);
	User getUser (String email);
	
	int activate(String key1, String key2);
	
	

}
