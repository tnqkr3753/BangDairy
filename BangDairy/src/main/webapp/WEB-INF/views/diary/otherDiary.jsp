<%@page import="java.util.List"%>
<%@page import="com.kosmo.bangdairy.vo.DairyVO"%>
<%@page import="com.kosmo.bangdairy.vo.MovieVO"%>
<%@page import="com.kosmo.bangdairy.vo.WishMovieVO"%>
<%@page import="com.kosmo.bangdairy.vo.DairyUserVO"%>
<%@page import="com.kosmo.bangdairy.vo.AccountFormVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html class="no-js" lang="en">
<head>

<!--- basic page needs
    ================================================== -->
<meta charset="utf-8">
<meta name="description" content="">
<meta name="author" content="">

<!-- mobile specific metas
    ================================================== -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- write dairy -->
<meta charset="EUC-KR">
<meta charset="utf-8">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS
    ================================================== -->
<!-- write dairy -->
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<link rel="icon" href="favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="bootstrap.min.css">

<link rel="stylesheet" href="resources/css/base.css">
<link rel="stylesheet" href="resources/css/vendor.css">
<link rel="stylesheet" href="resources/css/main.css">
<link rel="stylesheet" href="resources/css/maindairy.css">
<link rel="stylesheet" href="resources/css/dairycss/nickdairy.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
	integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
	crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/dairycss/writeDiary.css">



<link rel="stylesheet" href="dist/jquery.kyco.googleplusfeed2.css">
<link rel="stylesheet" href="dist/jquery.kyco.googleplusfeed.demo.css">
<link href="https://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">


<!-- script
    ================================================== -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="resources/js/modernizr.js"></script>
<script src="resources/js/pace.min.js"></script>



<!-- favicons
    ================================================== -->
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<link rel="icon" href="favicon.ico" type="image/x-icon">

</head>
<body id="top">
	<%@ include file="../../../header_menu.jsp"%>

	<!-- s-content
    ================================================== -->
	<section 
		class="s-content s-content--narrow s-content--no-padding-bottom">
		<article class="row format-audio" id="parents">

			<p class="myDiaryHeader" style="font-size: 35px;">

				<c:forEach items="${leftuserinfo }" var="ufo">
					<img src="resources/images/diary/cinema.png"
						style="width: 10%; height: 10%;">
				${ufo.userId}님의 다이어리
				<img src="resources/images/diary/cinema.png"
						style="width: 10%; height: 10%;">
			</p>


			<!-- 나의 프로필 START -->
			<div class="myleftTap"
				style="border: 3px solid black; width: 30%; height:750px; border-radius: 20px; padding: 10px; margin: 10px;">
				<h3 class="s-content__author-name5">

					"${ufo.userId}" 님 </br>
					</br>
					<!-- 프로필 사진 -->
					<c:choose>
						<c:when test="${!empty userInfo.userProfile}">
							<img src="resources/upload/userProfile/${ufo.userProfile}" alt="">
						</c:when>
						<c:otherwise>
							<!-- 마이프로필에 등록된 이미지가 없으면 -->
							<img src="resources/upload/userProfile/userDefaultImage.png"
								style="width: 70%; height: 70%;">
						</c:otherwise>
					</c:choose>
					</br>
					
					<hr/>

					<div id="myProfile" style="font-size: 32px;">
						<ul>
							<!-- 생일 -->
							<br />
							<li style="text-align: left;">생년월일 <br />:
								${fn:substring(ufo.userReg, 2, 4)}월 ${fn:substring(ufo.userReg, 4, 6)}일
							</li>
							<br />

							<!-- 성별 -->
							<li style="text-align: left;"><c:if
									test="${ufo.userGender == 2}">
								성별 : 여자
							</c:if> <c:if test="${ufo.userGender == 1}">
								성별 : 남자
							</c:if></li>
							<br />
					</div>
					<hr />
					<br />
					
					<p style="font-size: 30px;">
					찜 영화목록		
					</p>
					<c:forEach items="${myDwishList }" var="dwi">
					<p style="font-size: 20px;">-"${dwi.movieTitle}"-</p>
					
					</c:forEach>
					
			</div>
			<!-- 나의 프로필 END -->

			</c:forEach>
			<div class="myRightTap" style="width: 65%">

				<div id="diaryDetail" style="text-align: center;">
					<section style="border: 3px solid black; border-radius: 2em; padding: 10px; background: white; font-size: 9px;">

						<!-- 다이어리 상세 정보 -->

						<c:forEach items="${otherdddlist }" var="diy">
							<!-- 다이어리 제목 -->
							<header id="diaryDetailTitle">
								<!-- 다이어리 이미지 -->
								<img src="resources/images/diary/diaryCircle.png"
									style="height: 20px; width: 300px;">
								<!-- 다이어리 제목 -->
								<h2 style="font-size: 30px;">${diy.diary_title }</h2>
							</header>
							<br />
							<!-- 조회수 -->
							<h2 style="text-align: right; margin-right: 20px;">조회수 :
								${diy.diary_hits }</h2>

							<!-- 다이어리 이미지가 있다면 -->
							<c:if test="${not empty diaryDetailList.diaryImage}">
								<img src="${diy.diary_image }"
									style="width: 200px; height: 200px;">
							</c:if>
							<!-- 다이어리 이미지가 없다면 -->

							<c:if test="${empty diaryDetailList.diary_image}">
								<img src="resources/images/defaultImage.png"
									style="width: 200px; height: 200px;">
							</c:if>

							<!-- 영화 제목 -->
							<span><br />[${diy.movie_id }]</span>

							<!-- 다이어리 내용 -->
							<span><br />${diy.diary_content}</span>

							<!-- 누구와? 언제? 어디서? -->
							<ul>
								<li style="text-align: left;">${diy.viewing_together}와(과)
									함께</li>
								<li style="text-align: left;">언제?
									${fn:substring(diy.viewing_date, 0, 10)}</li>
								<li style="text-align: left;">어디서? ${diy.viewing_location}</li>
							</ul>

							<!-- 좋아요 / 싫어요 -->

							<div id="likehate">
								<input type="hidden" id="aaa" value="${diy.diary_id}">								
								<button id="btnDiaryLike" style="float: left; margin-left: 60%;" type="submit" >
									좋아요 ${diy.likehit }<i class="fa fa-thumbs-up"></i>
								</button>

								<button id="btnDiaryHate" style="float: right;" type="submit" id="btnDiaryHate">
									싫어요 ${diy.hatehit }<i class="fa fa-thumbs-down"></i>
								</button>
							
							</div>
							
						</c:forEach>
						<br/> <br/> <br/>
						</div></div></article>
						<div id="maretabtab"></div>
<br/> <br/> <br/>
</section>

</article>
	</section>

	<!-- Java Script
    ================================================== -->
	<script src="/resources/js/plugins.js"></script>
	<script src="/resources/js/main.js"></script>
	<script src="resources/js/otherdiary.js"></script>
	<script src="resources/js/otherdiaryList.js"></script>
	<%@ include file="../../../footer.jsp"%>
</body>
</html>