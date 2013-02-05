package com.kcorner.webstrutslogin.model;

public class User {
	
	private String userid = null;
	private String password = null;
	private String message = null;

	public User() {
		
	}
	
	public User(String userid, String password){
		this.userid = userid;
		this.password = password;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getUserid() {
		return userid;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
