<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html class="no-js" lang="ko">
<head>

<!--- 아이콘가지고오는 링크 fa fa-twier 등등
    ================================================== -->
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">	
<!--- basic page needs
    ================================================== -->
<meta charset="utf-8">
<meta name="description" content="">
<meta name="author" content="">

<!-- mobile specific metas
    ================================================== -->
<meta name="viewport"content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- resources/css
    ================================================== -->
 <meta name="msapplication-TileColor" content="#FFFFFF">

 <link type="text/css" rel="stylesheet" charset="UTF-8" href="https://translate.googleapis.com/translate_static/css/translateelement.css">
<!-- 슬라이더 구현에 필요함 따로 빼서 써도 아이콘 구현이 안됨 -->
<link rel="stylesheet" href="resources/css/bxslider.css">
	<!-- ================================================ -->
    <link rel="stylesheet" href="resources/css/base.css">
    <link rel="stylesheet" href="resources/css/vendor.css">
    <link rel="stylesheet" href="resources/css/main.css">
    <link rel="stylesheet" href="resources/css/independent.css">


<!-- favicons    ================================================== -->
  <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="icon" href="favicon.ico" type="image/x-icon">
<!-- script    ================================================== -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
 <script src="resources/js/js1/jquery.bxslider.min.js"></script>
<script type="text/javascript" src="resources/js/main2.js"></script>


<script src="resources/js/modernizr.js"></script>
<script src="resources/js/pace.min.js"></script>

</head>



<body id="top">
	<div id="main_all">
		<%@ include file="header_menu.jsp"%>
	<!-- 다이어라 자리 <!--  TODO  --> 
<!-- 		<div class="pageheader-content row"  >
			<div class="col-full" style="margin-bottom: 1%">
				<div class="featured" style="background-image: url('resources/images/thumbs/featured/featured-guitarman.jpg');">
							<div class="entry__content">
								<span class="entry__category"><a href="#0">Management</a></span>

								<h1>
									<a href="#0" title="">The Pomodoro Technique Really Works.</a>
								</h1>

								<div class="entry__info">
									<a href="#0" class="entry__profile-pic"> <img
										class="avatar" src="resources/images/avatars/user-03.jpg"
										alt="">
									</a>

									<ul class="entry__meta">
										<li><a href="#0">John Doe</a></li>
										<li>December 27, 2017</li>
									</ul>
								</div>
							</div>
				</div>
			</div>
			end col-full
			
		</div> -->
		</div>
		<!--  TODO  -->
<!-- 		<nav class="pgn" >
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
         	</nav> -->
          
		<!-- end pageheader-content row -->

		<!-- </section> end s-pageheader -->


		<!-- s-content
    ================================================== -->
		 <div id="list_container">
			 <div id="title_movie_list">
	
	                
	    	</div>
			 <div id="first_movie_list">
	
	                
	    	</div>
	    	<div id="second_movie_list">
	
	                
	    	</div>
	    	<div id="third_movie_list">
	
	                
	    	</div>
    	</div>
		<!-- end s-extra -->
		<%@ include file="footer.jsp"%>
		<!-- preloader
    ================================================== -->
	
		<!-- Java Script
    ================================================== -->

		<script src="resources/js/plugins.js"></script>
		<script src="resources/js/main.js"></script>
  <!-- /옆에 바 구현 ; -->    

		
</body>

</html>