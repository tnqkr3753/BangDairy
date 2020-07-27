<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<h2>Member Info</h2>

<!-- table form 시작 -->
<table>
	<colgroup>
		<col width="30%" />
		<col width="auto" />
	</colgroup>
	<tbody>
		<tr>
			<th><span>아이디</span></th>
			<td>bej96</td>
		</tr>
		<tr>
			<th><span>이름</span></th>
			<td>배은주</td>
		</tr>
		<tr>
			<th><span>성별</span></th>
			<td><input type="checkbox" id="chkbx" disabled="disabled">&nbsp;남자
				<br /> <input type="checkbox" id="chkbx" checked="checked"
				disabled="disabled">&nbsp;여자</td>
		</tr>
		<th><span>생년월일</span></th>
		<td>1996-09-05</td>
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
