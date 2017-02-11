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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body><center>
     <form action="wbd/bolg/check" method="post">
    <table>
    <tr><th height="31">Title</th><td><input name="title" type="text" size="30"></td></tr>
    <tr><th height="370">Content</th><td><textarea name="content" cols="30" rows="20"></textarea></td></tr>
    <tr><th height="31"></th><td><input type="submit" value="submit"></td></tr>
   </table>
  
   </form>
   </center>
  </body>
</html>
