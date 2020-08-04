<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<h2>Q&A 게시판</h2>

<div>
	
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>#</th>
				<th>제목</th>
				<th>작성일</th>
				<th>답변 여부</th>
			</tr>
		</thead>
		<tbody>
		<c:if test="${empty list }">
			<tr><th>작성된 Q&A가 없습니다.</th></tr>
		</c:if>
		<c:if test="${not empty list }">
			<c:forEach items="${list }" var="vo">
			<tr class="qnaList">
				<td class="id-value">${vo.qnaId}</td>
				<td>${vo.qnaTitle }</td>
				<td><fmt:formatDate value="${vo.qnaRegDate }" type="date" dateStyle="full" /></td>
				<td><c:choose>
					<c:when test="${vo.qnaStatus == 0 }">
					답변 대기중
					</c:when>
					<c:otherwise>
					답변 완료
					</c:otherwise>
				</c:choose></td>
			</tr>
			</c:forEach>
			</c:if>
		</tbody>
	</table>
	<button id="btn-addQna" class="btn btn-dark">Q&A 작성</button>

</div>
<script src="resources/js/myPageQA.js"></script>