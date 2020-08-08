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
		<article class="row format-audio">


			
			<c:forEach items="${userInfo}" var="userInfo">
				<p style="font-size: 35px">${userInfo.userId}님 다이어리</p>

				<!-- 나의 프로필 START -->
				<div class="myleftTap">
					<h3 class="s-content__author-name5">
					
						<!-- 프로필 사진 -->
						</br></br><img src="resources/images/avatars/user-03.jpg" alt=""></br></br>
						${userInfo.userId}님</br>
						<a href="#0">나의 프로필 보기</a>
						<hr/>
						
						<div id="myProfile">
							이메일 : ${userInfo.userEmail} <br/>
							생년월일 : ${fn:substring(userInfo.userReg, 2, 4)}월
									${fn:substring(userInfo.userReg, 4, 6)}일 <br/>
							
							<!-- 성별 -->
							<c:if test="${userInfo.userGender == 2}">
								성별 : 여자
							</c:if>
							<c:if test="${userInfo.userGender == 1}">
								성별 : 남자
							</c:if>
						</div><hr/>
					
					<!-- 글 등록 버튼 -->
					<input type="button" class="submit btn--primary btn--large full-width"
					onclick="location.href='writediary'" value="새글등록">
				</div>
				<!-- 나의 프로필 END -->
			</c:forEach>
			
			<div class="diaryDetail" style="margin-left:300px;">
				<!-- Ajax로 다이어리 디테일 붙이는곳 -->
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