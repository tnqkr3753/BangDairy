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
			<td>
			<div id='image_container'><img src=""></div></td>
		</tr>
		<tr>
			<th><span>아이디</span></th>
			<td>bej96</td>
		</tr>
		<tr>
			<th><span>이름</span></th>
			<td>배은주</td>
		</tr>
		<tr>
			<th><span>주민등록번호</span></th>
			<td>951231-1******</td>
		</tr>
		<tr>
			<th><span>이메일</span></th>
			<td>qkrdbsxo1@naver.com</td>
		</tr>
	</tbody>
</table>
<!-- table form 끝 -->

<!-- 수정하기, 탈퇴하기버튼 -->
<div class="btn_wrap">
	<input id="btn-update" type="button" value="수정하기"> <input type="button"
		value="탈퇴하기" id='btn-withdraw'>
</div>


