package com.kcorner.webstrutslogin.action;

import com.kcorner.webstrutslogin.service.LoginService;
import com.opensymphony.xwork2.Action;

public final class LoginAction implements Action{
	
	private String userid;
	private String password;
	private String message = null;

	@Override // Action
	public String execute() {		
		LoginService loginService = new LoginService("jdbc:mysql://localhost:3306/sakila", "com.mysql.jdbc.Driver");
		if (loginService.authenicateMe(getUserid(), getPassword())) {
			return SUCCESS;
		}
		setMessage(loginService.getErrMessage());
		return ERROR;
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
