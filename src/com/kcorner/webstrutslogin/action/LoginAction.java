package com.kcorner.webstrutslogin.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.kcorner.webstrutslogin.model.User;
import com.kcorner.webstrutslogin.service.LoginService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public final class LoginAction implements Action, ModelDriven<User>, SessionAware {

	private User user = new User();
	Map<String, Object> session;
	
	@Override // Action
	public String execute() {		
		LoginService loginService = new LoginService("jdbc:mysql://localhost:3306/sakila", "com.mysql.jdbc.Driver");
		if (loginService.authenicateMe(user)) {
			session.put("user", user);
			return SUCCESS;
		}
		user = null;
		return ERROR;
	}

	@Override // ModelDriven
	public User getModel() {
		return user;
	}

	@Override // SessionAware
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
}
