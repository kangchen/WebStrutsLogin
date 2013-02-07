package com.kcorner.webstrutslogin.action;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.kcorner.webstrutslogin.model.User;
import com.kcorner.webstrutslogin.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public final class LoginAction extends ActionSupport implements ModelDriven<User>, SessionAware {

	private static final long serialVersionUID = 1L;
	private User user = new User();
	private Map<String, Object> session;
	
	@Override // ActionSupport
	public String execute() {		
		LoginService loginService = new LoginService("jdbc:mysql://localhost:3306/sakila", "com.mysql.jdbc.Driver");
		System.out.println("Execute method called...");
		if (loginService.authenicateMe(user)) {
			session.put("user", user);
			return SUCCESS;
		}
		user = null;
		return ERROR;
	}
	
	@Override // ActionSupport
    public void validate() {
		if(StringUtils.isEmpty(user.getUserid())){
			addFieldError("userid", "Please enter your user name!");
		}
		if(StringUtils.isEmpty(user.getPassword())){
			addFieldError("password", "Please enter your password!");
		}
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
