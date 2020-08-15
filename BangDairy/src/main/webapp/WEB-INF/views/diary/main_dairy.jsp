<%@page import="com.kosmo.bangdairy.vo.DairyVO"%>
<%@page import="com.kosmo.bangdairy.vo.MovieVO"%>
<%@page import="com.kosmo.bangdairy.vo.AccountFormVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <!-- CSS
    ================================================== -->
    <link rel="stylesheet" href="resources/css/base.css">
    <link rel="stylesheet" href="resources/css/vendor.css">
    <link rel="stylesheet" href="resources/css/main.css">
	<link rel="stylesheet" href="resources/css/dairycss/maindairy.css">
	<link rel="stylesheet" href="resources/css/movieList.css">
	
    <!-- script
    ================================================== -->
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script src="resources/js/mainDiary.js"></script>
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
		
    <section class="s-content">
        
       
	<article class="row format-video">
	<article class="mydairy_up">

    <div class="col-full">
		<div class="respond">
			<div style="padding-left: 65%;" class="select">
						
			</div>
				<br/>
				<nav class="clearfix">
					<ul class="clearfix">
						<li class="clist"><a href="#"></a></li>
					</ul>
					<a id="pull" href="#">CATEGORY</a>
				</nav>
				<form method="post" action="dairySearch">
					<input style="width: 400px;display: inline-block; font-size:30px;"  placeholder="검색어를 입력해주세요" type="text" name="searchWord">
					<select style="display: inline-block; font-size:25px;" id="search-type" name="searchType">	
						<option value="m.movie_title">영화 제목</option>
						<option value="d.user_id">글쓴이</option>
						<option value="d.diary_title">다이어리 제목</option>
					</select>
				</form>
		</div>
	</div>
	<c:if test="${not empty recentdairy }">
	    <div class="insertDiaryTop" style="font-size: 43px; text-align: center;">
			
			<img src="resources/images/diary/diary.png"
								style="height: 40px; width: 40px;">
							최근에 쓴 다이어리 
			<img src="resources/images/diary/diary.png"
								style="height: 40px; width: 40px;">
			
		</div>
	</c:if>
	<div id="ramdairy" class="heading" >          
    	<table>
			<c:forEach items="${recentdairy}" var="recent">
				<td>
					<div class="table" style="border: 5px solid black; height:450px; width:350px; 
								border-radius: 20px; padding: 10px; margin: 10px;">
						<table >
							<thead >
								<tr style="border: none;">  
	      		      				<td><img style="max-width: auto; height:300px; max-height: 230px; border: 5px solid black;" src="${recent.diaryImage }" >
	      		      				</td>	
								</tr>
								<tr style="border: none;">
	                                <td>
	                                	<div style="font-size: 40px; text-align: center;">${recent.diaryTitle }
	                                	</div>
	                                </td>
	                            </tr>
							</thead>	
						</table>
					</div>
				</td>
         	</c:forEach>
        </table>
	</div>		
	<div class="s-content__header-title" style="text-align: center; font-size: 60px;">이달의 다이어리 추천
	</div>
	<form action="getdairy" method="POST" id="go-getdairy">
		<div class = "mydairy">
			<input type="hidden" id="monthly-uid" name="userId">
			<input type="hidden" id="monthly-did" name="diaryId">
			<div class="left-dairy-maintab">
				<div id="mydairyimg">
				<br/><br/>
					<c:forEach items="${topdairy}" var="top">       
			      		<div class="monthly-diary" data-did="${top.diary_id}" data-uid="${top.user_id }">
				      		<h4 class="s-content__author-name">
								<img src="${top.absolute_file_path }" 
								onerror='this.src="resources/images/diary/userDefaultImage.png"'	alt="">
								<br/>
								<a href="#0">${top.user_id }</a>
							</h4>								
							<div class="s-content__author-name2">
								<h2 style="text-align: center;">[${top.diary_title }]</h2>
								<img src="${top.diary_image }" style="">
								<h5 style="text-align:right; font-size:30px;"> 조회수 : ${top.diary_hits }</h5>
								<h5 style="font-size: 30px;">${top.diary_content }</h5>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</form>
	<div class="right-dairy-maintab">
		<br/><br/><br/><br/>
			<c:if test="${not empty vo }">
			<h3 class="s-content__author-name5"></h3>
			<img src="${vo.absoluteFilePath }" onerror='this.src="resources/images/diary/userDefaultImage.png"' alt="">
			<br/><br/>
			${vo.userId }<br/><a href="myPage">내 프로필 보기</a>
			<div id="myrigthprofile">
				<h4><%-- 가입 날짜 : <fmt:formatDate value="${vo.joinDate }"  type="date" dateStyle="full" /><br/> --%>
				* 나이 : ${vo.userAge }<br/>
				* 성별 : 
				<c:choose>
					<c:when test="${vo.userGender eq 1 }">남</c:when>
					<c:otherwise>여</c:otherwise>
				</c:choose><br/>
				* 이메일 : ${vo.userEmail }</h4>
			</div>	
			
			<div id="rigthmakediary">
				<button type="submit" class="submit btn--primary btn--large full-width">새 글 작성</button>
				<button type="submit" class="submit btn--primary btn--large full-width" index="mydairy_btn">내 다이어리</button>
			</div>
			</c:if>
			<div id="rigthotherdiary">
				<h3 style="margin: inherit; line-height: inherit; text-align: center;">이런    다이어리는 </h3>
				<h1 style="margin: inherit; line-height: inherit; text-align: center; border-bottom: ">어때?</h1><br/>
				<c:forEach items="${recommendairy}"  var="recommend">
					<img alt="" src="resources/upload/diary/${recommend.diaryImage }">
						<h3 style="font-size: 18px;  margin: inherit; line-height: inherit; ">${recommend.userId }<br/>
					  : ${recommend.diaryTitle }</h3><br/>
					
				</c:forEach>	
			</div>
	</div>
	</article>
	</article>
</section>
	<%@ include file="../../../footer.jsp"%>

    <!-- Java Script
    ================================================== -->
    <script src="resources/js/plugins.js"></script>
    <script src="resources/js/main.js"></script>

</body>
</html>