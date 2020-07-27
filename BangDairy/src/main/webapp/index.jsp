<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html class="no-js" lang="en">
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
<title>Philosophy</title>
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
	<!-- 다이어라 자리  -->
		<div class="pageheader-content row"  >
			<div class="col-full" style="margin-bottom: 1%">
				<div class="featured" style="background-image: url('resources/images/thumbs/featured/featured-guitarman.jpg');">
				

			</div>
			<!-- end col-full -->
		</div>
		</div>
		
		<nav class="pgn" >
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
          
		<!-- end pageheader-content row -->

		<!-- </section> end s-pageheader -->


		<!-- s-content
    ================================================== -->
		 <div >
<%for(int b=0; b<3;b++){ %> <!-- for문 시작  -->
        <div class="row masonry-wrap"  >
       
        <span class=title>AI추천</span>
         <div class="bxslider" id="stastistical-part"> 
         <%for(int a=0;a<5;a++){ %> <!-- for문 시작 -->
        	
            <div class="masonry"style="background-color: black">

                <div class="grid-sizer">

             <article class="masonry__brick entry format-standard" data-aos="fade-up" style="background-color: black">
                         
                    <div class="entry__thumb"style="background-color: black">
                    
                        <a href="﻿https://youtu.be/gspxp2lAR7A?t=211" class="entry__thumb-link" >
                            <img src="resources/images/thumbs/masonry/lamp-400.jpg" class="entry__thumb-link1"
                                    srcset="resources/images/아이유.jpg 1x, resources/images/thumbs/masonry/lamp-800.jpg 2x" alt="">
                    
                        </a>
                    </div>
    
    <div class="board" style="background-color: black">
  
  
                    <div class="entry__text" style="background-color: black">
                        <div class="entry__header" style="background-color: black">
                           
                            <h1 class="entry__title"><a href="Independent.do"><p class=rr>트랜스포머: 패자의 역습 (제목)</p></a></h1>
                            
                        </div>
                         <div class="entry__date" style="background-color: black">
                               <a href=https://people.search.naver.com/search.naver?sm=tab_hty&where=nexearch&query=이지은&x=0&y=0><div  align="right">이지(감독? 배우?)</div></a>
                            </div>
                        <div class="entry__excerpt" style="background-color: black">
                          
                        </div>
                        <div class="entry__meta" style="background-color: black">
                            <span class="entry__meta-links">
                                 <a href="https://www.naver.com/"><spen><i class="fa fa-play-circle-o fa-2x " aria-hidden="true"title="예고편시청"></i></spen></a>
                                <a href="#0"><spen><i class="fa fa-heart fa-2x" aria-hidden="true"title="좋아요"></i></spen></a>
                            </span>
                        </div>
                         </div>
                         
                         </div>
                         </article>
                    </div>
                    </div>
                    <%} %> <!-- for문 끝 -->
                 </div>
                 </div>
                <%};%>   <!-- for문 끝 -->
                
             
  
<div class="home__slider"> 
    <div class="bxslider1">
    <%for(int d=1;d<=8;d++){ %> 
        <a href="https://www.youtube.com/watch?v=N7vJxDDFmPY"><div><img src="resources/images/<%=d%>.jpg" alt="그림1"></div></a>
     
         <%} %>
    </div> 
</div> 

    </div>
		<!-- end s-extra -->
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

		<script src="resources/js/plugins.js"></script>
		<script src="resources/js/main.js"></script>
		  <script type="text/javascript" src="resources/js/js1/j.jquery.js"></script>
 
		
	</div>
</body>

</html>