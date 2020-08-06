<%@page import="com.kosmo.bangdairy.vo.DairyVO"%>
<%@page import="com.kosmo.bangdairy.vo.MovieVO"%>
<%@page import="com.kosmo.bangdairy.vo.AccountFormVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

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
	<link rel="stylesheet" href="resources/css/maindairy.css">
    <!-- script
    ================================================== -->
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
		
		<form>
			<!-- 검색창 -->
			<input type="search" id="dairySearch" name="dairySearch">
			
			<button type="submit" onclick="location.href='dairySearch'" placeholder="검색" ></button>
		</form>
		
				<h3 class="title">
					<a href="#" ng-click="blogHomeCtrl.goState('hotTopicChallenge')"
						class="link" bg-nclick="htp.htp">다이어리 >> </a>
					<a href="#" ng-click="blogHomeCtrl.goState('hotTopicChallenge')"
						class="link" bg-nclick="htp.htp">내다이어리</a>	
				</h3>
			<div class="s-content__header col-full">
			
			<div id="ramdairy" class="heading">          
               <article id="darinsaram-blog-image" class="masonry__brick entry format-video" data-aos="fade-up">
                    <c:forEach items="${recentdairy}" var="recent">       
      				<div id="threepersent">
                        <div class="entry__thumb blog-image">
                        <img src="${recent.diaryImage }" >
                    </div>
                    <div class="entry__text">
                        <div class="entry__header">
                            <div class="entry__date">
                                <a href="single-video.html"> ${recent.diaryTitle }</a>
                            </div>
                     
                    </div></div>    
         			</div>
         			</c:forEach>
                </article>
                <article style="padding-top: 500px;" id="listbar_mydairy">
                <br/><br/><br/>
                <p class="s-content__tags">
					<span class="s-content__tag-list"> 
					<a href="#0">1</a> <a href="#0">2</a> <a href="#0">3</a></br>
					</span>
				</p>
				</article>
               </div>

			</article>
<br/><br/><br/>
			<div class = "mydairy">
			<div class="left-dairy-maintab">
			<div id="mydairyimg">
				<h1 class="s-content__header-title" style="text-align: center">이달의 다이어리 추천</h1>
				<li style="font-size: 20px;" class="date">December 16, 2017</li>
			<br/><br/>
	
			 <c:forEach items="${topdairy}" var="top">       
      			<h4 class="s-content__author-name">
				<img src="resources/images/avatars/user-03.jpg" alt="">
				</br>
				<a href="#0">${top.userId }</a><a>${top.viewingDate }</a>
				</h4>								
				<div class="s-content__author-name2">
				<img src="${top.diaryImage }" alt="">
				<h2>${top.diaryTitle }</h2>
				<p>${top.diaryContent }</p><p> 조회수 : ${top.diaryHits }</p>
				</div>
			</c:forEach>
			
		</div></div>

				<%
		AccountFormVO vo = new AccountFormVO();
        HttpSession sess = request.getSession();
        String id = (String) sess.getAttribute("userId");
        vo.setUserId(id);
        
		%>
		<%
							if (vo.getUserId() == null) {
						%>
        <%
							} else {
						%>	


			<div class="right-dairy-maintab">
			</br></br></br></br>
						<h3 class="s-content__author-name5"></h3>
						</br></br>
						<img src="images/avatars/user-03.jpg" alt="">
						</br></br>
						<%=vo.getUserId()%></br><a href="#0">myprofile go</a>
						</h4>
					
				
										
				<div id="myrigthprofile">
				<h4>name: <%=vo.getUserName()%></br>
				age: <%=vo.getUserAge()%></br>
				gender: <%=vo.getUserGender()%></br>
				e-mail: <%=vo.getUserEmail()%></h4>
				</div>
				<%
							}
						%>	
				<div id="rigthmakediary">
				<button type="submit" class="submit btn--primary btn--large full-width">새글작성</button>
				<button type="submit" class="submit btn--primary btn--large full-width" index="mydairy_btn">내다이어리</button>
				</div>
				
				<div id="rigthotherdiary">
				<h3>이런 다이어리는 어때?</h3></br>
				<c:forEach items="${recommendairy}" var="recommend">
					<p>${recommend.userId }</p></br>
					<p>${recommend.diaryTitle }</p></br>
					
				</c:forEach>	
				</div>
				

</div></div></div></article></section>
		<%@ include file="../../../footer.jsp"%>

    <!-- Java Script
    ================================================== -->
    <script src="resources/js/jquery-3.2.1.min.js"></script>
    <script src="resources/js/plugins.js"></script>
    <script src="resources/js/main.js"></script>
    <script src="/path/to/cdn/jquery.min.js"></script>

</body>
</html>