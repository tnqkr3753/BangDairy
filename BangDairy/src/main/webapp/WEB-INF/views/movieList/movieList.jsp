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
					<h1 class="s-content__header-title">ALL MOVIES</h1>

					<!-- 여기는 상단 네비게이션 바 START -->
					<nav class="clearfix">
						<ul class="clearfix">
							<li class="clist"><a href="#">ACTION</a></li>
							<li class="clist"><a href="#">HORROR</a></li>
							<li class="clist"><a href="#">DRAMA</a></li>
							<li class="clist"><a href="#">ANIMATION</a></li>
							<li class="clist"><a href="#">FANTASY</a></li>
							<li class="clist"><a href="#">DOCU</a></li>
						</ul>
						<a id="pull" href="#">CATEGORY</a>
					</nav>
					<!-- 네비게이션 바 END -->

					<!-- 검색창과 Select Box -->
					<div class="select">
						<!-- 검색창 -->
						<input class="form-control" type="text" placeholder="Search"
							style="float: left;">

						<div class="search__tab" style="font-size: 30px; float: right;">
							<input type="radio" value="Title" name="searchTab"
								checked="checked" style="width: 20px; height: 20px;">&nbsp;Title
							<input type="radio" value="Director" name="searchTab"
								style="width: 20px; height: 20px;">&nbsp;Director <input
								type="radio" value="Actor" name="searchTab"
								style="width: 20px; height: 20px;">&nbsp;Actor <input
								type="radio" value="Keywords" name="searchTab"
								style="width: 20px; height: 20px;">&nbsp;Keywords
						</div>
					</div>
					<br /> <br /> <br />
					<!-- 정렬기준 Select Box -->
					<select name="order" id='orderBy' style="float: right;">
						<option value="default">정렬기준</option>
						<option value="title">영화제목순</option>
						<option value="year">개봉일순</option>
						<option value="score">평점순</option>
					</select>

					<!-- 영화리스트 START -->
					<div class="col-twelve" id="movieSearch">

						<!-- ********** Ajax로 붙이는 부분 ********** -->

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
	<script src="resources/js/movieList.js"></script>
</body>

</html>