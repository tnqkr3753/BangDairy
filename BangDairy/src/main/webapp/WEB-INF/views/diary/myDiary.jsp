<%@page import="com.kosmo.bangdairy.vo.DairyVO"%>
<%@page import="com.kosmo.bangdairy.vo.MovieVO"%>
<%@page import="java.util.List"%>
<%@page import="com.kosmo.bangdairy.vo.AccountFormVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

<!-- script
    ================================================== -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="/resources/js/modernizr.js"></script>
<script src="/resources/js/pace.min.js"></script>

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

		<!-- 로그인 정보 -->
		<%
		AccountFormVO vo = new AccountFormVO();
        HttpSession sess = request.getSession();
        String id = (String) sess.getAttribute("userId");
        vo.setUserId(id);
		%>
					<c:forEach items="${userInfo}" var="userInfo">
		
			<p style="font-size: 35px">${userInfo.userId}</p>님 다이어리
	
			<!-- 나의 프로필 START -->
			<div class="myleftTap">
				<h3 class="s-content__author-name5">
					</br>
					</br> <img src="resources/images/avatars/user-03.jpg" alt=""> </br>
					</br>
					${userInfo.userId} 님</br>
					<a href="#0">나의 프로필 보기</a>
					</h4>
<hr/>
					<div id="myrightprofile">
						<h4>
						이메일 : ${userInfo.userEmail}
						<br/>
						생년월일 : ${fn:substring(userInfo.userReg, 2, 4)}월 
						${fn:substring(userInfo.userReg, 4, 6)}일
						<br/>
						<c:if test="${userInfo.userGender == 2}">
						성별 : 여자
						</c:if>
						<c:if test="${userInfo.userGender == 1}">
						성별 : 남자
						</c:if>
						</h4>
					</div>
					<hr/>
					<div id="rigthmakediary">
						</br>
						</br>
						<input type="button" class="submit btn--primary btn--large full-width" onclick="location.href='writediary'" value="새글등록">
					</div>
			</div>
			<!-- 나의 프로필 END -->
			</c:forEach>
			<div class="myRightTap">

				여기에 테이블로 리스트





				<div class="table-responsive">
					<table>
						<thead>
							<tr>
								<th>사진</th>
								<th>다이어리 제목</th>
								<th>영화 제목</th>
								<th>조회수</th>
							</tr>
						</thead>
						
						<div class="tab-search">
							<tbody class="diaryList">
													<c:forEach items="${myDiaryList}" var="myDiaryList">
								
								<tr>
									<td><img src="resources/images/movieList/"></td>
									<td>${myDiaryList.diary_title}</td>
									<td>${myDiaryList.movieTitle}</td>
									<td>수정필요</td>
								</tr>
								</c:forEach>
								
							</tbody>
						</div>
					</table>
				</div>









			</div>
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
