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
	<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
   
    <!-- script
    ================================================== -->
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
   <script src="resources/js/mainDiary.js"></script>
    <script src="resources/js/modernizr.js"></script>
    <script src="resources/js/pace.min.js"></script>
    <script src="resources/js/maindiaryright.js"></script>
    

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
         
                <img style="margin-left: 30%; width:40%;" src="resources/images/maindiary.PNG">
         
            <br/>
            
            <form method="post" action="dairySearch">
               <input style="width: 380px;display: inline-block; font-size:28px;"  placeholder="검색어를 입력해주세요" type="text" name="searchWord">
               <select style="display: inline-block; font-size:20px; " id="search-type" name="searchType">   
                  <option value="m.movie_title">영화 제목</option>
                  <option value="d.user_id">글쓴이</option>
                  <option value="d.diary_title">다이어리 제목</option>
               </select>
                <button style="width: 12%; margin-left: 19%; font-size:20px;" type="button" id="btnRegisterDiary"
					onclick="location.href='writediary'">새글등록</button>
					
            <button style="width: 20%;  font-size:20px; " type="button" 
					onclick="location.href='getdairy'">내다이어리 가기</button>
            </form>
      </div>
   </div>
   <c:if test="${not empty recentdairy }">
       <div class="insertDiaryTop" style="font-size: 43px; text-align: center;">
         
         <img src="resources/images/diary/diary.png"
                        style="height: 40px; width: 40px;">
                    내가 최근에 쓴 다이어리와 비교해 보세요
         <img src="resources/images/diary/diary.png"
                        style="height: 40px; width: 40px;">
         
      </div>
   </c:if>
   <div id="ramdairy" class="heading" >          
       <table>
       
         <c:forEach items="${recentdairy}" var="recent">
         <form action="getdairy" method="POST" ">
            <td>
            <input name="userId" type="hidden" value="${recent.userId }">
            <input name="diaryId" type="hidden" value="${recent.diaryId }">
               <div class="table" style=" border: 2px solid black; background-color:white; height:400px; width:300px; 
                        border-radius: 20px; padding: 10px; margin: 10px;">
                  <table >
                     <thead >
                        <tr style="border: none;">  
                                 <td><img style="max-width: auto; height:280px; max-height: 200px; border: 2px solid black;" src="${recent.diaryImage }" onerror='this.src="resources/images/defaultImage.png"'>
                                 </td>   
                        </tr>
                        <tr style="border: none;">
                                   <td>
                                      <div style="font-size: 18px; text-align: center;">${recent.diaryTitle }
                                      </div>
                                   </td>
                                </tr>
                           </thead>
                       </table>
                   </div>
                   <div style="padding-left: 50%;">
                   <button type="submit" class="btn btn-success btn-circle btn-circle-sm m-1"><i class='fa fa-mail-forward'></i></button> 
            	</div>
             </td>
           </form>
            </c:forEach> 
        </table>   
   </div>
	 </br> </br> </br>
   <div class="s-content__header-title" style="text-align: center; font-size: 60px;">
  
  <img style="height: 60px; width: auto;" src="resources/images/diary/thismonthdiary2.PNG">
   이달의 추천 다이어리
   <img style="height: 60px; width: auto;" src="resources/images/diary/thismonthdiary2.PNG">
   </div>
   
	</div>
	<div class = "mydairy">
	
		<div class="left-dairy-maintab">
			<div id="mydairyimg">
			
			<br/><br/>
			
			<c:forEach items="${topdairy}" var="top">  
			<form action="getdairy" method="POST" >
				
				<input name="userId" type="hidden" value="${top.user_id }">
          		<input name="diaryId" type="hidden" value="${top.diary_id }">
          		
			<div class="container text-center">
				
				<div class="row">
					<div class="col-md-4 col-sm-4 col-xs-12 team-box">
					
						<div class="team-boxs">
						<h1 style="text-align: center;  margin-top: inherit;">${top.diary_title }</h1>
							<h4 class="s-content__author-name">
						<img style="width: 40px; height: auto;" src="${top.absolute_file_path }" 
						onerror='this.src="resources/images/diary/userDefaultImage.png"'	alt="">
						<a style="margin-top: 0px;" href="#0">${top.user_id }</a>
						
					</h4>								
					
						
						<img src="${top.diary_image }" style="">
						<h5 style="padding-left: 80%"> 조회수 : ${top.diary_hits }</h5>
						<h3>${top.diary_content }</h3>
				
						</div>
					</div>
				
				</div>
				
				
			</div>
			
			</br>
			
			</br></br></br></br>
			</br></br><</br></br><div style="padding-left:95%">
                   <button type="submit" class="btn btn-success btn-circle btn-circle-sm m-1"><i class='fa fa-mail-forward'></i></button> 
            	</div></br>
			</form>
			</c:forEach>
				

			</div>
		</div>
	</div>

<br/><br/><br/>
   <div style=" border: 2px solid black; background-color:white; 
                        border-radius: 10px;" class="right-dairy-maintab">
   
   <br/><br/>
      
        <div style="font-size: 25px; text-align: center">나와 가장 비슷한 취향의</br> 유저를 찾아보세요</div>
		<br/><br/>
		<div class="content" >
			
			<c:forEach items="${mostliked }" var="most"> 
				<form action="getdairy" method="POST" >
				
				<input name="userId" type="hidden" value="${most.userId }">
          		<input name="diaryId" type="hidden" value="${most.diaryId }">
          		
          		
			<div class="top-section">
				<div class="user-img" style="margin-left:60px; width: 250px; height:250px;;">
				<c:choose>
						<c:when test="${!empty most.userProfile}">
						<img src="resources/upload/userProfile/${most.userProfile}" alt=""></c:when>
						<c:otherwise> <!-- 마이프로필에 등록된 이미지가 없으면 -->
						<img src="resources/upload/userProfile/userDefaultImage.png" style="width:70%; height:70%;"> </c:otherwise>
						</c:choose>
				<div style="font-size: 30px; " class="user-detail ">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp${most.userId }</div>
				</div>
					<button style="font-size: 20px; margin-left: 40px;" type="submit">유저 다이어리로 이동</button>
			</div>
			</form>
			</c:forEach>
			<div class="sub-comment"></div>
			
			<div class="comment-box box">
				
				<div style="clear:both;"></div>
				<div class="comment-btn">
					<input type="textarea" class="text" rows="10" cols="30" placeholder="Add a comment...">
				</div>
			</div>
		</div>
		<div class="add-comment">
			<div class="box">
			<c:forEach items="${userInfo}" var="userInfo">
				
					<c:choose>
						<c:when test="${!empty userInfo.userProfile}">
						<img src="resources/upload/userProfile/${userInfo.userProfile}" alt=""></c:when>
						<c:otherwise> <!-- 마이프로필에 등록된 이미지가 없으면 -->
						<img src="resources/upload/userProfile/userDefaultImage.png" style="width:70%; height:70%;"> </c:otherwise>
						</c:choose>
				</div>
			</c:forEach>	
				<div class="add-comment-text">
					<textarea rows="5" class="example-textarea"></textarea>
				</div>
				<div style="clear:both;"></div>
			</div>
			<div class="add-comment-text-btn">
				<button class="post-comment-btn">Post Comment</button>
				<button class="cancel-btn">Cancel</button>
			</div>
			
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