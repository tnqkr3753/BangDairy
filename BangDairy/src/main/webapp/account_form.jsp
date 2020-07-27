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
		<h3>Sign up</h3>
		<form id="account_body" action="AccountUser.do">
		<div class="row">
		<div class="col-md-12 col-sm-12 col">
			<div>
				<input id='user_id' type="text" name="userId" required="" minlength="2">
				<label >아이디</label>
			</div>
			<div class="FilterResult hideResult">
				<strong id='idCheckResult'> ggg</strong>
			</div>
			
			<div>
				<input id="user_passwd" type="password" name="userPassword" required="">
				<label>패스워드</label>	
			</div>
			<div class="FilterResult hideResult">
				<strong id="passwdCheckResult">aaa</strong>
			</div>
			
			<div>
				<input id="user_passwd2" type="password" name="" required="">
				<label>패스워드-확인</label>	
			</div>
			<div class="FilterResult hideResult">
				<strong id="passwdCheckResult2">bbb</strong>
			</div>
			
			
 			<div>
				<input type="text" name="userName" required="">
				<label>이름</label>	
			</div>
			
			<div>
				<table>
					<tr>
						<td><input class="rbtn" type="radio" name="userGender" value="1">남자</td>
						<td><input class="rbtn" type="radio" name="userGender" value="2">여자</td>
					<label>성별</label>	
					</tr>
				</table>
			</div>
			
			<div>
				<input type="text" name="userAge" required="">
				<label>연령</label>	
			</div>
			
			<div>
				<input id="user_email" type="text" name="userEmail" required="" placeholder="ex)hong@naver.com">
				<strong id="eMailCheckResult">eee</strong>
				<label>e-mail</label>	
			</div>
			
			<input type="submit" value="Create my account" name="">
			<button>취소</button>
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
	
    