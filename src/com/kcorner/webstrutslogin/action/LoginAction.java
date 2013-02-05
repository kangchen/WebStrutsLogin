package com.kcorner.webstrutslogin.action;

import com.kcorner.webstrutslogin.model.User;
import com.kcorner.webstrutslogin.service.LoginService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public final class LoginAction implements Action, ModelDriven<User> {

	private User user = new User();

	@Override // Action
	public String execute() {		
		LoginService loginService = new LoginService("jdbc:mysql://localhost:3306/sakila", "com.mysql.jdbc.Driver");
		if (loginService.authenicateMe(user)) {
			return SUCCESS;
		}
		return ERROR;
	}

	@Override // ModelDriven
	public User getModel() {
		return user;
	}
	
	
}
