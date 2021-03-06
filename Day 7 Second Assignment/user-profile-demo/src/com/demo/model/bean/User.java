package com.demo.model.bean;

public class User {
	private int userId;
	private String name;
	private String password;
	private String phoneNo;
	
	private static int userCounter=1;

	public User() {
		super();
		this.userId=userCounter++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", phoneNo=" + phoneNo + "]";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getUserId() {
		return userId;
	}
	
	
	
}
