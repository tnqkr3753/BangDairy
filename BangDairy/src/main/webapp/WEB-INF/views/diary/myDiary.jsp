<%@page import="java.util.List"%>
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
<link href="font-awesome.css" rel="stylesheet">
<link href="simplePagination.css" rel="stylesheet" />
<link rel="stylesheet" href="resources/css/base.css">
<link rel="stylesheet" href="resources/css/vendor.css">
<link rel="stylesheet" href="resources/css/main.css">
<link rel="stylesheet" href="resources/css/maindairy.css">
<link rel="stylesheet" href="resources/css/dairycss/nickdairy.css">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<link rel="icon" href="favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="bootstrap.min.css">
<link href="font-awesome.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
	integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
	crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/dairycss/writeDiary.css">


<!-- script
    ================================================== -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="resources/js/modernizr.js"></script>
<script src="resources/js/pace.min.js"></script>
<script src="resources/js/myDiary.js"></script>


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

			<c:forEach items="${userInfo}" var="userInfo">
				<p class="myDiaryHeader" style="font-size: 35px;">
				
				<img src="resources/images/diary/cinema.png" style="width:10%; height:10%;">
				${userInfo.userId}님의 다이어리
				<img src="resources/images/diary/cinema.png" style="width:10%; height:10%;">
				<hr/>
				</p>

				<!-- 나의 프로필 START -->
				<div class="myleftTap" style="border:3px solid black; border-radius:20px; padding:10px; margin:10px;">
					<h3 class="s-content__author-name5">
					
						"${userInfo.userId}" 님
						</br></br>
						<!-- 프로필 사진 -->
						<c:choose>
						<c:when test="${!empty userInfo.userProfile}">
						<img src="resources/upload/userProfile/${userInfo.userProfile}" alt=""></c:when>
						<c:otherwise> <!-- 마이프로필에 등록된 이미지가 없으면 -->
						<img src="resources/upload/userProfile/userDefaultImage.png" style="width:70%; height:70%;"> </c:otherwise>
						</c:choose>
						</br></br>
						<a href="myPage">마이페이지로<br/>이동하기</a>
						<hr/>
						
						<div id="myProfile" style="font-size:32px;">
							<ul>
							<!-- 생일 -->
							<br/>
							<li style="text-align:left;">생년월일 <br/>: ${fn:substring(userInfo.userReg, 2, 4)}월
																	  ${fn:substring(userInfo.userReg, 4, 6)}일</li><br/>
							<!-- 성별 -->
							<li style="text-align:left;">
							<c:if test="${userInfo.userGender == 2}">
								성별 : 여자
							</c:if>
							<c:if test="${userInfo.userGender == 1}">
								성별 : 남자
							</c:if></li><br/>
						</div><hr/><br/>
					
					<!-- 글 등록 버튼 -->
					<input type="button" id="btnRegisterDiary"
					onclick="location.href='writediary'" value="새글등록">
				</div>
				<!-- 나의 프로필 END -->
			</c:forEach>
			
			<div class="diaryDetail" style="margin-left:300px;">
				<!-- Ajax로 다이어리 디테일 붙이는곳 -->
				<br/>아래의 리스트에서<br/>다이어리를<br/>선택해주세요!
			</div>
			
			<div class="myRightTap">
				<!-- Ajax로 다이어리 리스트, 페이지 번호 붙이는 곳 -->
			</div>
		</article>
	</section>

	<!-- Java Script
    ================================================== -->
	<script src="/resources/js/plugins.js"></script>
	<script src="/resources/js/main.js"></script>
	<%@ include file="../../../footer.jsp"%>
</body>
</html>