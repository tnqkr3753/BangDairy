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
									유저 정보<c:if test="${not empty search }"> <span>${search } => </span></c:if>
								</h1>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="page-header">
								<h1>
									유저 정보<c:if test="${not empty search }"> <span>${search } => 검색 결과</span></c:if>
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
										<th>프로필</th>
										<th>아이디</th>
										<th>이메일</th>
										<th>타입</th>
										<th>가입날짜</th>
										<th>생년월일</th>
										<th>벤</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list }" var="vo">
									<!-- 하나의 유저 START -->
									<!-- 벤 목록 제외 -->
									<c:if test="${vo.userBan eq '0' }">
									<tr>
										<td><img src="${vo.absoluteFilePath }"
										onerror="this.src='resources/images/movieList/noImage.png'"
											width="100px" height="100px"></td>
										<td>${vo.userId }</td>
										<td>${vo.userEmail }</td>
										<td>
										<c:choose>
										<c:when test="${vo.userType eq '1' }"><label class="label label-secondary">무비어리 로그인</label></c:when>
										<c:when test="${vo.userType eq '2' }"><img src="resources/images/login/kakao_login_medium.png"></c:when>
										<c:otherwise><label class="label label-primary">관리자</label></c:otherwise>
										</c:choose>
										</td>
										<td><fmt:formatDate value="${vo.joinDate }" type="date" dateStyle="full" /></td>
										<td>${vo.userReg }</td>
										<td><input type="button" class="btn btn-danger ban-user" value="유저 벤" data-id="${vo.userId }" data-bantype="ban">
										</td>									
										</tr>
										</c:if>
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
								<span> 유저 정보가 없습니다.</span>
							</c:otherwise>
							</c:choose>
