<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<h2>Member Info</h2>

<!-- table form 시작 -->
<form method="POST">
<table>
	<colgroup>
		<col width="30%" />
		<col width="auto" />
	</colgroup>
	<tbody>
		<tr>
			<th><span>아이디</span></th>
			<td><input type='text' value="배은주" disabled="disabled" name="userId"></td>
		</tr>
		<tr>
			<th><span>이름</span></th>
			<td>배은주</td>
		</tr>
		<tr>
			<th><span>성별</span></th>
			<td><input type="checkbox" id="chkbx" name="userGender" disabled="disabled" value="0">&nbsp;남자
				<br /> <input type="checkbox" name="userGender" id="chkbx" checked="checked" value="1"
				disabled="disabled">&nbsp;여자</td>
		</tr>
		<th><span>나이</span></th>
		<td><input type='text' value="25"  name="userAge" disabled="disabled" ></td>
		</tr>
		<tr>
			<th><span>휴대폰 번호</span></th>
			<td>010-1234-5678</td>
		</tr>
		<tr>
			<th><span>이메일</span></th>
			<td>bej96@naver.com</td>
		</tr>
		<tr>
			<th><span>비밀번호</span></th>
			<td><input type="text" value="**********"></td>
		</tr>
		<tr>
			<th style="font-size: 14px"><span>비밀번호 확인</span></th>
			<td><input type="text" value="**********"></td>
		</tr>

	</tbody>
</table>
<!-- table form 끝 -->

<!-- 수정하기, 탈퇴하기버튼 -->
<div class="btn_wrap">
	<input type="button" value="수정하기"> <input type="button"
		value="탈퇴하기">
</div>
</form>
<script src="resources/js/myPageMemberUpdate.js"></script>