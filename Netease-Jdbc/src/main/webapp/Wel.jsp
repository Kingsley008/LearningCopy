<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList al = (ArrayList)application.getAttribute("userlist");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Wel.jsp' starting page</title>
    
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
    <h2>在线用户</h2>
    <table>
    <tr><th>用户名</th></tr>
    <%if (!al.isEmpty()){
        for(int i=0;i<al.size();i++){
          String user = (String)al.get(i);    
    
    %>
    <tr><td><%=user %></td></tr>
    <%
      }
    } 
     %>
    </table><br>
    <a href="Quit">注销</a>
  </body>
  </center>
</html>
