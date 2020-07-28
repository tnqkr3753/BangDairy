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
  	<div>
    <div class="account_container">
		<h3>회원가입</h3>
		<form id="account_body" action="AccountUser.do">
		<div class="row">
		<div class="col-md-12 col-sm-12 col">
			<div>
				<input id='user_id' type="text" name="userId" required="" minlength="2">
				<label >아이디</label>
			</div>
			<div class="FilterResultId hideResult">
				<strong id='idCheckResult'> ggg</strong>
			</div>
			
			<div>
				<input id="user_passwd" type="password" name="userPassword" required="">
				<label>패스워드</label>	
			</div>
			<div class="FilterResultPasswd hideResult">
				<strong id="passwdCheckResult">aaa</strong>
			</div>
			
			<div>
				<input id="user_passwd2" type="password" name="" required="">
				<label>패스워드-확인</label>	
			</div>
			<div class="FilterResultPasswd2 hideResult">
				<label id="passwdCheckResult2">bbb</label>
			</div>
			
			
 			<div id="userRegForm">
					<input maxlength="6" minlength="6" class="userReg" type="text" name="userRegF" required="">
					<span style="font-size:30px;">-</span>
					<input maxlength="1" class="userRegB" type="text" name="userRegB" required="">
					<span class="userRegStar">******</span>
					<label>주민등록번호</label>	
			</div>

			<div>
				<input id="user_email" type="email" name="userEmail" required="" placeholder="ex)hong@naver.com">
				<label>e-mail</label>	
			</div>
			<div class="FilterResultEmail hideResult">
				<strong id="eMailCheckResult">eee</strong>
			</div>
			
			<input id="onsubmit" type="submit" value="회원가입" name="">
			<input type="button" id="account_cancel" value="취소"></button>
			</div>
			</div>

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
	
    