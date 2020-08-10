<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="com.kosmo.bangdairy.vo.IndieVO"%>
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
    
<link rel="stylesheet" href="resources/css/base.css">
<link rel="stylesheet" href="resources/css/vendor.css">
<link rel="stylesheet" href="resources/css/main.css">
<link rel="stylesheet" href="resources/css/movieList.css">


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

<body id="back">
	<%@ include file="../../../header_menu.jsp"%>

	<!-- s-content
    ================================================== -->


	
<div id="movie-list">

		<div id="comments" class="row" style="background:#e5e5e5">
			<div class="col-full">

				<!-- respond
                    ================================================== -->
				<div class="respond">
					<!-- 여기는 제목 -->
			

					<!-- 여기는 상단 네비게이션 바 START -->
					
					<!-- 네비게이션 바 END -->
		<h1 class="s-content__header-title">ALL MOVIES</h1>
	
					<!-- 검색창과 Select Box -->
					
					<div class="select">
						<!-- 검색창 -->
						<input class="form-control" type="text" placeholder="Search"
							style="float: left">
						<!-- 정렬기준 Select Box -->
						<select name="order" id='order'>
							<option value="">정렬기준</option>
							<option value="">개봉년도순</option>
							<option value="">관람객순</option>
							<option value="">평점순</option>
						</select>
					</div>


					<!-- 영화리스트 START -->
						<!-- Comments START -->
	
		<div class="comments-wrap">        
			<br/>
			<br/>
	  				<form id="frm1212" action="indieDet" method="post"enctype="multipart/form-data" accept="image/png, image/jpeg">
						<table class="table table-striped table-dark" >
							<thead>
							    <tr>
							      <th scope="col">포스터</th>
							      <th scope="col">제목</th>
							      <th scope="col">감독</th>
							      <th scope="col">장르</th>
							      <th scope="col">평점</th>
							    </tr>
							</thead>
							
							<tbody >
    							<c:set var="a" value="1"></c:set>
    							<c:forEach items="${result}" var="result">
    
     										<tr>
											      <th scope="row">${a}</th>
											 
											      <td><a href="indieDet?indieid=${result.indieId}">${result.indieTitle}</a></td>
											      <td>${result.indieDirector}</td>
											      <td>${result.indieGenre}</td>
											     <td ><div class="starRev" >
													<span class="starR on">별1</span> <span class="starR">별2</span>
													<span class="starR">별3</span> <span class="starR">별4</span>
													<span class="starR">별5</span>
													</div>
												</td>							
    										</tr>
     							<c:set var="a" value="${a+1}"></c:set>
    							</c:forEach>
    						</tbody>
						</table>
					</form>
				</div>
					<!-- 영화 리스트 END -->
			</div>
				<!-- end respond -->

		</div>
			<!-- end col-full -->
	</div>
		<!-- end row comments -->
	<div class="row">
	<div class="col-full">
		<nav class="pgn">
		
			<!-- ********** 페이징 ********** -->
		<%-- 	<c:if test="${totalPage < 5}"> --%>
				<!-- 전체페이지 수가 5보다 작을때 -->
				<c:forEach var="i" begin="1" end="5">
					<button class="btnPaging" value='${i}'>${i}</button>
					
				</c:forEach>
		<%-- 	</c:if> --%>

<%-- 			<c:if test="${totalPage >= 5}">
				<!-- 전체페이지 수가 5보다 클때 -->
				<c:if test="${pNum == 1}">
					<!-- 현재 페이지가 1페이지일때 뒤 4개의 페이지 보여줌 -->
					<c:forEach var="i" begin="${pNum}" end="${pNum+4}">
					
						<button class="btnPaging" value='${i}'>${i}</button>
					</c:forEach>
				</c:if>
				<c:if test="${pNum == 2}">
					<!-- 현재 페이지가 2페이지일때 1페이지, 뒤 3개의 페이지 보여줌 -->
					<c:forEach var="i" begin="${pNum-1}" end="${pNum+3}">
						<button class="btnPaging" value='${i}'>${i}</button>
					</c:forEach>
				</c:if>
				<c:if test="${pNum >= 3 and pNum <= totalPage-2}">
					<!-- 현재 페이지가 3페이지 이상일때 앞 2개, 뒤 2개의 페이지 보여줌 -->
					<c:forEach var="i" begin="${pNum-2}" end="${pNum+2}">
						<button class="btnPaging" value='${i}'>${i}</button>
					</c:forEach>
				</c:if>
				<c:if test="${pNum == totalPage-1}">
					<c:forEach var="i" begin="${pNum-3}" end="${pNum+1}">
						<!-- 현재 페이지가 마지막 페이지-1일때 -->
						<button class="btnPaging" value='${i}'>${i}</button>
					</c:forEach>
				</c:if>
				<c:if test="${pNum == totalPage}">
					<!-- 현재 페이지가 마지막 페이지일때 -->
					<c:forEach var="i" begin="${pNum-4}" end="${pNum}">
						<button class="btnPaging" value='${i}'>${i}</button>
					</c:forEach>
				</c:if>
			</c:if> --%>
			<!-- ********** 페이징 ********** -->

<%-- 			<c:if test="${totalPage > 5 and pNum < totalPage-2}"> --%>
				<!-- 전체 페이지의 개수 표시 -->
			... <button class="btnPaging" value='${totalPage}'>${totalPage}</button>
<%-- 			</c:if> --%>
		</nav>
	</div>
</div>
	</div>
	<!-- end comments-wrap -->
	<!-- Comments END -->

	<%@ include file="../../../footer.jsp"%>

<script type="text/javascript">



		</script>
		


	<!-- Java Script
    ================================================== -->
	
<script src="resources/js/j_ajax.js"></script>
	<script src="resources/js/plugins.js"></script>
	<script src="resources/js/main.js"></script>
	
	 <script src="resources/js/j.independent.js"></script>
</body>

</html>