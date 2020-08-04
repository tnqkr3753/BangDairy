<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<h2>Q&A 작성하기</h2>

<div>
	
	
<!-- table form 시작 -->
<form id="qnaForm" method="POST" >
<table>
	<colgroup>
		<col width="30%" />
		<col width="auto" />
	</colgroup>
	<tbody>
		<tr>
			<th><span>Q&A 제목</span></th>
			<td><input type='text' value=""  name="qnaTitle" style="width:100%;"></td>
		</tr>
		<tr>
			<th><span>Q&A 내용</span></th>
			<td><textarea name="qnaContent" style="width:100%;"></textarea></td>
		</tr>
	</tbody>
</table>
</form>
<!-- table form 끝 -->
<div class="btn_wrap">
	<button id="btn-insertQna" class="btn btn-dark"> Q&A 작성완료</button>
	<input type="button" class='btn-cancle' value="취소" id='btn-cancle' onclick="exit()">
</div>
</div>
<script src="resources/js/myPageQA.js"></script>