<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


<!DOCTYPE html>


<div id="content" style="text-align:center;">
						<section style="border:3px solid black; border-radius:2em; padding:10px; background:white;">
			<c:forEach items="${diaryDetailList}" var="diaryDetailList">
							<header id="diaryDetailTitle">
							<img src="resources/images/diary/diaryCircle.png" style="height:20px; width:300px;">
								<h2 style="font-size:30px;">${diaryDetailList.diary_title}</h2>
							</header>
							<br/>
							<c:if test="${not empty diaryDetailList.diary_image}">
							<img src="resources/upload/diary/${diaryDetailList.diary_image}"  style="width:200px; height:200px;">
							</c:if>
							<c:if test="${empty diaryDetailList.diary_image}">
							<img src="resources/images/defaultImage.png" style="width:200px; height:200px;">
							</c:if>
							<p style="font-size:25px;">[${diaryDetailList.mtitle}]</p>
							
								<p>${diaryDetailList.diary_content}
	</p>
	
							<ul>
							<li style="text-align:left;">${diaryDetailList.viewing_together}와 함께</li>
							<li style="text-align:left;">언제? ${diaryDetailList.viewing_date}</li>
							<li style="text-align:left;">어디서? ${diaryDetailList.viewing_location}</li>
							</ul>

							</c:forEach>
						</section>
					</div>
					
					
<script type="text/javascript">



</script>