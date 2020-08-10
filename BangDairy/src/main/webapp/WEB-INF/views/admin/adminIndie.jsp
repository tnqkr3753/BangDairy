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
									인디영화 정보<c:if test="${not empty search }"> <span>${search } => </span></c:if>
								</h1>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="page-header">
								<h1>
									인디영화 정보<c:if test="${not empty search }"> <span>${search } => 검색 결과</span></c:if>
								</h1>
							</div>
						</div>
					</div>
					<div class="form-inline">
						<input class="form-control mr-sm-2 search" type="text" placeholder="제목 검색" /> 
						<button class="btn sbtn-primary my-2 my-sm-0 btn-search">
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
										<th>인디영화 번호</th>
										<th>영화 포스터</th>
										<th>신청 아이디</th>
										<th>영화 제목</th>
										<th>영화 장르</th>
										<th>좋아요 싫어요</th>
										<th>조회수</th>
										<th>심사 여부</th>
										<th>신청 날짜</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list }" var="vo">
									<!-- 하나의 유저 START -->
									<tr>
										<td>${vo.indieId }</td>
										<td><img src="resources/upload/indie/${vo.indiePosterAddr }"
										onerror="this.src='resources/images/movieList/noImage.png'"
											width="100px" height="100px"></td>
										<td>${vo.indieDirector }</td>
										<td>${vo.indieTitle }</td>
										<td>${vo.indieGenre }</td>
										<td>좋아요 : ${vo.indieLike }<br/>싫어요 : ${vo.indieHate }</td>
										<td>${vo.indieViewingHits }</td>
										<c:choose>
										<c:when test="${vo.indieConfirm eq 'y' }"><td data-status="required"><button class="btn btn-success indie">허가</button></td></c:when>
										<c:when test="${vo.indieConfirm eq 'n'}"><td data-status="required"><button class="btn btn-warning indie">허가요청</button></td></c:when>
										<c:when test="${vo.indieConfirm eq 'b'}"><td data-status="required"><button class="btn btn-danger indie">비허가</button></td></c:when>
										</c:choose>
										<td><fmt:formatDate value="${vo.indieUpdateDate }" type="date" dateStyle="full" /></td>
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
								<span> 인디영화 정보가 없습니다.</span>
							</c:otherwise>
							</c:choose>
