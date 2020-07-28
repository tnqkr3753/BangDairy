<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="resources/css/Sign_In.css">
</head>
<body>
  <div id="login_body">
  <div class="login-form">
    <form id="SignForm" method="post" action="">
      <h1>Login</h1>
      <div class="form-group">
        <input id="usrId" type="text" name="userId" placeholder="User ID">
        <span class="input-icon"><i class="fa fa-envelope"></i></span>
      </div>
      <div class="form-group">
        <input id="usrPasswd" type="password" name="userPassword" placeholder="Password">
        <span class="input-icon"><i class="fa fa-lock"></i></span>
      </div>   
      <input type="button" class="login-btn" value="Login"/>     
      <a class="reset-psw" href="#">Forgot your password?</a>
      <div class="seperator"><b>or</b></div>
      <p>Sign in with your social media account</p>
    </form>
  </div>
  </div>
</body>
</html>