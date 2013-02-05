package com.kcorner.webstrutslogin.service;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.kcorner.webstrutslogin.model.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public final class LoginService {
	
	private String url = null;
	private String driver = null;
	private User user;

	public LoginService(String url, String driver){
		this.url = url;
		this.driver = driver;
	}
	
	public Boolean authenicateMe(User user) {
		
	      Connection conn = null;
	      this.user = user;
	      try {
	         Class.forName(getDriver());
	         conn = (Connection) DriverManager.getConnection(getUrl(), user.getUserid(), user.getPassword());
	         this.user.setMessage(null); 
	         return true;
	         
	      } catch (Exception e) {
	    	  this.user.setMessage(e.getMessage());
	          return false;
	      } finally {
	         if (conn != null) {
	            try {
	               conn.close();
	            } catch (Exception e) {
	            }
	         }
	      }
	}

	public ResultSet executeSql (String sql) {
	      Connection conn = null;
	      try {
	         Class.forName(getDriver());
	         conn = (Connection) DriverManager.getConnection(getUrl(), user.getUserid(), user.getPassword());
	         PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery();

	         return rs;
	      }
	      catch(Exception ex) {
	    	 return null;
	      }
	      finally {
		     if (conn != null) {
			     try {
			        conn.close();
			     } catch (Exception e) {}
			 }  
	      }
	      
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}	
	
}
