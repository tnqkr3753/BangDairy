<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    					<!-- 검색창과 Select Box -->
		    		<div class="row">
						<div class="col-md-12">
							<div class="page-header">
								<h1>
									Q&A 정보<c:if test="${not empty search }"> <span>${search } => </span></c:if>
								</h1>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="page-header">
								<h1>
									Q&A<c:if test="${not empty search }"> <span>${search } => 검색 결과</span></c:if>
								</h1>
							</div>
						</div>
					</div>
					<div class="form-inline">
						<input class="form-control mr-sm-2 search" type="text" placeholder="ID 검색" /> 
						<button class="btn btn-primary my-2 my-sm-0 btn-search">
							Search
						</button>
					</div>

					<!-- 유저리스트 START -->
							<c:choose>
							<c:when test="${not empty list }">
							<div class="table-responsive">
							<table  class="table table-hover">
								<thead>
									<tr>
										<th>Q&A번호</th>
										<th>유저 아이디</th>
										<th>Q&A 제목</th>
										<th>Q&A 내용</th>
										<th>Q&A 상태</th>
										<th>Q&A 작성 날짜</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list }" var="vo">
									<!-- 하나의 유저 START -->
									<tr>
										<td>${vo.qnaId }</td>
										<td>${vo.userId }</td>
										<td>${vo.qnaTitle }</td>
										<td>${vo.qnaContent }</td>
										<c:choose>
										<c:when test="${vo.qnaStatus eq 1 }"><td data-status="required"><button class="btn btn-primary show-qna">답변 완료</button></td></c:when>
										<c:when test="${vo.qnaStatus eq 0 }"><td data-status="required"><button class="btn btn-warning write-qna">답변 작성</button></td></c:when>
										</c:choose>
										<td><fmt:formatDate value="${vo.qnaRegDate }" type="date" dateStyle="full" /></td>
									</tr>
									<!-- 하나의 영화 END -->
									</c:forEach>
								</tbody>
							</table>
							</div>
							<div class="row">
								<input type="button" id="btn-more" class="btn btn-default btn-more btn-block" value="더보기">
							</div>
							</c:when>
							<c:otherwise>
								<span> Q&A 정보가 없습니다.</span>
							</c:otherwise>
							</c:choose>
