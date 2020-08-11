<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%">
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<!-- ========== css ============= -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<!-- ========== script ============= -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="resources/js/admin.js"></script>
</head>
<body style="height: 100%">
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-expand-lg navbar-light bg-light navbar-dark bg-dark fixed-top">
				 
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="navbar-toggler-icon"></span>
				</button> <a class="navbar-brand" href="#">무비어리 관리자 페이지</a>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="navbar-nav">
<!-- 						<li class="nav-item active">
							 <a class="nav-link" href="#">정보 <span class="sr-only">(current)</span></a>
						</li>-->
						<li class="nav-item">
							 <a id="getMovieapp" class="nav-link" href="#" data-type="stats">영화 정보 가져오기</a>
						</li> 
						<li class="nav-item dropdown">
							 <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">관리</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
								 <a class="dropdown-item drop-type" href="#" data-type="movie">영화 정보</a> <a class="dropdown-item drop-type" href="#" data-type="user">유저 정보</a> <a class="dropdown-item drop-type" href="#" data-type="diary">다이어리 정보</a>
								<a class="dropdown-item drop-type" href="#" data-type="comment">코멘트 정보</a>
								<div class="dropdown-divider">
								</div><a class="dropdown-item ban-list" href="#" data-type="ban">벤 목록</a> <a class="dropdown-item drop-type" href="#" data-type="qna">Q&A 목록</a><a class="dropdown-item drop-type" href="#" data-type="indie">인디영화 신청 목록 </a>
							</div>
						</li>
					</ul>

					<ul class="navbar-nav ml-md-auto">
						<li class="nav-item dropdown">
							 <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">통계</a>
							<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
								 <a class="dropdown-item manage-a" href="#" data-a="movie">영화 통계</a> <a class="dropdown-item manage-a" href="#" data-a="review">리뷰 통계</a> <a class="dropdown-item manage-a" href="#" data-a="diary">다이어리 통계</a>
								 <a class="dropdown-item manage-a" href="#" data-a="comment">코멘트 통계</a>
								<div class="dropdown-divider">
								</div>
							</div>
						</li>
					</ul>
				</div>
			</nav>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12  content-admin">
				<!-- 내용 들어갈 곳 -->
		</div>
	</div>
</div>
</body>
</html>