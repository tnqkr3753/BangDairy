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


	<form method="post" action="dairySearch">
      <p><label>검색 : <input style="width: 25%;" type="text" name="searchWord"></label></p>
    </form>
	
				<h3 class="title">
					<a href="#" ng-click="blogHomeCtrl.goState('hotTopicChallenge')"
						class="link" bg-nclick="htp.htp">다이어리 >> </a>
					<a href="#" ng-click="blogHomeCtrl.goState('hotTopicChallenge')"
						class="link" bg-nclick="htp.htp">내가 최근에 쓴 다이어리와 같 DIARY</a>	
				</h3>
	
			<div id="ramdairy" class="heading">          
      
                   
                   <div style="width: "></div>
         					<table >
								<thead>	
									<tr >
										<c:forEach items="${recentdairy}" var="recent">       
	      		      					  <td><img style="max-width: auto; max-height: 200px;; " src="${recent.diaryImage }" ></td>
         								</c:forEach>	
									
									</tr>
									<tr>
										<c:forEach items="${recentdairy}" var="recent">       
	                                <td><a style="width: 30%; padding-left: 40% "> ${recent.diaryTitle }</a></td>
         								</c:forEach>
         							</tr>	
							</thead>
							</table>
         			

                <p class="s-content__tags">
					<span class="s-content__tag-list"> 
					<a href="#0">1</a> <a href="#0">2</a> <a href="#0">3</a></br>
					</span>
				</p>
				</article>
               </div>


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
				<a href="#0">${top.userId }</a>
				</h4>								
				<div class="s-content__author-name2">
				<h2 style="text-align: center;">${top.diaryTitle }</h2>
				<img src="${top.diaryImage }" style="">
				<h5 style="padding-left: 80%"> 조회수 : ${top.diaryHits }</h5>
				<h5>${top.diaryContent }</h5>
				
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
				<h3 style="margin: inherit; line-height: inherit; text-align: center;">이런    다이어리는 </h3>
				<h1 style="margin: inherit; line-height: inherit; text-align: center; border-bottom: ">어때?</h1></br>
				<c:forEach items="${recommendairy}"  var="recommend">
				<img alt="" src="${recommend.diaryImage }">
					<h3 style="font-size: 18px;  margin: inherit; line-height: inherit; ">${recommend.userId }<br/>
				  : ${recommend.diaryTitle }</h3></br>
					
				</c:forEach>	
				</div>
              </div>
			</div>
		</div>
	</article>
</section>
		<%@ include file="../../../footer.jsp"%>

    <!-- Java Script
    ================================================== -->
    <script src="resources/js/jquery-3.2.1.min.js"></script>
    <script src="resources/js/plugins.js"></script>
    <script src="resources/js/main.js"></script>
    <script src="/path/to/cdn/jquery.min.js"></script>

</body>
</html>