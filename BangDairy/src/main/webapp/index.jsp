<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- resources/css
    ================================================== -->
 <meta name="msapplication-TileColor" content="#FFFFFF">
  <!-- 왼쪽바 구현 css-->
 <link rel="stylesheet" type="text/css" href="resources/css/css2/laftbar.css">
  <!-- 왼쪽바 구현 -->
 
 <link type="text/css" rel="stylesheet" charset="UTF-8" href="https://translate.googleapis.com/translate_static/css/translateelement.css">

<!-- 슬라이더 구현에 필요함 따로 빼서 써도 아이콘 구현이 안됨 -->
 <link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
	<!-- ================================================ -->
    <link rel="stylesheet" href="resources/css/base.css">
    <link rel="stylesheet" href="resources/css/vendor.css">
    <link rel="stylesheet" href="resources/css/main.css">
    <link rel="stylesheet" href="resources/css/independent.css">
  
<!-- script
    ================================================== -->
<script src="resources/js/modernizr.js"></script>
<script src="resources/js/pace.min.js"></script>

<!-- favicons
    ================================================== -->
  <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="icon" href="favicon.ico" type="image/x-icon">


<script src="https://code.jquery.com/jquery-3.3.1.js"></script>

 <script src="resources/js/js1/jquery.bxslider.min.js"></script>


<script type="text/javascript" src="resources/js/main2.js"></script>
<script type="text/javascript" src="resources/js/account_form.js"></script>
<script type="text/javascript" src="resources/js/Sign_in.js"></script>

<!-- ====회원가입 폼==== -->

<!-- ========================================================= -->
</head>



<body id="top">
	<div id="main_all">
		<%@ include file="header_menu.jsp"%>
		<%@ include file="account_form.jsp"%>
		<%@ include file="Sign_In.jsp"%>
		<%@ include file = "leftbar.jsp" %>
		<div class="pageheader-content row">
			<div class="col-full">

				<div class="featured">

					<div class="featured__column featured__column--big">
						<div class="entry"
							style="background-image: url('resources/images/thumbs/featured/featured-guitarman.jpg');">

							<div class="entry__content">
								<span class="entry__category"><a href="#0">Music</a></span>

								<h1>
									<a href="#0" title="">What Your Music Preference Says About
										You and Your Personality.</a>
								</h1>

								<div class="entry__info">
									<a href="#0" class="entry__profile-pic"> <img
										class="avatar" src="resources/images/avatars/user-03.jpg"
										alt="">
									</a>

									<ul class="entry__meta">
										<li><a href="#0">John Doe</a></li>
										<li>December 29, 2017</li>
									</ul>
								</div>
							</div>
							<!-- end entry__content -->

						</div>
						<!-- end entry -->
					</div>
					<!-- end featured__big -->

					<div class="featured__column featured__column--small">

						<div class="entry"
							style="background-image: url('resources/images/thumbs/featured/featured-watch.jpg');">

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
							<!-- end entry__content -->

						</div>
						<!-- end entry -->

						<div class="entry"
							style="background-image: url('resources/images/thumbs/featured/featured-beetle.jpg');">

							<div class="entry__content">
								<span class="entry__category"><a href="#0">LifeStyle</a></span>

								<h1>
									<a href="#0" title="">Throwback To The Good Old Days.</a>
								</h1>

								<div class="entry__info">
									<a href="#0" class="entry__profile-pic"> <img
										class="avatar" src="resources/images/avatars/user-03.jpg"
										alt="">
									</a>

									<ul class="entry__meta">
										<li><a href="#0">John Doe</a></li>
										<li>December 21, 2017</li>
									</ul>
								</div>
							</div>
							<!-- end entry__content -->

						</div>
						<!-- end entry -->

					</div>
					<!-- end featured__small -->
				</div>
				<!-- end featured -->

			</div>
			<!-- end col-full -->
		</div>
		<!-- end pageheader-content row -->

		<!-- </section> end s-pageheader -->


		<!-- s-content
    ================================================== -->
		 <div >
