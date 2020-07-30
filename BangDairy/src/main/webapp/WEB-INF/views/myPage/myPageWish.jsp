<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<script src="resources/js/myPageWish.js"></script>
<h2>찜한 영화 목록</h2>

<div>
	<c:if test="${empty list }">
		<strong>찜한 영화가 없습니다.</strong>
	</c:if>
	<c:if test="${not empty list }">
	<table>
		<thead>
			<tr>
				<th>영화 포스터</th>
				<th>제목</th>
				<th>관람 등급</th>
				<th>찜목록 추가 날짜</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="vo">
			<tr class="wishList">
				<td><img alt="" onerror='this.src="resources/images/defaultImage.png"' 
				src="${vo.posterAddr }" width="100" height="100"></td>
				<td><input type="hidden" name="movieId" value="${vo.movieId }">
				${vo.movieTitle }</td>
				<td>${vo.viewingClass }</td>
				<td><fmt:formatDate value="${vo.regDate }" type="date" dateStyle="full" /></td>
				<td><button class="btn btn-dark delete-wish">삭제</button></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>
</div>