<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <center>
  <body>
     <form action="Logincl" method="post">
     <label>用户名<input type="text" name="user"></label><br>
     <label>密码<input type="password" name="password"></label><br>
     <input type="submit" value="登入">
     </form>
     <h3>从servletcontext中得到密码</h3>
     <%String pass1=application.getInitParameter("user1");
       String pass2=application.getInitParameter("user2");
       String pass3=application.getInitParameter("user3");    
     %>
    帐号 user1:密码 <%=pass1 %><br>
    帐号 user2:密码 <%=pass2 %><br>
    帐号 user3:密码 <%=pass3 %><br>
  </body>
  </center>
</html>