<%for(int b=0; b<3;b++){ %>
        <div class="row masonry-wrap"  >
       
        <span class=title>AI추천</span>
         <div class="bxslider" id="stastistical-part"> 
         <%for(int a=0;a<5;a++){ %>
        
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
  <ul class="list" >
  <li>
                    <div class="entry__text" style="background-color: black">
                        <div class="entry__header" style="background-color: black">
                           
                            <h1 class="entry__title"><a href="single-standard.html"><p class=rr>트랜스포머: 패자의 역습 (제목)</p></a></h1>
                            
                        </div>
                         <div class="entry__date" style="background-color: black">
                               <a href=https://people.search.naver.com/search.naver?sm=tab_hty&where=nexearch&query=이지은&x=0&y=0><div  align="right">이지(감독? 배우?)</div></a>
                            </div>
                        <div class="entry__excerpt" style="background-color: black">
                          
                        </div>
                        <div class="entry__meta" style="background-color: black">
                            <span class="entry__meta-links">
                                 <a href="https://www.naver.com/"><spen><i class="fa fa-play-circle-o" aria-hidden="true"title="예고편시청"></i></spen></a>
                                <a href="#0"><spen><i class="fa fa-heart" aria-hidden="true"title="좋아요"></i></spen></a>
                            </span>
                        </div>
                         </div>
                         </li>
                         </ul>
                         </div>
                         </article>
                    </div>
                    </div>
                    <%} %>
                 </div>
                 </div>
                <%};%>  
                
                
  <section class="timeline-part" id="timeline-part">

	<div class="content">
		<div class="container-template">

			<div class="headergroup">
			    <h2 class="in-point">
			        <span class="seconday"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">뭐가</font></font></span>
			        <span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">럭셔리 주택?</font></font></span>
			    </h2>
		    </div>

		    <div class="intro content-template">
		        <p><strong><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">오늘날 웹에서 최고의 럭셔리 호텔 쇼케이스입니다. </font></font></strong></p>
				<p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">세계 최고의 Luxury Homes 공급 업체 인 Luxury Homes는이 짧은 온라인 쇼케이스를 선보이는 것을 자랑스럽게 생각합니다. </font><font style="vertical-align: inherit;">우리는 당신이 그것을 즐기시기 바랍니다.</font></font></p>
				<p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Luxury Homes는 전 세계적으로 가장 안목 높은 고 가치 개인을 대상으로하는 글로벌 럭셔리 시장의 '숨겨진 보석'입니다.</font></font></p>
		    </div>

		    <ul class="timeline">					
					<li class="year in-point"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">2012 년</font></font></li>
				    <li class="upper-line in-point">
				    	<span class="title"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">2012 년 John Doe가 설립</font></font></span>
				    	<span class="timeline-content paragraph-text"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">“럭셔리 홈을 시작한 동기는 럭셔리 부동산 개발자가 자신의 작업을 더 잘 보여줄 수있는 더 넓은 플랫폼을 만드는 것이 었습니다.”
						 </font></font><strong><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">John Doe, 설립자 겸 관리 디렉터</font></font></strong>
						</span>
				    </li>

									
					<li class="year in-point"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">2013 년</font></font></li>
				    <li class="upper-line in-point">
				    	<span class="title"><font style="vertical-align: inherit
				    	;"><font style="vertical-align: inherit;">2800 명 이상이 1 년 안에 자신의 재산을 사고 팔다</font></font></span>
				    	<span class="paragraph-text timeline-content"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
				    		이 웹 사이트는 고급 아파트를 결합하여 세계에서 최고를 찾기 위해 실용적인 수준으로 어디로 가야하는지 제공합니다.
						</font></font></span>
				    </li>

				    <li class="year in-point"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">2014 년</font></font></li>
				    <li class="upper-line in-point">
				    	<span class="title"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Luxury Homes는 전 세계에서 사업을 시작했습니다.
				    	</font></font></span>
				    	<span class="timeline-content"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
				    		우리는 전 세계 12 개국에서 사업을 운영하고 있습니다. </font><font style="vertical-align: inherit;">우리는 그것을 전세계에 퍼 뜨리고 싶습니다. </font><font style="vertical-align: inherit;">당신은 우리 팀을이기는 데 참여할 수 있습니다
						</font></font></span>
				    </li>
			    </ul>
		    </div>
	    </div>

		</section>

  
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
  <!-- /옆에 바 구현 ; -->    
<%@ include file="leftbar.js.jsp" %>
		      <!-- /옆에 바 구현 ; --> 
		
	</div>
</body>

</html>