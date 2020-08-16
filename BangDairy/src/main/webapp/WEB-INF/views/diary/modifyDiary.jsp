<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.kosmo.bangdairy.vo.AccountFormVO"%>
<%@page import="com.kosmo.bangdairy.vo.DairyVO"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css"
	rel="stylesheet">
<link
	href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
	rel="stylesheet">
<link type="text/css" rel="stylesheet" charset="UTF-8"
	href="https://translate.googleapis.com/translate_static/css/translateelement.css">
<link rel="stylesheet" href="resources/css/base.css">
<link rel="stylesheet" href="resources/css/vendor.css">
<link rel="stylesheet" href="resources/css/main.css">

<link rel="stylesheet" href="resources/css/dairycss/writeDiary.css">

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
	<%@ include file="../../../header_menu.jsp"%>
	<!-- s-content
    ================================================== -->
	<section
		class="s-content s-content--narrow s-content--no-padding-bottom">
		<article class="row format-video">
			<div class="s-content__header col-full">
				<div class="row2">

					<!-- 오늘 날짜 얻어오기 -->
					<%
					Date nowTime = new Date();
					SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일");
					%>

					<!-- 로그인 정보 얻어오기 -->
					<%
					AccountFormVO vo = new AccountFormVO();
					HttpSession sess = request.getSession();
					String id = (String) sess.getAttribute("userId");
					vo.setUserId(id);
					%>

					<div class="insertDiaryTop">
						<img src="resources/images/diary/diary.png"
							style="height: 40px; width: 40px;">
						<%=vo.getUserId()%>님의 다이어리 수정 <img
							src="resources/images/diary/diary.png"
							style="height: 40px; width: 40px;">
					</div>
					
					<div class="insertDiaryDate">
						오늘은
						<%=sf.format(nowTime)%>입니다.
					</div>

					<!-- 다이어리 수정 폼 START -->
					<form action="modifyDiary" method="post" enctype="multipart/form-data">
						<div class="sm-12 pt-3">
							<table class="table">
								<tbody>
									<c:forEach items="${result}" var="result">
										<input type="hidden" value="${result.diary_id}" name="diaryId">
										<tr style="line-height: 32px;">
										<!-- 다이어리 제목 -->
											<td>다이어리 제목</td>
											<td><input class="form-control" id="diaryTitle"
												name="diaryTitle" placeholder="다이어리 제목을 입력해주세요."
												style="width: 100%; height: 50px; text-align: center"
												autocomplete="off" value="${result.diary_title}" /></td>
										</tr>
										<!-- 영화 제목 -->
										<tr>
											<td>영화 제목</td>
											<td><input class="form-control" name="movieId"
												id="movieTitle" placeholder="영화 제목을 검색해주세요."
												style="width: 93%; height: 50px; text-align: center"
												autocomplete="off"
												value="${result.mtitle} [${result.movie_id}]" />&nbsp;&nbsp;
												<i class="fa fa-search" id="searchMovieTitle"></i>

												<div class="recommendTitle">
													<!-- 여기가 AJAX로 붙일 부분 -->
												</div></td>
										</tr>
										<!-- 영화 내용 -->
										<tr>
											<td>영화 내용</td>
											<td><textarea class="form-control" name="diaryContent"
												placeholder="영화 내용을 입력해주세요."
												style="wrap: physical; width: 100%; height: 200px; text-align: left"
												autocomplete="off"">${result.diary_content}</textarea></td>
										</tr>
										<!-- 누구와? -->
										<tr>
											<td>누구와 함께<br/>보셨나요?</td>
											<td><input id="viewingTogether" name="viewingTogether"
												style="height: 50px; width: 32.2%; font-size: 20px; display: inline"
												autocomplete="off" value="${result.viewing_together}"></td>
										</tr>
										<!-- 언제? -->
										<tr>
											<td>언제 보셨나요?</td>
											<td><input type="date" id="viewingDate"
												name="viewingDate" placeholder=" yyyy-mm-dd"
												style="height: 50px; width: 40%; display: inline; font-size: 20px;"
												autocomplete="off"
												value="<fmt:formatDate value="${result.viewing_date}" pattern="yyyy-MM-dd" />"></td>
										</tr>
										<!-- 어디서? -->
										<tr>
											<td>어디서 보셨나요?</td>
											<td><input id="viewingLocation" name="viewingLocation"
												style="height: 50px; width: 32.2%; display: inline; font-size: 20px;"
												autocomplete="off" value="${result.viewing_location}"></td>
										</tr>
										<!-- 이미지 -->
										<tr>
											<td>이미지 첨부</td>
											<td><input id="diaryImg" type="file" id="file" name="file" accept="image/gif,image/jpg,image/png" 
										 onchange="chk_file_type(this)"/>
										<div id='image_container'><img src="resources/upload/diary/${result.diary_image }"
			 onerror='this.src="resources/images/defaultImage.png"'/></div></td>
										</tr>
									</c:forEach>
								</tbody>

							</table>
							<input type="submit" value="수정" id="submitModify">
							<!-- 수정 버튼 -->
					</form>
					<!-- 다이어리 수정 폼 END -->
				</div>
			</div>
		</article>
	</section>
	<!-- s-content -->

	<%@ include file="../../../footer.jsp"%>

	<!-- Java Script
    ================================================= -->
	<script src="resources/js/plugins.js"></script>
	<script src="resources/js/main.js"></script>
	<script src="resources/js/writeDiary.js"></script>

