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
    <link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">	
 <link type="text/css" rel="stylesheet" charset="UTF-8" href="https://translate.googleapis.com/translate_static/css/translateelement.css">
<link rel="stylesheet" href="resources/css/base.css">
<link rel="stylesheet" href="resources/css/vendor.css">
<link rel="stylesheet" href="resources/css/main.css">
<link rel="stylesheet" href="resources/css/myPage.css">

<!-- script
    ================================================== -->
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="resources/js/modernizr.js"></script>
<script src="resources/js/pace.min.js"></script>

<!-- favicons
    ================================================== -->
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<link rel="icon" href="favicon.ico" type="image/x-icon">

</head>

<body id="top">
	<%@ include file="header_menu.jsp"%>

	<!-- s-content
    ================================================== -->
	<section
		class="s-content s-content--narrow s-content--no-padding-bottom">
		<article class="row format-video">
			<div class="s-content__header col-full">
				<div class="row2">
				
					<!-- My profile 시작 -->
					<div class="col-lg-4">
						<img class="img-circle" src="resources/images/myPage/user.png"
							alt="Generic placeholder image" width="140" height="140"
							style="border: 3px solid black; padding: 0.5em;">
						<h2>My Profile</h2>
						<p>나의 정보를 볼 수 있으며<br/> 수정, 탈퇴가 가능합니다.</p>
						<p>
							<button class="btn btn-default" id="btnMyProfile"
								role="button">GO »</button>
						</p>
					</div>
					<!-- My profile 끝 -->
					
					<!-- Wish List 시작 -->
					<div class="col-lg-4">
						<img class="img-circle" src="resources/images/myPage/heart.png"
							alt="Generic placeholder image" width="140" height="140"
							style="border: 3px solid black; padding: 0.5em;">
						<h2>Wish List</h2>
						<p>내가 보고싶은 영화에 추가한<br/>영화들을 볼 수 있습니다.</p>
						<p>
							<button class="btn btn-default" id="btnWish" href="#" role="button">GO»</button>
						</p>
					</div>
					<!-- Wish List 끝 -->
					
					<!-- Q&A 시작 -->
					<div class="col-lg-4">
						<img class="img-circle" src="resources/images/myPage/qa.png"
							alt="Generic placeholder image" width="140" height="140"
							style="border: 3px solid black; padding: 0.5em;">
						<h2>Q&A</h2>
						<p>내가 남긴 Q&A를 보거나<br/>Q&A를 쓸 수 있습니다.</p>
						<p>
							<button class="btn btn-default" id="btnQA" href="#" role="button">GO	»</button>
						</p>
					</div>
					<!-- Q&A 끝 -->
				</div>
				
				<hr />
				<!-- Ajax로 추가될 부분 Start-->
				<div class="mypage-content">
				
				</div>
				<!-- Ajax로 추가될 부분 End-->

			</div>
		</article>
	</section>
	<div id="dialogPass" title="비밀번호 입력" style="display:none">
		<input type="password" name="userPassword">
	</div>
	<!-- s-content -->

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
    ================================================= -->
	<script src="resources/js/plugins.js"></script>
	<script src="resources/js/main.js"></script>
	<script src="resources/js/myPage.js"></script>

</body>

</html>