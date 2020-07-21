<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
<!--- 아이콘가지고오는 링크 fa fa-twier 등등
    ================================================== -->
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!--- basic page needs
    ================================================== -->
<meta charset="utf-8">
<title>Philosophy</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- mobile specific metas
    ================================================== -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- resources/css
    ================================================== -->
<link rel="stylesheet" href="resources/css/base.css">
<link rel="stylesheet" href="resources/css/vendor.css">
<link rel="stylesheet" href="resources/css/main.css">

<!-- script
    ================================================== -->
<script src="resources/js/modernizr.js"></script>
<script src="resources/js/pace.min.js"></script>

<!-- favicons
    ================================================== -->
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<link rel="icon" href="favicon.ico" type="image/x-icon">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>

<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.15/jquery.bxslider.min.js"></script>
<script type="text/javascript" src="resources/js/main2.js"></script>
<script type="text/javascript" src="resources/js/account_form.js"></script>
<script type="text/javascript" src="resources/js/Sign_in.js"></script>

<!-- ====회원가입 폼==== -->

<!-- ========================================================= -->
</head>



<body id="top">
	<div id="main_all">
		<%@ include file="header_menu.jsp"%>
		<%@ include file="account_form.jsp"%>
		<%@ include file="Sign_In.jsp"%>
		<div class="pageheader-content row">
			<div class="col-full">

				<div class="featured">

					<div class="featured__column featured__column--big">
						<div class="entry"
							style="background-image: url('resources/images/thumbs/featured/featured-guitarman.jpg');">

							<div class="entry__content">
								<span class="entry__category"><a href="#0">Music</a></span>

								<h1>
									<a href="#0" title="">What Your Music Preference Says About
										You and Your Personality.</a>
								</h1>

								<div class="entry__info">
									<a href="#0" class="entry__profile-pic"> <img
										class="avatar" src="resources/images/avatars/user-03.jpg"
										alt="">
									</a>

									<ul class="entry__meta">
										<li><a href="#0">John Doe</a></li>
										<li>December 29, 2017</li>
									</ul>
								</div>
							</div>
							<!-- end entry__content -->

						</div>
						<!-- end entry -->
					</div>
					<!-- end featured__big -->

					<div class="featured__column featured__column--small">

						<div class="entry"
							style="background-image: url('resources/images/thumbs/featured/featured-watch.jpg');">

							<div class="entry__content">
								<span class="entry__category"><a href="#0">Management</a></span>

								<h1>
									<a href="#0" title="">The Pomodoro Technique Really Works.</a>
								</h1>

								<div class="entry__info">
									<a href="#0" class="entry__profile-pic"> <img
										class="avatar" src="resources/images/avatars/user-03.jpg"
										alt="">
									</a>

									<ul class="entry__meta">
										<li><a href="#0">John Doe</a></li>
										<li>December 27, 2017</li>
									</ul>
								</div>
							</div>
							<!-- end entry__content -->

						</div>
						<!-- end entry -->

						<div class="entry"
							style="background-image: url('resources/images/thumbs/featured/featured-beetle.jpg');">

							<div class="entry__content">
								<span class="entry__category"><a href="#0">LifeStyle</a></span>

								<h1>
									<a href="#0" title="">Throwback To The Good Old Days.</a>
								</h1>

								<div class="entry__info">
									<a href="#0" class="entry__profile-pic"> <img
										class="avatar" src="resources/images/avatars/user-03.jpg"
										alt="">
									</a>

									<ul class="entry__meta">
										<li><a href="#0">John Doe</a></li>
										<li>December 21, 2017</li>
									</ul>
								</div>
							</div>
							<!-- end entry__content -->

						</div>
						<!-- end entry -->

					</div>
					<!-- end featured__small -->
				</div>
				<!-- end featured -->

			</div>
			<!-- end col-full -->
		</div>
		<!-- end pageheader-content row -->

		<!-- </section> end s-pageheader -->


		<!-- s-content
    ================================================== -->
		<div>

			<div class="row masonry-wrap">

				<span class=title>AI추천</span>
				<div class="bxslider">
					<%
						for (int a = 0; a < 5; a++) {
					%>

					<div class="masonry">

						<div class="grid-sizer">

							<article class="masonry__brick entry format-standard"
								data-aos="fade-up">

								<div class="entry__thumb">

									<a href="﻿https://youtu.be/gspxp2lAR7A?t=211"
										class="entry__thumb-link"> <img
										src="resources/images/thumbs/masonry/lamp-400.jpg"
										class="entry__thumb-link1"
										srcset="resources/images/아이유.jpg 1x, resources/images/thumbs/masonry/lamp-800.jpg 2x"
										alt="">

									</a>
								</div>

								<div class="board">
									<ul class="list">
										<li>
											<div class="entry__text">
												<div class="entry__header">

													<div class="entry__date">
														<a href="single-standard.html">December 15, 2017</a>
													</div>
													<h1 class="entry__title">
														<a href="movieDetail.jsp">Just a Standard Format
															Post.</a>
													</h1>

												</div>
												<div class="entry__excerpt">
													<p>Lorem ipsum Sed eiusmod esse aliqua sed incididunt
														aliqua incididunt mollit id et sit proident dolor nulla
														sed commodo est ad minim elit reprehenderit nisi officia
														aute incididunt velit sint in aliqua...</p>
												</div>
												<div class="entry__meta">
													<span class="entry__meta-links"> <a href="#0"><i
															class="fa fa-play-circle-o" aria-hidden="true"
															title="예고편시청"></i></a> <a href="#0"><i
															class="fa fa-heart" aria-hidden="true" title="좋아요"></i></a>
													</span>
												</div>
											</div>
										</li>
									</ul>
								</div>
							</article>
						</div>
					</div>
					<%
						}
					%>
				</div>
			</div>


			<div class="row masonry-wrap">

				<span class=title>AI추천</span>
				<div class="bxslider">
					<%
						for (int a = 0; a < 5; a++) {
					%>
					<div class="masonry">



						<article class="masonry__brick entry format-standard"
							data-aos="fade-up">

							<div class="entry__thumb">

								<a href="single-standard.html" class="entry__thumb-link"> <img
									src="resources/images/아이유.jpg" class="entry__thumb-link1"
									srcset="resources/images/아이유 .jpg 2x, resources/images/thumbs/masonry/lamp-800.jpg 2x"
									alt="">

								</a>
							</div>


							<div class="entry__text">
								<div class="entry__header">

									<div class="entry__date">
										<a href="single-standard.html"> <%="1번넣기"%></a>
									</div>
									<h1 class="entry__title">
										<a href="single-standard.html"> <%="2번넣기"%></a>
									</h1>

								</div>
								<div class="entry__excerpt">
									<p>
										<%="3번"%>
									</p>
								</div>
								<div class="entry__meta">
									<span class="entry__meta-links"> <a href="#0"><i
											class="fa fa-play-circle-o" aria-hidden="true" title="예고편시청"></i></a>
										<a href="#0"><i class="fa fa-heart" aria-hidden="true"
											title="좋아요"></i></a>
									</span>
								</div>
							</div>
						</article>

					</div>
					<%
						}
					%>
				</div>
			</div>


			<div class="row masonry-wrap">

				<span class=title>조회순</span>
				<div class="bxslider">
					<%
						for (int a = 0; a < 5; a++) {
					%>
					<div class="masonry">

						<div class="grid-sizer">

							<article class="masonry__brick entry format-standard"
								data-aos="fade-up">

								<div class="entry__thumb">

									<a href="single-standard.html" class="entry__thumb-link">
										<img src="resources/images/아이유.jpg" class="entry__thumb-link1"
										srcset="resources/images/아이유.jpg 1x, resources/images/thumbs/masonry/lamp-800.jpg 2x"
										alt="">

									</a>
								</div>


								<div class="entry__text">
									<div class="entry__header">

										<div class="entry__date">
											<a href="single-standard.html">이지은</a>
										</div>
										<h1 class="entry__title">
											<a href="single-standard.html">가수,연기자</a>
										</h1>

									</div>
									<div class="entry__excerpt">
										<p>Lorem ipsum Sed eiusmod esse aliqua sed incididunt
											aliqua incididunt mollit id et sit proident dolor nulla sed
											commodo est ad minim elit reprehenderit nisi officia aute
											incididunt velit sint in aliqua...</p>
									</div>
									<div class="entry__meta">
										<span class="entry__meta-links"> <a href="#0"><i
												class="fa fa-play-circle-o" aria-hidden="true" title="예고편시청"></i></a>
											<a href="#0"><i class="fa fa-heart" aria-hidden="true"
												title="좋아요"></i></a>
										</span>
									</div>
								</div>
							</article>
						</div>
					</div>
					<%
						}
					%>
				</div>
			</div>




			<div class="home__slider">
				<div class="bxslider1">
					<%
						for (int d = 1; d <= 8; d++) {
					%>
					<a href="https://www.youtube.com/watch?v=N7vJxDDFmPY"><div>
							<img src="resources/images/<%=d%>.jpg" alt="그림1">
						</div></a>

					<%
						}
					%>
				</div>
			</div>

		</div>
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

		<script src="resources/js/plugins.js"></script>
		<script src="resources/js/main.js"></script>
	</div>
</body>

</html>