<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
    <title>用户信息</title>
    </head>
    <body>
    <table border=1>
    <tr><td>用户id</td><td>First-name</td><td>Last-name</td></tr>
    <#list userlist as User>
    <tr><td>${User.id}</td><td>${User.firstname}</td><td>${User.lastname}</td></tr>
    </#list>
	</table>
    </body>
</html>