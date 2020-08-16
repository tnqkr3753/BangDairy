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
         
                <img style="margin-left: 270px;" src="resources/images/maindiary.PNG">
         
            <br/></br></br>
            
            <form method="post" action="dairySearch">
               <input style="width: 380px;display: inline-block; font-size:28px;"  placeholder="검색어를 입력해주세요" type="text" name="searchWord">
               <select style="display: inline-block; font-size:25px; " id="search-type" name="searchType">   
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
                    나와 비슷한 다이어리
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
               <div class="table" style="border: 5px solid black; height:400px; width:300px; 
                        border-radius: 20px; padding: 10px; margin: 10px;">
                  <table >
                     <thead >
                        <tr style="border: none;">  
                                 <td><img style="max-width: auto; height:280px; max-height: 200px; border: 5px solid black;" src="${recent.diaryImage }" onerror='this.src="resources/images/defaultImage.png"'>
                                 </td>   
                        </tr>
                        <tr style="border: none;">
                                   <td>
                                      <div style="font-size: 30px; text-align: center;">${recent.diaryTitle }
                                      </div>
                                   </td>
                        </tr>
                       
                     </thead> 
                       
                  </table>
               </div>
               <button style="background: black; font-size: 20px; color: white;" type="submit">다이어리 보기</button>
            </td>
           </form>
            </c:forEach>
            
        </table>
        
   </div>

 </br> </br> </br>


   <div class="s-content__header-title" style="text-align: center; font-size: 60px;">
  
  <img style="height: 60px; width: auto;" src="resources/images/diary/thismonthdiary1.PNG">
   이달의 추천 다이어리
   <img style="height: 60px; width: auto;" src="resources/images/diary/thismonthdiary2.PNG">
   </div>
   <form action="getdairy" method="POST" id="go-getdairy">
		<div class = "mydairy" ">
			<input type="hidden" id="monthly-uid" name="userId">
			<input type="hidden" id="monthly-did" name="diaryId">
			<div class="left-dairy-maintab">
				<div id="mydairyimg" ">
				<br/><br/>
					<c:forEach items="${topdairy}" var="top"> 
						<input name="userId" type="hidden" value="${top.user_id }">
          			  <input name="diaryId" type="hidden" value="${top.diary_id }">
					     <img style="height: 100px; width: 100%;" src="resources/images/diary/pagetop.png"> 
			      		<div style="background-color: white; padding-left : 60px; border-bottom: 1.5px black; border-left :1.5px black; border-right: 1.5px black; padding-bottom: 40px;" class="monthly-diary" data-did="${top.diary_id}" data-uid="${top.user_id }">
				      		
				      		<h3 class="s-content__author-name">
				      		
								<img  src="${top.absolute_file_path }" 
								onerror='this.src="resources/images/diary/userDefaultImage.png"' alt="">
								
								<a href="#0">${top.user_id }</a>
							</h3>								
							<div class="s-content__author-name2">
								<div style="text-align: center; text-align: center; font-size: 40px;">
								
								"${top.diary_title }"
								
								</div>
								<img src="resources/upload/diary/${top.diary_image}" onerror="this.src='resources/images/defaultImage.png'"
											style="height : 300px;">
								<h2 style="padding-left: 60%"> 조회수 : ${top.diary_hits }</h2>
								<h2>${top.diary_content }</h2>
								 <button style="margin-left:30%;  background: black; font-size: 20px; color: white;" type="submit">다이어리 보기</button>
            
							</div>
						</div>
						</form>
						</br></br>
					</c:forEach>
				</div>
			</div>
		</div>
	</form>
   <div class="right-dairy-maintab">
      <br/><br/><br/><br/>
         <c:if test="${not empty vo }">
         <h3 class="s-content__author-name5"></h3>
         <img style="margin-left:35px; width: 240px; height: auto;" src="${vo.absoluteFilePath }" onerror='this.src="resources/images/diary/userDefaultImage.png"' alt="">
         <br/><br/>
         <div style="font-size: 25px; text-align: center;">${vo.userId }님 안녕하세요</div> <br/>
         <div style="font-size: 25px;" id="myrigthprofile"><%-- 가입 날짜 : <fmt:formatDate value="${vo.joinDate }"  type="date" dateStyle="full" /><br/> --%>
            * 나이 : ${vo.userAge }</br>
            * 성별 : 
            <c:choose>
               <c:when test="${vo.userGender eq 1 }">남</c:when>
               <c:otherwise>여</c:otherwise>
            </c:choose><br/>
            * 이메일 : ${vo.userEmail }
         </div>   
         </br> </br>
         <div id="rigthmakediary">
         
            <button style="width: 45%; margin-left: 19%; font-size:20px; width: 60%;" type="button" id="btnRegisterDiary"
					onclick="location.href='writediary'">새글등록</button>
					</br>
            <button style="width: 45%; margin-left: 19%; font-size:20px;  width: 60%;" type="button" 
					onclick="location.href='getdairy'">내다이어리 가기</button>
          
         </div>
         </c:if>
         <div id="rigthotherdiary">
         </br>
            <h2 style="margin: inherit; line-height: inherit; text-align: center;">이런    다이어리는 </h2>
            <h1 style="margin: inherit; line-height: inherit; text-align: center; font-size: 50px;">어때?</h1><br/>
            <c:forEach items="${recommendairy}"  var="recommend" >
           <form action="getdairy" method="POST" >
						<input name="userId" type="hidden" value="${recommend.userId }">
          			  <input name="diaryId" type="hidden" value="${recommend.diaryId }">
            <h2 style="font-size: 30px; text-align:center; margin: inherit; line-height: inherit; margin-right: 70%;">
                 ${recommend.userId }</h2>
            <img style="margin-left : 29px; width: 293px;" alt="" src="resources/images/diary1.PNG">
           
			<div style="border-left : 1px solid black; border-right: 1px solid black; margin-left : 30px; ">
               <img src="resources/upload/diary/${recommend.diaryImage }" style="margin-left : 30px; margin: 10px; width: 265px; height: 200px;"
								onerror='this.src="resources/images/defaultImage.png"' alt="">
                  <h3 style="font-size: 30px; margin-left : 30px; text-align:center; margin: inherit; line-height: inherit; ">
                 ${recommend.diaryTitle }</h3><br/>
               </div>
              <img style="margin-left : 29px; width: 293px;" alt="" src="resources/images/mydiary2.PNG">
              <button style="margin-left:30%;  background: black; font-size: 20px; color: white;" type="submit">다이어리 보기</button>
               </br> 
               </form>
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