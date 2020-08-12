<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="UTF-8">
  <head>
  	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"> -->
    <link rel="stylesheet" href="resources/css/account_form.css">
  </head>
  <body>
  	<div id = "account_body">
    <div class="account_form">
		
		<form id="accountForm" method="post" action="">
		<h1>회원가입</h1>
		<div class="form-group">
			<strong >아이디&nbsp;<small id="idCheckResult" class="FilterResultId hideResult"></small></strong>
			<input id='user_id' type="text" name="userId" required="" minlength="2" placeholder="아이디">
		</div>
			<div class="form-group">
				<strong >패스워드&nbsp;<small id="passwdCheckResult" class="FilterResultPasswd hideResult"></small></strong>	
				<input id="user_passwd" type="password" name="userPassword" required="">
			</div>
			
			<div class="form-group">
				<strong>패스워드-확인&nbsp;<small id="passwdCheckResult2" class="FilterResultPasswd2 hideResult"></small></strong>	
				<input id="user_passwd2" type="password" required="">
				
			</div>
			
			
 			<div id="userRegForm" class="form-group" >
 					<strong>주민등록번호 ex)900101-1&nbsp;</strong>
					<input maxlength="6" minlength="6" class="userReg" type="text" required="" placeholder="ex)900101">
					<span class="bar"> -</span>
					<input maxlength="1" class="userRegB" type="text" required="" placeholder="ex) 1">
						
					<input id="saveReg" style="display:none;" name="userReg">
			</div>

			<div  class="form-group" data-req="true">
				<strong>e-mail&nbsp;* 인증 필수 
				<small id="eMailCheckResult" class="FilterResultEmail hideResult"></small></strong>
				<input id="user_email" type="text" name="userEmail" required="" placeholder="ex)hong@naver.com">
			</div>
			
			<input id="onsubmit" class="function-btn" type="submit" value="회원가입">
			<div class="seperator"><b>or</b></div>
			<input type="button" class="function-btn" id="account_cancel" value="취소"/>
			
		</form>
	</div>
	</div>

<!--     Optional JavaScript
    jQuery first, then Popper.js, then Bootstrap JS -->
 	<!-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script> -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>
	
    