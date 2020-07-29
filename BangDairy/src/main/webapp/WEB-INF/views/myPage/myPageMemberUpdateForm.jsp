<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h2>Member Info</h2>

<script src="resources/js/myPageMemberUpdateForm.js"></script>
<!-- table form 시작 -->
<form id="account" method="POST" >
<table>
	<colgroup>
		<col width="30%" />
		<col width="auto" />
	</colgroup>
	<tbody>
		<tr>
			<th><span>프로필사진</span></th>
			<td><input id="profile_img" type="file" name='file' value="" accept="image/gif,image/jpg,image/png" onchange="chk_file_type(this)" >
			<div id='image_container'></div></td>
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
			<td><input type="password" value="" name="userPassword"></td>
		</tr>
		<tr>
			<th style="font-size: 14px"><span>비밀번호 확인</span></th>
			<td><input type="password" value=""></td>
		</tr>
		

	</tbody>
</table>
</form>
<!-- table form 끝 -->

<!-- 수정하기, 탈퇴하기버튼 -->
<div class="btn_wrap">
	<input id="btn-updateConfirm" type="button" value="수정완료"> <input type="button"
		value="취소" id='btn-cancle'>
</div>


