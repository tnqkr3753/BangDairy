
<%@page import="com.kosmo.bangdairy.vo.DairyVO"%>
<%@page import="com.kosmo.bangdairy.vo.MovieVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
<link rel="stylesheet" href="resources/css/dairycss/dairyList.css">

<!-- script
    ================================================== -->
<script src="resources/js/modernizr.js"></script>
<script src="resources/js/pace.min.js"></script>

<!-- favicons
    ================================================== -->
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<link rel="icon" href="favicon.ico" type="image/x-icon">

<!-- jquery lib import -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

</head>

<body id="top">
	<%@ include file="../../../header_menu.jsp"%>

	<!-- s-content
    ================================================== -->

	<!-- Comments START -->
	<!-- Comments START -->
	<div class="comments-wrap">

		<div id="comments" class="row">
			<div class="col-full">

				<!-- respond
                 
                 
                    ================================================== -->
				<div class="respond">
					<!-- 여기는 제목 -->
					<h1 class="s-content__header-title">Diary</h1>

					<!-- 여기는 상단 네비게이션 바 START -->
					<nav class="clearfix">
						<ul class="clearfix">
							
							<li class="clist"><a href="#"></a></li>
						</ul>
						<a id="pull" href="#">CATEGORY</a>
					</nav>
					<!-- 네비게이션 바 END -->

					<!-- 검색창과 Select Box -->
					<div class="select">
						<!-- 검색창 -->
						<form method="post" action="dairySearch">
					      <p><label style="font-size: 30px;">상세 검색 : <input style="width: 20%" type="text" name="searchWord"></label></p>
					    </form>
					</div>
				
					<!-- 영화리스트 START -->
					<div class="col-twelve" >
						<div class="table-responsive">
							<table >
								<thead>
								
									<tr >
										<th style="font-size:20px; ">사진</th>
										<th style="font-size:20px;  width: 15%;">제목</th>
										<th style="font-size:20px;  ">내용</th>
										<th style="font-size:20px;  width: 15%;">유저 아이디</th>
										<th style="font-size:20px;  width: 15%; ">조회수 </th>		
										<th style="font-size:20px;   ">다이어리 이동 </th>		
									
									</tr>
										
								
								 <c:forEach items="${list }" var="search" >   
								 <tbody>    
									<tr >
										<td><img src="${search.diaryImage }"
											 height="400px"></td>
										<td style="align-self: center; width: 60px;">${search.diaryTitle } </td>
								
										<td >${search.diaryContent } </td>
										<td >${search.userId } </td>
										<td >${search.diaryHits} </td>
										<td ><button>이동</button> </td>
									
									</tr>
									</tbody>
								</c:forEach>
							</thead>
							</table>
						</div>
					</div>
		
		<div class="row">
			
				<nav class="pgn">
					<!-- 페이징 -->
					<ul>
						<li><a class="pgn__prev" href="#0">Prev</a></li>
						<li><a class="pgn__num" href="#0">1</a></li>
						<li><span class="pgn__num current">2</span></li>
						<li><a class="pgn__num" href="#0">3</a></li>
						<li><a class="pgn__num" href="#0">4</a></li>
						<li><a class="pgn__num" href="#0">5</a></li>
						<li><span class="pgn__num dots">…</span></li>
						<li><a class="pgn__num" href="#0">8</a></li>
						<li><a class="pgn__next" href="#0">Next</a></li>
					</ul>
				</nav>
			
		</div></div>
		</div>
		</div>
		</article>
		</section>
	<!-- </div> -->
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
	<script src="resources/js/movieList.js"></script>
</body>

</html>