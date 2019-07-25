package com.joarch.User.Service;

import java.util.List;

import com.joarch.User.model.User;

public interface UserService {
	
	int addUser(User user);
	List<User> getUsers(String userName, String userPassword);
	boolean checkCredintial(User user);
	User getUser(String email);
	int activate(String key1, String key2);

}
