<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>

<!-- basic page needs================================================== -->
<meta charset="utf-8">
<title>Video Post Format - Philosophy</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- mobile specific metas
    ================================================== -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- CSS
    ================================================== -->
        <link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">	
 <link type="text/css" rel="stylesheet" charset="UTF-8" href="https://translate.googleapis.com/translate_static/css/translateelement.css">
<link rel="stylesheet" href="resources/css/base.css">
<link rel="stylesheet" href="resources/css/vendor.css">
<link rel="stylesheet" href="resources/css/main.css">
<link rel="stylesheet" href="resources/css/movieDetail.css">

<!-- script
    ================================================== -->
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://d3js.org/d3.v3.min.js"></script>
    <script src="https://rawgit.com/jasondavies/d3-cloud/master/build/d3.layout.cloud.js" type="text/JavaScript"></script>
<!-- <script src="resources/js/modernizr.js"></script> -->
<!-- <script src="resources/js/pace.min.js"></script> -->

<!-- favicons
    ================================================== -->
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<link rel="icon" href="favicon.ico" type="image/x-icon">

</head>

<body id="top">
				    
	<%@ include file="../../../header_menu.jsp"%>
	<!-- s-content
	================================================== -->
	<!--============= 20200724박윤태============== -->
	
	<c:choose>
	<c:when test="${not empty vo}">
	<%--=============vo가 null이 아니라면 ============= --%>
	<section
		class="s-content s-content--narrow s-content--no-padding-bottom">

		<article class="row format-video">
			<%-- 영화 컨텐츠 시작 --%>
			<div class="s-content__header col-full">
				<%-- 영화 이름 --%>
				<h1 class="s-content__header-title">${vo.movieTitle }</h1>
				
				<%-- 평점 --%>
				<div class="starRevM">
					<span class="starR on">별1</span> <span class="starR">별2</span> <span
						class="starR">별3</span> <span class="starR">별4</span> <span
						class="starR">별5</span> <!-- 해야함 -->
				</div>

				<%-- 영화 정보 --%>
				<ul class="s-content__header-meta" style="border:2px solid gray; font-size:15px;">
					<li>▶ 개봉일 : ${vo.openingDateStr }</li>
					<li>▶ 장르 : <c:forEach items="${vo.movieGenre}" var="genre">
					${genre.genreTitle} &nbsp;
					</c:forEach></li>
					<li>▶ 상영시간 : ${vo.showtimes} 분</li>
					<br />
					<li>▶ 관람등급 : ${vo.viewingClass}</li>
					<li>▶ 제작사 : ${vo.company}</li>
					<li>▶ 제조국가 : ${vo.country}</li>
				</ul>
				
				<br/><button id="wish-add" class="btn btn-default">
				<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-heart-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  				<path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
				</svg>
				찜 추가</button>
				<c:if test="${not empty vo.previewAddrKmdb }"><button id="btn-preview" class="btn btn-default" data-src="${vo.previewAddrKmdb }">예고편 보기</button><br/>
				<div id="myModal" class="modal">
 
				      <!-- Modal content -->
				      <div class="modal-content">
				        <span class="close">&times;</span>                                                               
				        <iframe src="${ vo.previewAddrKmdb }"></iframe>
				      </div>
				 
				</div>
				</c:if>
				
				<br />
			
				<%-- 영화 포스터 rslides Start --%>
				<ul class="rslides">
					<c:if test="${not empty sList }">
						<c:forEach items="${sList }" var="list">
							<li><img src="${list.stillAddr}" onerror='this.src="resources/images/defaultImage.png"' alt=""></li>
						</c:forEach>
					</c:if>
				</ul>
				<%-- rslides End --%>

			</div>

			<div class="col-full s-content__main">

				<%-- 영화 줄거리 --%>
				<p style="border-bottom:2px solid gray; border-top:2px solid gray; font-size:19px;">&nbsp;${vo.plot }</p>

				<%-- 영화 감독 TODO --%>
				<h2>[감독]</h2> 
				
				<!-- <section id="two" class="wrapper alt spotlight style2"> -->
						<div class="inner">
						<%--
							<a href="#" class="image"><img
								src="resources/images/movieDetail/directorSam.jpg" alt=""></a> --%>
							<div class="content">
								<c:forEach items="${vo.movieDirector }" var="director">
								<h2 class="major" style="text-align:center;">
								<img src="resources/images/director.png" style="width:100px; height:100px;"/>
								&nbsp;&nbsp;${director.directorName }</h2>
								<%-- <p>Lorem ipsum dolor sit amet, etiam lorem adipiscing elit.
									Cras turpis ante, nullam sit amet turpis non, sollicitudin
									posuere urna. Mauris id tellus arcu. Nunc vehicula id nulla
									dignissim dapibus. Nullam ultrices, neque et faucibus viverra,
									ex nulla cursus.</p> --%>
								</c:forEach>
							</div>
						</div>
					
				<!-- </section> -->

				<%-- <blockquote>
					<p>This is a simple example of a styled blockquote. A
						blockquote tag typically specifies a section that is quoted from
						another source of some sort, or highlighting text in your post.</p>
				</blockquote>

				<p>Odio dignissimos ducimus qui blanditiis praesentium
					voluptatum deleniti atque corrupti dolores et quas molestias
					excepturi sint occaecati cupiditate non provident, similique sunt
					in culpa. Aenean eu leo quam. Pellentesque ornare sem lacinia quam
					venenatis vestibulum. Nulla vitae elit libero, a pharetra augue
					laboris in sit minim cupidatat ut dolor voluptate enim veniam
					consequat occaecat fugiat in adipisicing in amet Ut nulla nisi non
					ut enim aliqua laborum mollit quis nostrud sed sed.</p>--%>

				<%-- 영화 감독 끝 --%>

				<%-- 영화 배우 시작 --%>
				<h2 style="border-top:2px solid gray;"><br/>[배우]</h2>
				<div class="col-twelve">
							<div class="table-responsive" style="font-size:20px;">
								<table>
									<thead>
										<tr>
											<th>배우 이름</th>
											<th>배역</th>
										</tr>
									</thead>
									<tbody>

										<c:set var="count" value="0" /> <!-- count = 0 -->
										<c:forEach items="${vo.starring }" var="hash">
											<c:if test="${count < 10 }">
												<tr>
													<td>${hash.key.actorName}</td> <!-- 배우명 -->
													<td>${hash.value}</td>	<!-- 배역 -->
												</tr>
											</c:if>
											<c:if test="${count >= 10 }">
												<tr class="actorMore"> <!-- 더보기를 누르면 보여줄 클래스 -->
													<td>${hash.key.actorName}</td>
													<td>${hash.value}</td>
												</tr>
											</c:if>
											<c:set var="count" value="${count+1}" /> <!-- foreach문이 한번 실행될때마다 count=count+1 -->
										</c:forEach>
									</tbody>
								</table>
							</div>

							<c:if test="${fn:length(vo.starring) > 10}">	<!-- 배우가 10명 이상이면 배우 전체보기와 숨기기 버튼 생성 -->
							<div class="row" style="border-bottom:2px solid gray; padding:50px; text-align:center;">
								<input type="button" id="btnActorShow" class="btn btn-default btn-more btn-block" value="배우 전체보기">
								<input type="button" id="btnActorHide" class="btn btn-default btn-more btn-block" value="숨기기">
							</div><br/>
						</c:if>

				</div>
				<%-- <section id="two" class="wrapper style1 special">
					<div class="inner">
						<div class="flex flex-4">
							<c:forEach items="${vo.starring }" var="hash">
							<div class="box person">--%>
								<%--<div class="image round">
									<img src="resources/images/movieDetail/actorSam.jpg"
										alt="Person 1">
								</div> --%>
								<%-- <h3>${hash.key.actorName}</h3><h4>(${hash.value})</h4>
								
							</div>
							</c:forEach>
						</div>
					</div>
				</section>--%>
				<%-- 영화 배우정보 끝 --%>

				<%-- 영화 그래프 시작 --%>
				<h2>[타 사이트 댓글 반응]</h2>
				<div id="wordcloud" align="center" >
		        </div>
		        <br/>
		        <div class="legend"  align="center" style="width:100%; font-size:18px;">
		          	빈도수가 높은 단어는 크지만 흐립니다. 빈도수가 낮은 단어는 작지만 진합니다.
		        </div>
				<%-- 영화 그래프 끝 --%>
			</div>
			<%-- 영화 컨텐츠 끝 --%>

		</article>

		<%-- 영화 커멘트 시작 --%>
		<div class="comments-wrap">

			<div id="comments" class="row">
				<div class="col-full">

					<%-- 코멘트 리스폰드 시작 --%>

						<h3>[코멘트]</h3>
						<div class="respond" style="border:2px solid gray; margin:30px; padding:30px;">
						
						<%-- 커멘트 별점 --%>
						<div class="starRev">
							<span class="starR on">별1</span> <span class="starR">별2</span> <span
								class="starR">별3</span> <span class="starR">별4</span> <span
								class="starR">별5</span>
						</div>

						<form name="commentForm" id="contactForm" method="post" action="/comment/insert">
							<fieldset>
								<input type="hidden" name="commentScore" value="" id="commentScore">
								<input type="hidden" name="movieId" value="${vo.movieId }" id="movieId">
								<div class="form-field">
									<input name="comment" type="text" id="cWebsite"
										class="full-width" placeholder="이 영화에 대한 코멘트를 입력해주세요!" value="">
								</div>
								<%-- 코멘트 영수증 첨부 --%>
								<%-- TODO --%>
								<div class="comment">
									<input type="file" name="file" id="pct_img" value="file">
									<button type="button" class="submit btn--primary btn--large" id="btn-insertComment" style="float:right;">댓글 등록하기</button>

								</div>
							</fieldset>
						</form>
						<%-- 폼 끝 --%>
					</div>
					<%-- 코멘트 리스폰드 끝 --%>

					<%-- 다른 코멘트 --%>
					<h3 id="comment-count">1 Comments</h3>

					<%-- 코멘트 리스트 --%>
					<ol class="commentlist">
						
					</ol>
					<button type="button" class="submit btn--primary" id="btn-moreComment" style="float:right;">더보기</button>
					<%-- 코멘트 끝 --%>
				</div>
				<%-- 코멘트 총 끝 --%>
			</div>
			<%-- 코멘트 줄 끝 --%>
		</div>
		<%-- 코멘트 롤 끝 --%>
		<%-- 코멘트 끝 --%>
	</section>
	</c:when>
	<%-- when 끝 --%>
	<%-- 컨텐츠 끝 --%>
	</c:choose>
	<!-- s-extra
    ================================================== -->
	<section class="s-extra">


		<div class="row bottom tags-wrap">
			<div class="col-full tags">
				<h3>Keywords</h3>

				<div class="tagcloud">
				<c:forEach items="${fn:split(vo.keyword,',')}" var="key"><a href="#0">${key}</a></c:forEach>
				</div>
				<!-- end tagcloud -->
			</div>
			<!-- end tags -->
		</div>
		<!-- end tags-wrap -->

	</section>
	<!-- end s-extra -->

	<%@ include file="../../../footer.jsp"%>

	<!-- preloader
    ================================================== -->
	<div id="preloader">
		<div id="loader">
			<div class="line-scale">
				<div></div>
				<div></div>
				<div></div>
				<div></div>
				<div></div>
			</div>
		</div>
	</div>


	<!-- Java Script
    ================================================== -->
	<script src="resources/js/movieDetail.js"></script>
	<script src="resources/js/responsiveslides.min.js"></script>

</body>

</html>

<script type="text/javascript">
	$(document).ready(function() {
		$('.actorMore').hide(); // 11번째 배우부터는 숨겨놓기!
		
		$('#btnActorShow').click(function() {	// 배우 전체보기 버튼을 누르면
			$('.actorMore').show();
		});

		$('#btnActorHide').click(function() {	// 배우 숨기기 버튼을 누르면
			$('.actorMore').hide();
		});
	});
</script>