<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="com.kcorner.webstrutslogin.model.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib prefix="html" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <base href="<%=basePath%>">
    <title>Successful login page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>    
 <% User user = (User)session.getAttribute("user"); 
       if (user == null){
         response.sendRedirect("error.jsp");
       }
 %>
  	<h3>
    This is my success logged in page. <br>
    Welcome, <html:property value="userid" />!
    <br>
    </h3>
    <html:form action="">
    
    	<html:submit value="S u b m i t"/>
    </html:form>
  </body>
</html>
