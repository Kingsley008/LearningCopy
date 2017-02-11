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
   <!-- 如果非法 或者密码错误都会提示用户  -->
     <h1><%String e =request.getParameter("err");
       if(e!=null){
        if(e.equals("1")){
        
      out.print("请先登入！");
       }
      
         if(e.equals("2")){
          out.print("帐号密码错误！");
          }
          
          }
          
          %></h1>
     <form action="Logincl" method="post">
     <label>用户名<input type="text" name="user"></label><br>
     <label>密码<input type="password" name="password"></label><br>
     <input type="submit" value="登入">
     </form>
     <h3>去数据库验证吧</h3>
      </body>
  </center>
</html>

