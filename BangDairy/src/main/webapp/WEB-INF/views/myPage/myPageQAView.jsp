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
	<c:if test="${not empty vo }">
		<tr>
			<th><span>Q&A 번호</span></th>
			<td>${vo.qnaId }</td>
		</tr>
		<tr>
			<th><span>작성 날짜</span></th>
			<td><fmt:formatDate value="${vo.qnaRegDate }" type="date" dateStyle="full" /></td>
		</tr>
		<tr>
			<th><span>Q&A 제목</span></th>
			<td>${vo.qnaTitle }</td>
		</tr>
		<tr>
			<th><span>Q&A 내용</span></th>
			<td><textarea name="qnaContent" style="width:100%;" readonly="readonly">${vo.qnaContent }</textarea></td>
		</tr>
		<c:if test="${vo.qnaStatus == 1 }">
		<hr/><hr/>
		<tr>
			<th><span>답변 내용</span></th>
			<td>${vo.qnaAnswer }</td>
		</tr>
		</c:if>
		</c:if>
	</tbody>
	
</table>
</form>
<!-- table form 끝 -->
<div class="btn_wrap">
	<input type="button" class='btn-goList' value="목록가기" id='btn-goList'>
</div>
</div>
<script src="resources/js/myPageQA.js"></script>