</body>

</html>

<script type="text/javascript">
	$(document).ready(function() {
		movieTitle1 = $('#movieTitle').val();	// 내가 기존에 입력했던 영화제목
		$('#diaryImg').change(function () { // 이미지 변경할때마다
			readURL(this);
		});
		$('#submitModify').click(function() {	// 등록버튼 클릭했을때
			
			// 사용자가 현재 입력한 값들 얻어옴
			diaryTitle = $('#diaryTitle').val();
			movieTitle2 = $('#movieTitle').val();	// 사용자가 입력한 영화제목
			diaryContent = $('#diaryContent').val();
			viewingTogether = $('#viewingTogether').val();
			viewingDate = $('#viewingDate').val();
			viewingLocation = $('#viewingLocation').val();

			// 입력하지 않은 필드가 있다면
			if (diaryTitle == "" || movieTitle == "" || diaryContent == "" || viewingTogether == "" || viewingDate == "" || viewingLocation == "") {
				alert("모든 항목을 입력해주세요.");
				return false;

			}
			
			// 날짜 체크 정규식
			var datatimeRegexp = /^(19|20)\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$/;
			
			// 날짜가 정규식에 맞지 않으면
			if (!datatimeRegexp.test($('#viewingDate').val())) {
				alert("날짜는 yyyy-mm-dd 형식으로 입력해주세요.");
				return false;
			}
			
			movieTitle3 = $('#recommendSelect option:selected').text();	// 셀렉트 박스에 선택된 영화 제목
			
			if(movieTitle1 != movieTitle2) {	// 만약 사용자가 영화 제목을 바꾸었다면
				if (movieTitle2 != movieTitle3) {	// 셀렉트박스와 바꾼 영화제목이 일치하는지 확인
					alert("검색 후 입력해주세요.")
					return false;}
				}

			var result = confirm('수정하시겠습니까?');

			if (!result) {
				return false;
			}
		});
	});
	function chk_file_type(obj) {
		var file_kind = obj.value.lastIndexOf('.');
		var file_name = obj.value.substring(file_kind+1,obj.length);
		var file_type = file_name.toLowerCase();
		var check_file_type= new Array;
		var check_file_type=['jpg','gif','png','jpeg','bmp'];
		if(check_file_type.indexOf(file_type)==-1){
			alert('이미지 파일만 선택할 수 있습니다.');
			var parent_Obj=obj.parentNode
			var node=parent_Obj.replaceChild(obj.cloneNode(true),obj);
			obj.value = '';
			obj.focus();
			return false;
		}
	}
	function readURL(input) {
		var reader = new FileReader(); 
		reader.onload = function(event) { 
			var img = document.createElement("img"); 
			img.setAttribute("src", event.target.result); 
			$("div#image_container").html(img); 
		}; 
		reader.readAsDataURL(input.files[0]); 
	}
</script>