<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html class="no-js" lang="en">
<head>

<!--- basic page needs
    ================================================== -->
<meta charset="utf-8">
<title>Video Post Format - Philosophy</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- mobile specific metas
    ================================================== -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- CSS
    ================================================== -->
    <link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">	
 <link type="text/css" rel="stylesheet" charset="UTF-8" href="https://translate.googleapis.com/translate_static/css/translateelement.css">
<link rel="stylesheet" href="resources/css/base.css">
<link rel="stylesheet" href="resources/css/vendor.css">
<link rel="stylesheet" href="resources/css/main.css">
<link rel="stylesheet" href="resources/css/movieList.css">
<link rel="stylesheet" href="resources/css/dairycss/diaryList.css">


<!-- script
    ================================================== -->
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="resources/js/modernizr.js"></script>
<script src="resources/js/pace.min.js"></script>

<!-- favicons
    ================================================== -->
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<link rel="icon" href="favicon.ico" type="image/x-icon">

<!-- jquery lib import -->

</head>

<body id="top">
	<%@ include file="../../../header_menu.jsp"%>

	<!-- s-content
    ================================================== -->

	<!-- Comments START -->
	<div class="comments-wrap">

		<div id="comments" class="row">
			<div class="col-full">
				<!-- respond
                    ================================================== -->
				<div class="respond">
					<!-- 여기는 제목 -->
					<h1 class="s-content__header-title">
					<c:choose>
						<c:when test="${search.searchType eq 'd.diary_title' }">다이어리 제목</c:when>
						<c:when test="${search.searchType eq 'd.user_id' }">글쓴이</c:when>
						<c:otherwise>영화 제목</c:otherwise>
					</c:choose>
					<small>에 대한</small>
					${search.searchWord } 검색 결과
					</h1>

					<!-- 여기는 상단 네비게이션 바 START -->
					<nav class="clearfix">
						<ul class="clearfix">
							<li class="clist"><a href="#"></a></li>
							<li class="clist"><a href="#"></a></li>
							<li class="clist"><a href="#"></a></li>
							<li class="clist"><a href="#"></a></li>
							<li class="clist"><a href="#"></a></li>
							<li class="clist"><a href="#"></a></li>
						</ul>
						<a id="pull" href="#">CATEGORY</a>
					</nav>
					<!-- 네비게이션 바 END -->

					<!-- 검색창과 Select Box -->
					<div class="select">
						

					<!-- 영화리스트 START -->
					<!-- 영화리스트 START -->
					<div class="col-twelve" >
						<c:if test="${empty list }">
							<h1>검색된 결과가 없습니다.</h1>
						</c:if>
						<c:if test="${not empty list }">
						<div class="table-responsive">
							<form action="getdairy" method="POST" id="go-getdairy">
							<input type="hidden" name="userId" id="search-uid">
							<input type="hidden" name="diaryId" id="search-did">
							<c:set value="1" var="count"/>
							<table style="align-content: center;">
								<thead>
								
									<tr >
										<th style="font-size:15px; text-align:center; width: 25%;">사진</th>
										<th style="font-size:15px; text-align:center; width: 20%;">제목</th>
										<th style="font-size:15px; text-align:center; width: 15%;">글쓴이</th>
										<th style="font-size:15px; text-align:center; width: 15%;">영화 제목</th>
										<th style="font-size:15px;  width: 10%; ">조회수 </th>		
										<th style="font-size:15px; text-align:center; width: 15%;"></th>		
									
									</tr>
								</thead>
								<tbody> 
								 <c:forEach items="${list }" var="search" >   
								    
									<tr data-uid="${search.user_id}"
										data-did="${search.diary_id }"
									 <c:if test="${count le 10 }">class="search-tr"</c:if>
									 <c:if test="${count gt 10 }">class="search-tr hide-tr"</c:if> >
										<td><img src="resources/upload/diary/${search.diary_image}" onerror="this.src='resources/images/defaultImage.png'"
											 height="400px"></td>
										<td style="align-self: center; width: 60px;">${search.diary_title} </td>									
										<td >${search.user_id} </td>
										<td >${search.movie_title })</td>
										<td >${search.diary_hits} </td>
										<fmt:parseNumber var="like" type="number" value="${search.diary_like }"/>
										<fmt:parseNumber var="hate" type="number" value="${search.diary_hate }"/>
										<td >좋아요 : ${like}<br/>
										싫어요 : ${hate}</td>
									</tr>
								
								<c:set var="count" value="${count + 1 }"/>
								</c:forEach>
								</tbody>
							
							</table>
							</form>
						</div>
						<input id="btn-moreview" type="button" class="submit btn--primary" value="더보기">
						</c:if>
						
					</div>
					<!-- 영화 리스트 END -->
				</div>
				<!-- end respond -->
			</div>
			<!-- end col-full -->
		</div>
		<!-- end row comments -->

		
	</div>
	<!-- end comments-wrap -->
	<!-- Comments END -->

	<%@ include file="../../../footer.jsp"%>

	<!-- preloader
    ================================================== -->
	<div id="preloader">
		<div id="loader">
			<div class="line-scale">
				<div></div>
				<div></div>
				<div></div>
				<div></div>
				<div></div>
			</div>
		</div>
	</div>

	<!-- Java Script
    ================================================== -->
	<script src="resources/js/plugins.js"></script>
	<script src="resources/js/main.js"></script>
	<script src="resources/js/diaryList.js"></script>
	
	
</body>

</html>