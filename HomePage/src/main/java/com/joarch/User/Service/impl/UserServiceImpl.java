package com.joarch.User.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joarch.User.Dao.UserDao;
import com.joarch.User.Service.UserService;
import com.joarch.User.Service.sendEmail.SendEmail;
import com.joarch.User.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	public List<User> getUsers(String userName, String userPassword) {

		return null;
	}

	public boolean checkCredintial(User user) {
		List<User> result = userDao.getUserForLogin(user);
		if (result.isEmpty()) {
			return false;
		}
		if (result.get(0).getUserName().equals(user.getUserName())
				&& result.get(0).getUserPass().equals(user.getUserPass())) {
			return true;
		} else {
			return false;
		}

		// return false;
	}

	public int addUser(User user) {
		User result = userDao.getUser(user.getEmail());
		System.out.println("adduser in userService") ;
		if(result == null) {
			SendEmail sendingEmail = new SendEmail(user.getEmail(),user.getHascode());
			sendingEmail.sendmail();
			return userDao.addUser(user);
		}
		return 0;

	}
	
	public User getUser(String email) {
		return userDao.getUser(email);
	}
	
	public int activate(String key1, String key2) {
		return userDao.activate(key1, key2);
	}
	
	
	

}
