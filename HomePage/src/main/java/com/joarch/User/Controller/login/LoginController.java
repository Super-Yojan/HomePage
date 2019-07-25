package com.joarch.User.Controller.login;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.joarch.User.Service.UserService;
import com.joarch.User.model.User;

@Controller
public class LoginController {
	@Autowired
	UserService userService;
	
	@RequestMapping("/loginPage")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request , HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		String userName = (String) request.getParameter("userName");
		String userPass = (String) request.getParameter("userPass");
		
		User user = new User();
		user.setUserName(userName);
		user.setUserPass(userPass);
		if(userService.checkCredintial(user)) {
			model.setViewName("welcome");
			model.addObject("user", userName);
		}
		else {
			model.setViewName("login");
			model.addObject("failed", "Sorry, Please Check your credintials");
		}
		
		
		return model ;
	}
	
	@RequestMapping("/validateEmail")
	public @ResponseBody String validateEmail(HttpServletRequest request) {
		
		//ModelAndView model = new ModelAndView();
		User user = userService.getUser(request.getParameter("email"));
		String msg = "";
		if(user != null) {
			msg = "Email Already exists";
		}
		
		return  msg;
	}
	
	@RequestMapping("/singup")
	public String registerUser() {
		return "registration";
	}
	@RequestMapping("/ActivateAccount")
	public String activateAccount(HttpServletRequest request) {
		String key1 = request.getParameter("key1");
		String key2 = request.getParameter("key2");
		int result = userService.activate(key1,key2);
		if(result == 1) {
			return "login";
		}
		else {
			return "registration";
		}
	}
	
	@RequestMapping("/register")
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response) {
		
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String phoneNo = request.getParameter("number");
		String password = request.getParameter("password");
		
		//String newPassword = DigestUtils.md5Hex(password);
		Random rand = new Random();
		rand.nextInt(999999);
		String myHas = DigestUtils.md5Hex(""+rand);
		User user = new User(email,firstName, lastName, userName, phoneNo, password,false,myHas);
		System.out.println("I am here");
		
		ModelAndView model = new ModelAndView();
		int result = userService.addUser(user);
		System.out.println(result);
		if( result != 0) {
			model.addObject("result", "User " + userName + " was successfully created!");
			model.setViewName("registrationsuccess");
		}
		else {
			model.setViewName("registration");
			
			model.addObject("failed" ,"Check Your Email");
			
		}
		
		
		
		
		return model ;
	}
}
