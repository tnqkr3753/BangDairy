<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h2>Member Info</h2>

<script src="resources/js/myPageMember.js"></script>
<!-- table form 시작 -->
<table>
	<colgroup>
		<col width="30%" />
		<col width="auto" />
	</colgroup>
	<tbody>
		<tr>
			<th><span>프로필사진</span></th>
			<td><div class="filebox"> <label for="label label-default">업로드</label> <input type="file" name='file' value="" disabled="disabled" accept="image/gif,image/jpg,image/png" onchange="chk_file_type(this)"> </div></td>
		</tr>
		<tr>
			<th><span>아이디</span></th>
			<td><input type='text' value="bej96"  name="userId" readonly="readonly" ></td>
		</tr>
		<tr>
			<th><span>이름</span></th>
			<td><input type='text' value="은주배"  name="userName" readonly="readonly" ></td>
		</tr>
		<tr>
			<th><span>주민등록번호</span></th>
			<td><input type='text' value="951231-1******"  name="userReg" readonly="readonly" ></td>
		</tr>
		<tr>
			<th><span>이메일</span></th>
			<td><input type='email' value="qkrdbsxo1@naver.com"   name="userEmail" readonly="readonly" ></td>
		</tr>
		<tr>
			<th><span>비밀번호</span></th>
			<td><input type="password" value="" name="userPassword" disabled="disabled"></td>
		</tr>
		<tr>
			<th style="font-size: 14px"><span>비밀번호 확인</span></th>
			<td><input type="password" value=""  disabled="disabled"></td>
		</tr>
		

	</tbody>
</table>
<!-- table form 끝 -->

<!-- 수정하기, 탈퇴하기버튼 -->
<div class="btn_wrap">
	<input id="btn-update" type="button" value="수정하기"> <input type="button"
		value="탈퇴하기" id='btn-withdraw'>
</div>


