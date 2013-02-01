<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<style type="text/css">
		div.background {
  			width:600px;
  			height:400px;
  			background:url(images/nature_01.jpg) repeat;
  			opacity:0.75;
  			filter:alpha(opacity=75); /* For IE8 and earlier */
  		}
  		div.loginbox {
  			opacity:1;
  			filter:alpha(opacity=100); /* For IE8 and earlier */
  		}

	</style>
  
    <title>Login Page</title>
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

	<div class="background" id="main" style="position: absolute; top: 13px; left: 15px;"></div>
    <div class="loginbox" style="position: absolute; top: 117px; left: 174px; width: 264px; height: 176px;">
     
	<s:form action="getLogin">
		<table style="top: 1px; left: 1px; width: 255px; height: 140px;">
		<tr>
		 	<td align=right>User Name</td><td><input type="text" name="userid"></td>
		</tr>
		<tr>
		 	<td align=right>Password</td><td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td></td><td><input type="submit" value="S u b m i t"> <input type="reset" value="C l e a r"></td>
		</tr>
		</table>
	</s:form>
	<font color=red><s:property value="message"/></font>
	</div>

</body>
</html>
