<%@page import="java.util.List"%>
<%@page import="com.kosmo.bangdairy.vo.IndieVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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


<script src="resources/js/j_ajax.js"></script>
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
	<div class="comments-wrap">

		<div id="comments" class="row">
			<div class="col-full">

				<!-- respond
                    ================================================== -->
				<div class="respond">
					<!-- 여기는 제목 -->
					<h1 class="s-content__header-title">ALL MOVIES</h1>

					<!-- 여기는 상단 네비게이션 바 START -->
					<nav class="clearfix">
						<ul class="clearfix">
							<li id="sa"class="clist"><a href="#">ACTION</a></li>
							<li id="sb"class="clist"><a href="#">HORROR</a></li>
							<li id="sc"class="clist"><a href="#">DRAMA</a></li>
							<li id="sd"class="clist"><a href="#">ANIMATION</a></li>
							<li id="se"class="clist"><a href="#">FANTASY</a></li>
							<li id="sf"class="clist"><a href="#">DOCU</a></li>
						</ul>
						<a id="pull" href="#">CATEGORY</a>
					</nav>
					<!-- 네비게이션 바 END -->

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
					<div class="col-twelve">
						<div class="table-responsive">
							<table>
								<thead>
									<tr>
										<th>영화</th>
										<th>영화제목</th>
										<th>장르</th>
										<th>개봉일</th>
										<th>평점</th>
									</tr>
								</thead>

							<%	List<IndieVO> result=(List<IndieVO>)request.getAttribute("result"); %>
					
								<tbody>
									<!-- 하나의 영화 START -->
									<% for (IndieVO vo : result){ %>
									<tr>
										<td><img src="resources/images/movieList/movieSam1.jpg"
											width="100px" height="100px"></td>
										<td><%=vo.getIndieTitle() %></td>
										<td><%=vo.getGenreId()%></td>
										<td><%=vo.getIndieUpdateDate() %></td>
										<td>
											<div class="starRev">
												<span class="starR on">별1</span> <span class="starR">별2</span>
												<span class="starR">별3</span> <span class="starR">별4</span>
												<span class="starR">별5</span>
											</div>
										</td>
									</tr>
									<!-- 하나의 영화 END -->
								<%}; %>
								</tbody>
							</table>
						</div>
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
			</div>
		</div>
	</div>
	<!-- end comments-wrap -->
	<!-- Comments END -->

	<%@ include file="../../../footer.jsp"%>




	<!-- Java Script
    ================================================== -->
	
	<script src="resources/js/plugins.js"></script>
	<script src="resources/js/main.js"></script>
	<script src="resources/js/movieList.js"></script>
</body>

</html>