<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>

    <!--- basic page needs
    ================================================== -->
    <meta charset="utf-8">
    <title>Audio Post Format - Philosophy</title>
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- mobile specific metas
    ================================================== -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <!-- CSS
    ================================================== -->
    <link rel="stylesheet" href="resources/css/base.css">
    <link rel="stylesheet" href="resources/css/vendor.css">
    <link rel="stylesheet" href="resources/css/main.css">
    <link rel="stylesheet" href="resources/css/maindairy.css">

    <!-- script
    ================================================== -->
    <script src="js/modernizr.js"></script>
    <script src="js/pace.min.js"></script>

    <!-- favicons
    ================================================== -->
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="icon" href="favicon.ico" type="image/x-icon">


    <link rel="stylesheet" href="bootstrap.min.css">
    <link href="font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" href="/dist/metisMenu.min.css">
    <link rel="stylesheet" href="/path/to/cdn/bootstrap.min.css" />
    <link href="simplePagination.css" rel="stylesheet" />
    
</head>

<body id="top">

   		<%@ include file="header_menu.jsp"%>
		<%@ include file="account_form.jsp"%>
		<%@ include file="Sign_In.jsp"%>


    <!-- s-content
    ================================================== -->
    <section class="s-content s-content--narrow s-content--no-padding-bottom">

        <article class="row format-audio">
        
        <a id="userhello">"예슬"</a>
        <a style="font-size: 35px">님 다이어리</a></br></br></br>
			<div class="myleftTap">	
						<h3 class="s-content__author-name5"></br></br>
						<img src="resources/images/avatars/user-03.jpg" alt="">
						</br></br>
						예슬이</br><a href="#0">myprofile go</a>
						</h4>
										
				<div id="myrigthprofile">
				<h4>name: 노예슬</br>
				age: 25</br>
				gender: 여자</br>
				e-mail: rys587@naver.com</h4>
				</div>

				<ul id="menu">
				</br></br>
				  <li class="active">
				  
				    <a href="#" class="has-arrow" aria-expanded="true">친구랑 같이본 영화</a>
				    <ul>
				      <li><a href="#">공포</a></li>
				      <li><a href="#">로맨스</a></li>
				      <li><a href="#">드라마</a></li>
				    </ul>
				  </li>
				  <li>
				    <a href="#" class="has-arrow" aria-expanded="false">부모님과 본 영화</a>
				    <ul>
				    
				      <li><a href="#">청불</a></li>
				      <li><a href="#">나머지</a></li>
				      <li>
				        <a href="#" class="has-arrow" aria-expanded="false">가장 좋아하는 영화</a>
				        <ul>
				          <li><a href="#">BEST 01</a></li>
				          <li><a href="#">BEST 02</a></li>
				          <li><a href="#">BEST 03</a></li>
				        </ul>
				      </li>
				    </ul>
				  </li>
				</ul>
			</div>
			<div class="myRightTap">			
                <div class="s-content__header-title">
                                   <div class="goodHate" style="text-align: right;">
                    </br>
                    <button type="button" class="btn btn-link">
							<i class="fa fa-thumbs-up"></i> 좋아요
						</button>
						<button type="button" class="btn btn-link">
							<i class="fa fa-thumbs-down"></i> 싫어요
						</button>
                    <h2 style="text-align: center">여기는 다이어리 제목</h2>
     
					<h4>2020년 XX월 XX일 X요일</h4>

						
						<div class="starRev" >
							<span class="starR on"></span> <span class="starR"></span> <span
								class="starR"></span> <span class="starR"></span> <span
								class="starR"></span>
						</div>
					
					</br> 
					
					<div style="text-align : center;"><img src="resources/images/avatars/user-05.jpg"></div>

					<h4>Donec sollicitudin molestie malesuada. Nulla quis lorem ut
						libero malesuada feugiat. Pellentesque in ipsum id orci porta
						dapibus. Vestibulum ante ipsum primis in faucibus orci luctus et
						ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet
						aliquam vel, ullamcorper sit amet ligula. Quisque velit nisi,
						pretium ut lacinia in, elementum id enim. Donec sollicitudin
						molestie malesuada.</h4>

				

			 <nav class="pgn">
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
        </article>
</section>
		<%@ include file="footer.jsp"%>

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
    <script src="resources/js/jquery-3.2.1.min.js"></script>
    <script src="resources/js/plugins.js"></script>
    <script src="resources/js/main.js"></script>
    <script src="resources/jquery.min.js"></script>
	<script src="https://use.fontawesome.com/5ac93d4ca8.js"></script>
	





</body>

</html>