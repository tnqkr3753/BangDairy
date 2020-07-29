<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>회원 탈퇴</h2>

<script src="resources/js/myPagePassCheck.js"></script>
<!-- table form 시작 -->
<form id="account" method="POST" >
<table>
	<colgroup>
		<col width="30%" />
		<col width="auto" />
	</colgroup>
	<tbody>
		<tr>
			<th><span>비밀번호</span></th>
			<td><input id="pass" type="password" value="" name="userPassword"></td>
		</tr>
		<tr>
			<th style="font-size: 14px"><span>비밀번호 확인</span></th>
			<td><input type="password" value="" id="passwordCheck"></td>
		</tr>
	</tbody>
</table>
</form>
<div class="btn_wrap">
	<input id="btn-Confirm" type="button" value="비밀번호 확인"> <input type="button" value="취소" class='btn-cancle' id='btn-cancle' onclick="exit()">
</div>