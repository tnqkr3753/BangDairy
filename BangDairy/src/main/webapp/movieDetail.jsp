<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- CSS
    ================================================== -->
<link rel="stylesheet" href="resources/css/base.css">
<link rel="stylesheet" href="resources/css/vendor.css">
<link rel="stylesheet" href="resources/css/main.css">
<link rel="stylesheet" href="resources/css/movieDetail.css">

<!-- script
    ================================================== -->
<script src="js/modernizr.js"></script>
<script src="js/pace.min.js"></script>

<!-- favicons
    ================================================== -->
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<link rel="icon" href="favicon.ico" type="image/x-icon">

<!-- jquery lib import -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

</head>

<body id="top">
	<%@ include file="header_menu.jsp"%>
	<%@ include file="account_form.jsp"%>
	<%@ include file="Sign_In.jsp"%>


	<!-- s-content
    ================================================== -->
	<section
		class="s-content s-content--narrow s-content--no-padding-bottom">

		<article class="row format-video">

			<div class="s-content__header col-full">
				<!-- 영화 이름 -->
				<h1 class="s-content__header-title">MOVIE NAME HERE</h1>

				<!-- 영화 정보 -->
				<ul class="s-content__header-meta">
					<li>OPENING DATE HERE
					<li>GENRE HERE
					<li>TIME HERE
					<li>COUNTS(PEOPLE)</li>
					<br />
					<li>AGE HERE
					<li>COMPANY HERE
					<li>COUNTRY HERE</li>
				</ul>

				<!-- 평점 -->
				<div class="starRev">
					<span class="starR on">별1</span> <span class="starR">별2</span> <span
						class="starR">별3</span> <span class="starR">별4</span> <span
						class="starR">별5</span>
				</div>
				<br />

				<!-- 영화포스터 rslides START -->
				<ul class="rslides">
					<li><img src="resources/images/movieDetail/sam1.jpg" alt=""></li>
					<li><img src="resources/images/movieDetail/sam2.jpg" alt=""></li>
					<li><img src="resources/images/movieDetail/sam3.png" alt=""></li>
				</ul>
				<!-- rslides END -->

			</div>
			<!-- 영화포스터 end s-content__media -->

			<div class="col-full s-content__main">

				<!-- 짧은 소개 -->
				<p class="lead">INTRO ~~~~~~~~ INTRO ~~~~~~~~ INTRO ~~~~~~~~
					INTRO ~~~~~~~~ INTRO ~~~~~~~~</p>

				<!-- 줄거리 -->
				<p>AND CONTENTS HERE ~~~~~!!!!! AND CONTENTS HERE ~~~~~!!!!! AND
					CONTENTS HERE ~~~~~!!!!! AND CONTENTS HERE ~~~~~!!!!! AND CONTENTS
					HERE ~~~~~!!!!! AND CONTENTS HERE ~~~~~!!!!! AND CONTENTS HERE
					~~~~~!!!!! AND CONTENTS HERE ~~~~~!!!!! AND CONTENTS HERE
					~~~~~!!!!! AND CONTENTS HERE ~~~~~!!!!! AND CONTENTS HERE
					~~~~~!!!!! AND CONTENTS HERE ~~~~~!!!!! AND CONTENTS HERE
					~~~~~!!!!! AND CONTENTS HERE ~~~~~!!!!! AND CONTENTS HERE
					~~~~~!!!!! AND CONTENTS HERE ~~~~~!!!!! AND CONTENTS HERE
					~~~~~!!!!!</p>

				<!-- 감독 정보 START -->
				<h2>DIRECTOR</h2>

				<section id="two" class="wrapper alt spotlight style2">
					<div class="inner">
						<a href="#" class="image"><img
							src="resources/images/movieDetail/directorSam.jpg" alt=""></a>
						<div class="content">
							<!-- 감독 이름 -->
							<h2 class="major">YEON SANG HO</h2>
							<p>Lorem ipsum dolor sit amet, etiam lorem adipiscing elit.
								Cras turpis ante, nullam sit amet turpis non, sollicitudin
								posuere urna. Mauris id tellus arcu. Nunc vehicula id nulla
								dignissim dapibus. Nullam ultrices, neque et faucibus viverra,
								ex nulla cursus.</p>
						</div>
					</div>
				</section>

				<blockquote>
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
					ut enim aliqua laborum mollit quis nostrud sed sed.</p>

				<!-- 감독 정보 END -->

				<!-- 배우 정보 START -->
				<h2>ACTOR</h2>

				<section id="two" class="wrapper style1 special">
					<div class="inner">
						<div class="flex flex-4">
							<div class="box person">
								<div class="image round">
									<img src="resources/images/movieDetail/actorSam.jpg"
										alt="Person 1">
								</div>
								<!-- 배우 이름 -->
								<h3>YOOAIN</h3>
							</div>
							<div class="box person">
								<div class="image round">
									<img src="resources/images/movieDetail/actorSam.jpg"
										alt="Person 2">
								</div>
								<h3>YOOAIN</h3>
							</div>
							<div class="box person">
								<div class="image round">
									<img src="resources/images/movieDetail/actorSam.jpg"
										alt="Person 3">
								</div>
								<h3>YOOAIN</h3>
							</div>
							<div class="box person">
								<div class="image round">
									<img src="resources/images/movieDetail/actorSam.jpg"
										alt="Person 4">
								</div>
								<h3>YOOAIN</h3>
							</div>
							<div class="box person">
								<div class="image round">
									<img src="resources/images/movieDetail/actorSam.jpg"
										alt="Person 4">
								</div>
								<h3>YOOAIN</h3>
							</div>
							<div class="box person">
								<div class="image round">
									<img src="resources/images/movieDetail/actorSam.jpg"
										alt="Person 4">
								</div>
								<h3>YOOAIN</h3>
							</div>
						</div>
					</div>
				</section>
				<!-- 배우 정보 END -->

				<!-- OST 정보 START -->

				<h2>OST</h2>
				<div class="col-twelve">
					<div class="table-responsive">
						<table>
							<thead>
								<tr>
									<th>SONG TITLE</th>
									<th>ARTIST</th>
									<th>GENRE</th>
									<th>DATE</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Maria</td>
									<td>Hwasa</td>
									<td>Dance</td>
									<td>2020.06.29</td>
								</tr>
								<tr>
									<td>Monster</td>
									<td>Red Velvet</td>
									<td>Dance</td>
									<td>2020.07.06</td>
								</tr>
							</tbody>
						</table>

					</div>

				</div>
				<!-- OST 정보 END -->

				<!-- 그래프  START -->
				<h2>GRAPH</h2>
				여기다 그래프를
				넣어~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				<!-- 그래프 END -->

			</div>
			<!-- end s-content__main -->

		</article>

		<!-- Comments START -->
		<div class="comments-wrap">

			<div id="comments" class="row">
				<div class="col-full">

					<!-- respond
                    ================================================== -->
					<div class="respond">

						<h3 class="h2">Add Comment</h3>
						<!-- 평점 -->
						<div class="starRev">
							<span class="starR on">별1</span> <span class="starR">별2</span> <span
								class="starR">별3</span> <span class="starR">별4</span> <span
								class="starR">별5</span>
						</div>

						<form name="contactForm" id="contactForm" method="post" action="">
							<fieldset>
								<div class="form-field">
									<input name="cWebsite" type="text" id="cWebsite"
										class="full-width" placeholder="Your Comment" value="">
								</div>
								<!-- 영수증 사진 첨부 및 댓글 등록 버튼 -->
								<div class="comment">
									<input type="file" name="file" id="pct_img" value="file">
									<button type="submit" class="submit btn--primary btn--large">Register</button>

								</div>
							</fieldset>
						</form>
						<!-- end form -->
					</div>
					<!-- end respond -->

					<!-- 다른 사용자의 댓글 보여주기 -->
					<h3 class="h2">1 Comments</h3>

					<!-- commentlist -->
					<ol class="commentlist">
						<li class="depth-1 comment">
							<div class="comment__avatar">
								<img width="50" height="50" class="avatar"
									src="images/avatars/user-01.jpg" alt="">
							</div>
							<div class="comment__content">
								<div class="comment__info">
									<cite>Itachi Uchiha</cite>

									<div class="comment__meta">
										<time class="comment__time">Dec 16, 2017 @ 23:05</time>
									</div>
								</div>
								<div class="comment__text">
									<p>Adhuc quaerendum est ne, vis ut harum tantas noluisse,
										id suas iisque mei. Nec te inani ponderum vulputate, facilisi
										expetenda has et. Iudico dictas scriptorem an vim, ei alia
										mentitum est, ne has voluptua praesent.</p>
								</div>
							</div>
						</li>
						<!-- end comment level 1 -->
					</ol>
					<!-- end commentlist -->
				</div>
				<!-- end col-full -->
			</div>
			<!-- end row comments -->
		</div>
		<!-- end comments-wrap -->
		<!-- Comments END -->
	</section>
	<!-- s-content -->

	<!-- s-extra
    ================================================== -->
	<section class="s-extra">


		<div class="row bottom tags-wrap">
			<div class="col-full tags">
				<h3>Keywords</h3>

				<div class="tagcloud">
					<a href="#0">Salad</a> <a href="#0">Recipe</a> <a href="#0">Places</a>
					<a href="#0">Tips</a> <a href="#0">Friends</a> <a href="#0">Travel</a>
					<a href="#0">Exercise</a> <a href="#0">Reading</a> <a href="#0">Running</a>
					<a href="#0">Self-Help</a> <a href="#0">Vacation</a>
				</div>
				<!-- end tagcloud -->
			</div>
			<!-- end tags -->
		</div>
		<!-- end tags-wrap -->

	</section>
	<!-- end s-extra -->

	<%@ include file="footer.jsp"%>

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
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/main.js"></script>
	<script src="resources/js/movieDetail.js"></script>
	<script src="resources/js/responsiveslides.min.js"></script>

</body>

</html>