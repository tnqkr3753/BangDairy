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
      <h1>로그인</h1>
      <div class="form-group">
        <input id="usrId" type="text" name="userId" placeholder="아이디">
        <span class="input-icon"><i class="fa fa-envelope"></i></span>
      </div>
      <div class="form-group">
        <input id="usrPasswd" type="password" name="userPassword" placeholder="비밀번호">
        <span class="input-icon"><i class="fa fa-lock"></i></span>
      </div>   
      <input id="login-btn" type="button" class="login-btn" value="Login"/> 
      <p>당신의 SNS계정으로 로그인하세요</p>    
      <input type="button" id="kakao_login" class="kakao-login"/>
      <a class="reset-psw" href="#">Forgot your password?</a>
      <div class="seperator"><b>or</b></div>
      <div><input id="login-cancel-btn" class="login-btn" type="button" value="취소"></div>
      
    </form>
  </div>
  </div>
</body>
</html>