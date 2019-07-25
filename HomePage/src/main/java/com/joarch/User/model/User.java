package com.joarch.User.model;

public class User {
	
	private String email;
	private String firstName;
	private String lastName;
	private String phoneNo;
	private String userName;
	private String userPass;
	private boolean isActive;
	private String hasCode;
	
	public User() {
		
	}
	public User(String email, String firstName, String lastName, String userName, String phoneNo, String password,boolean isActive,String hasCode) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.userName=userName;
		this.userPass = password;
		this.isActive = isActive;
		this.hasCode = hasCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNo=" + phoneNo
				+ ", userName=" + userName + ", userPass=" + userPass + "]";
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getHascode() {
		return hasCode;
	}
	public void setHascode(String hascode) {
		this.hasCode = hascode;
	}
	

}
