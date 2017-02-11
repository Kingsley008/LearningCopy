<!DOCTYPE html>
<html>
  <head>
    <title>login.html</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
  </head>
  <center>
  <body>
    <h1>${error1!}</h1>
    <h1>${error2!}</h1>
    <form action="http://localhost:8888/Spring-template/wbd/userlg/check" method="post">
     <label>用户名<input type="text" name="username"></label><br>
     <label>密码<input type="password" name="password"></label><br>
     <input type="submit" value="登入">
     </form>
  </body>
  </center>
</html>