<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디, 비밀번호 찾기</title>
<!-- ========== css ============= -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<!-- ========== script ============= -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid find-form">
	<div class="row">
		<div class="col-md-12">
			<div class="tabbable" id="tabs-7691">
				<ul class="nav nav-tabs">
					<li class="nav-item">
						<a class="nav-link active show" href="#tab1" data-toggle="tab" data-type="id">아이디 찾기</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#tab2" data-toggle="tab" data-type="pass">비밀번호 찾기</a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="tab1">
						<form action="" method="POST">
								<div class="form-group"> 
									<label for="id-id">이메일</label> 
									<input type="text" name="userEmail" class="form-control" id="id-email"> 
								</div>
						</form>
					</div>
					<div class="tab-pane" id="tab2">
						<form action="" method="POST">
								<div class="form-group"> 
									<label for="pass-id">아이디</label> 
									<input type="text"  name="userId" class="form-control" id="pass-id"> 
								</div>
								<div class="form-group"> 
									<label for="pass-email">이메일</label> 
									<input type="email"  name="userEmail" class="form-control" id="pass-email"> 
								</div>
						</form>
					</div>
				</div>
			</div> 
			<button type="button" class="btn btn-primary find-btn">
				찾기
			</button>
			<button type="button" class="btn btn-default">
				취소
			</button>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(function(){
			$('.find-btn').click(function(){
					var selector = $('.find-form .nav-link.active');
					var findType = selector.data('type');
					var form = $('.find-form .tab-content .tab-pane.active').find('form');
					form.attr('action','/bangdairy/user/finder/'+findType);
					form.submit();
				});
			
		});
</script>
</body>
</html>