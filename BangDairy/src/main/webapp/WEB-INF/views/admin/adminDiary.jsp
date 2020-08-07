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
									다이어리 정보<c:if test="${not empty search }"> <small>${search } => 검색 결과</small></c:if>
								</h1>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="page-header">
								<h1>
									다이어리 정보<c:if test="${not empty search }"> <small>${search } => 검색 결과</small></c:if>
								</h1>
							</div>
						</div>
					</div>
    				<div class="form-inline">
						<input class="form-control mr-sm-2 search" type="text" placeholder="쓴 사람 검색"/> 
						<button class="btn btn-primary my-2 my-sm-0 btn-search">
							Search
						</button>
					</div>
					<!-- 영화리스트 START -->
							<c:choose>
							<c:when test="${not empty list }">
							<div class="table-responsive">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>다이어리이미지</th>
										<th>쓴 사람</th>
										<th>다이어리 제목</th>
										<th>다이어리 내용</th>
										<th>작성 날짜</th>
										<th>조회수</th>
									</tr>
								</thead>

								<tbody>
									
										
									
									<c:forEach items="${list }" var="vo">
									<!-- 하나의 영화 START -->
									<tr>
										<td><img src="resources/upload/diary/${vo.diaryImage }"
										onerror="this.src='resources/images/movieList/noImage.png'"
											width="100px" height="100px"></td>
										<td>${vo.userId }</td>
										<td>${vo.diaryTitle }</td>
										<td>${vo.diaryContent }</td>
										<td><fmt:formatDate value="${vo.regDate }" type="date" dateStyle="full" /></td>
										<td>${vo.diaryHits }</td>
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
								<span> 다이어리 정보가 없습니다.</span>
							</c:otherwise>
							</c:choose>
