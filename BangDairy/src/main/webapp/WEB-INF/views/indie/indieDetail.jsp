<%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@page
	import="com.sun.org.glassfish.external.statistics.annotations.Reset"%>
<%@page import="com.kosmo.bangdairy.vo.IndieVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html class="no-js" lang="">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Logic - Free Html Business Template</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--필요  -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css">

<link rel="stylesheet" href="resources/css/base.css">
<link rel="stylesheet" href="resources/css/vendor.css">
<link rel="stylesheet" href="resources/css/main.css">
<link rel="stylesheet" href="resources/css/independent.css">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<!--For Plugins external css-->
<link rel="stylesheet" href="resources/css/plugins.css" />

<!--Theme custom css -->
<link rel="stylesheet" href="resources/css/style.css">

<script src="resources/js/modernizr-2.8.3-respond-1.4.2.min.js"></script>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script type="text/javascript" src="resources/js/Sign_in.js"></script>

</head>

<body data-spy="scroll" data-target=".navbar" data-offset="200">
	<%@ include file="../../../header_menu.jsp"%>

	<section
		class="s-content s-content--narrow s-content--no-padding-bottom">

		<article class="row format-video">

			<div class="s-content__header col-full">

				<%-- 인디 영화 제목 --%>
				<h1 class="s-content__header-title" style="color: black;">[
					${result.indieTitle } ]</h1>
				
				<!-- 비로그인 상태 -->
				<c:choose>
					<c:when test="${userId ne null}">
						<span>
							<button id="good" class="good" value="${result.indieId}">
								<svg width="1em" height="1em" viewBox="0 0 16 16"
									class="bi bi-emoji-smile" fill="currentColor"
									xmlns="http://www.w3.org/2000/svg">
								<path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
								<path fill-rule="evenodd" d="M4.285 9.567a.5.5 0 0 1 .683.183A3.498 3.498 0 0 0 8 11.5a3.498 3.498 0 0 0 3.032-1.75.5.5 0 1 1 .866.5A4.498 4.498 0 0 1 8 12.5a4.498 4.498 0 0 1-3.898-2.25.5.5 0 0 1 .183-.683z" />
								<path d="M7 6.5C7 7.328 6.552 8 6 8s-1-.672-1-1.5S5.448 5 6 5s1 .672 1 1.5zm4 0c0 .828-.448 1.5-1 1.5s-1-.672-1-1.5S9.448 5 10 5s1 .672 1 1.5z" />
								</svg>
								${likeCount}
							</button>
						</span>

						<span>
							<button id="bad" class="bad" value="${result.indieId}">
								<svg width="1em" height="1em" viewBox="0 0 16 16"
									class="bi bi-emoji-frown" fill="currentColor"
									xmlns="http://www.w3.org/2000/svg">
								<path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
								<path fill-rule="evenodd" d="M4.285 12.433a.5.5 0 0 0 .683-.183A3.498 3.498 0 0 1 8 10.5c1.295 0 2.426.703 3.032 1.75a.5.5 0 0 0 .866-.5A4.498 4.498 0 0 0 8 9.5a4.5 4.5 0 0 0-3.898 2.25.5.5 0 0 0 .183.683z" />
								<path d="M7 6.5C7 7.328 6.552 8 6 8s-1-.672-1-1.5S5.448 5 6 5s1 .672 1 1.5zm4 0c0 .828-.448 1.5-1 1.5s-1-.672-1-1.5S9.448 5 10 5s1 .672 1 1.5z" />
								</svg>
								${hateCount}
							</button>
						</span>
					</c:when>
					<c:otherwise>
						<span> <a href='javascript:login_need();'>
								<button id="good" class="good" value="${result.indieId}">
									<svg width="1em" height="1em" viewBox="0 0 16 16"
										class="bi bi-emoji-smile" fill="currentColor"
										xmlns="http://www.w3.org/2000/svg">
								<path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
								<path fill-rule="evenodd" d="M4.285 9.567a.5.5 0 0 1 .683.183A3.498 3.498 0 0 0 8 11.5a3.498 3.498 0 0 0 3.032-1.75.5.5 0 1 1 .866.5A4.498 4.498 0 0 1 8 12.5a4.498 4.498 0 0 1-3.898-2.25.5.5 0 0 1 .183-.683z" />
								<path d="M7 6.5C7 7.328 6.552 8 6 8s-1-.672-1-1.5S5.448 5 6 5s1 .672 1 1.5zm4 0c0 .828-.448 1.5-1 1.5s-1-.672-1-1.5S9.448 5 10 5s1 .672 1 1.5z" />
								</svg>
									${likeCount}
								</button>
						</a></span>
						<span> <a href='javascript:login_need();'>
								<button id="bad" class="bad" value="${result.indieId}">
									<svg width="1em" height="1em" viewBox="0 0 16 16"
										class="bi bi-emoji-frown" fill="currentColor"
										xmlns="http://www.w3.org/2000/svg">
								<path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
								<path fill-rule="evenodd" d="M4.285 12.433a.5.5 0 0 0 .683-.183A3.498 3.498 0 0 1 8 10.5c1.295 0 2.426.703 3.032 1.75a.5.5 0 0 0 .866-.5A4.498 4.498 0 0 0 8 9.5a4.5 4.5 0 0 0-3.898 2.25.5.5 0 0 0 .183.683z" />
								<path d="M7 6.5C7 7.328 6.552 8 6 8s-1-.672-1-1.5S5.448 5 6 5s1 .672 1 1.5zm4 0c0 .828-.448 1.5-1 1.5s-1-.672-1-1.5S9.448 5 10 5s1 .672 1 1.5z" />
								</svg>
									${hateCount}
								</button>
						</a></span>
					</c:otherwise>
				</c:choose>

				<!-- 인디 디테일 탭 -->
				<div class="s-content__header-meta"
					style="margin-top: 20px; border: 2px solid gray; font-size: 15px;">
					<p>▶ 장르 : ${result.indieGenre }</p>
					<p>▶ 제조국가 : ${result.indieCountry }</p>
					<p>▶ 개봉일 :
						<fmt:formatDate value="${result.indieMakedate}"
							pattern="yyyy년 MM월 dd일" />
					</p>
				</div>
					
				<!-- 인디 포스터 -->
				<img src="resources/upload/indie/${result.indiePosterAddr}" alt=""
					style="width: 50%; border: 5px solid black; padding: 30px; margin: 50px; border-radius: 10%;" />
			</div>

			<div class="col-full s-content__main" style="margin-top: 0;">
				<%-- 인디 줄거리 --%>
				<p class="indiePlot">${result.indiePlot }</p>
				<div class="row bottom tags-wrap">
					<div class="col-full tags" style="text-align: center;">
					<!-- 키워드 태그 -->
						<div class="tagCloudIndie" style="margin-bottom: 40px;">
							<c:forEach items="${fn:split(result.indieKeyword,',')}" var="key">
								<a href="#">${key}</a>
							</c:forEach>
						</div>
					</div>
				</div>
				
				<!-- 영상 띄워주는 곳 -->
				<iframe width="100%" height="400" id="iframe-id" 
					src="${fn:replace(result.indieAddr, 'watch?v=', 'embed/')}"
					frameborder="0"
					allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreens></iframe>

				<%-- 인디 감독 --%>
				<h2 class="indieDetail">[감독]</h2>
				<div class="inner" style="border-bottom: 3px solid gray;">
					<div class="indieContent">
						<img src="resources/images/indie/director.png" style="width: 20%;" />
						${result.indieDirector }
					</div>
				</div>

				<%-- 인디 배우 --%>
				<h2 class="indieDetail">[배우]</h2>
				<div class="inner">
					<div class="indieContent">
						<img src="resources/images/indie/actor.png" style="width: 20%;" />
						${result.indieActor }
					</div>
				</div>
			</div>
			</div>
		</article>
	</section>

	<script src="resources/js/jquery.magnific-popup.js"></script>
	<script src="resources/js/jquery.mixitup.min.js"></script>

	<script type="text/javascript">
		/*   $(window).resize(function(){resizeYoutube();});
		 $(function(){resizeYoutube();});
		 function resizeYoutube(){ $("iframe").each(function(){ if( /^https?:\/\/www.youtube.com\/embed\g.test($(this).attr("src")) ){ $(this).css("width","100%"); $(this).css("height",Math.ceil( parseInt($(this).css("width")) * 480 / 854 ) + "px");} }); }
		 */
	</script>
	<!--     <script>

                                            function showmap() {
                                                var mapOptions = {
                                                    zoom: 8,
                                                    scrollwheel: false,
                                                    center: new google.maps.LatLng(-34.397, 150.644),
                                                    mapTypeId: google.maps.MapTypeId.ROADMAP
                                                };
                                                var map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);
                                            }
        </script> -->

	<!--체팅기능-->
	<!--Start of Tawk.to Script-->
	<script type="text/javascript">

		var myRequest = new Request("${fn:replace(result.indieAddr, 'watch?v=', 'embed/')}");

		fetch(myRequest).then(function(response) {
			$("#iframe-id").attr("src","indieError.jsp")
			 // alert("1122")
			
		 
		}).catch(function(error) {
			
			 if(response.status == '404'){
				 alert("1121")
					 }
		});
	</script>
	<!--End of Tawk.to Script-->

	<!--End of Tawk.to Script-->

	<script src="resources/js/plugins2.js"></script>
	<script src="resources/js/j_ajax.js"></script>
	<script src="resources/js/indieD.js"></script>
	<%@ include file="../../../footer.jsp"%>

</body>
</html>
