<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<tr name="${vo.indieId}">
	<th>만든나라</th>
	<th>감독</th>
	<th>배우</th>
	<th>제작 날짜</th>
	<th colspan="2">줄거리</th>
	<th>영화 링크</th>
	<th>키워드</th>
	<th><c:if test="${vo.indieConfirm ne 'y' }"><button class="btn btn-primary request-indie">허가</button></c:if></th>
</tr>
<tr name="${vo.indieId}">
	<td>${vo.indieCountry }</td>
	<td>${vo.indieDirector }</td>
	<td>${vo.indieActor }</td>
	<td><fmt:formatDate value="${vo.indieMakedate }" type="date" dateStyle="full" /></td>
	<td colspan="2">${vo.indiePlot }</td>
	<td><a href="${vo.indieAddr }">${vo.indieAddr }</a></td>
	<td>${vo.indieKeyword }</td>
	<td><button class="btn btn-danger request-indie">벤</button></td>
</tr>