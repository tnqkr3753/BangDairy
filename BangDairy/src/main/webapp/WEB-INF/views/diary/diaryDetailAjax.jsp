<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<div id="diaryDetail" style="text-align: center;">
	<section style="border: 3px solid black; border-radius: 2em; padding: 10px; background: white; font-size:9px;">
		
		<!-- 다이어리 상세 정보 -->
		<c:forEach items="${diaryDetailList}" var="diaryDetailList">
			<input type="hidden" value="${diaryDetailList.diary_id}">
			<!-- 다이어리 제목 -->
			<header id="diaryDetailTitle">
				<!-- 다이어리 이미지 -->
				<img src="resources/images/diary/diaryCircle.png" style="height: 20px; width: 300px;">
				<!-- 다이어리 제목 -->
				<h2 style="font-size: 30px;">${diaryDetailList.diary_title}</h2>
			</header>
			<br />
			
			<!-- 조회수, 좋아요, 싫어요 -->
			<div style="text-align:right; font-size:20px;">
			
			<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-emoji-smile" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  			<path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
  			<path fill-rule="evenodd" d="M4.285 9.567a.5.5 0 0 1 .683.183A3.498 3.498 0 0 0 8 11.5a3.498 3.498 0 0 0 3.032-1.75.5.5 0 1 1 .866.5A4.498 4.498 0 0 1 8 12.5a4.498 4.498 0 0 1-3.898-2.25.5.5 0 0 1 .183-.683z"/>
  			<path d="M7 6.5C7 7.328 6.552 8 6 8s-1-.672-1-1.5S5.448 5 6 5s1 .672 1 1.5zm4 0c0 .828-.448 1.5-1 1.5s-1-.672-1-1.5S9.448 5 10 5s1 .672 1 1.5z"/>
			</svg><fmt:parseNumber value="${diaryDetailList.diary_like}" integerOnly="true"  var="numberType2" />
			${numberType2 } 
			<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-emoji-frown" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  			<path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
  			<path fill-rule="evenodd" d="M4.285 12.433a.5.5 0 0 0 .683-.183A3.498 3.498 0 0 1 8 10.5c1.295 0 2.426.703 3.032 1.75a.5.5 0 0 0 .866-.5A4.498 4.498 0 0 0 8 9.5a4.5 4.5 0 0 0-3.898 2.25.5.5 0 0 0 .183.683z"/>
  			<path d="M7 6.5C7 7.328 6.552 8 6 8s-1-.672-1-1.5S5.448 5 6 5s1 .672 1 1.5zm4 0c0 .828-.448 1.5-1 1.5s-1-.672-1-1.5S9.448 5 10 5s1 .672 1 1.5z"/>
			</svg><fmt:parseNumber value="${diaryDetailList.diary_hate}" integerOnly="true" var="numberType3" />
			${numberType3 } 
			<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-eye-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
 			<path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0z"/>
  			<path fill-rule="evenodd" d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8zm8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z"/>
			</svg>
			<fmt:parseNumber value="${diaryDetailList.diary_hits}" integerOnly="true"  var="numberType1" />${numberType1 }
			</div>
			
			<!-- 다이어리 이미지가 있다면 -->
			<c:if test="${not empty diaryDetailList.diary_image}">
				<img src="resources/upload/diary/${diaryDetailList.diary_image}"
					style="width: 200px; height: 200px;">
			</c:if>
			<!-- 다이어리 이미지가 없다면 -->
			
			<c:if test="${empty diaryDetailList.diary_image}">
				<img src="resources/images/defaultImage.png"
					style="width: 200px; height: 200px;">
			</c:if>
			
			<!-- 영화 제목 -->
			<span><br/>[${diaryDetailList.mtitle}]</span>

			<!-- 다이어리 내용 -->
			<pre><br/>${diaryDetailList.diary_content}</pre>
			
			<!-- 누구와? 언제? 어디서? -->
			<ul>
				<li style="text-align: left;">${diaryDetailList.viewing_together}와(과) 함께</li>
				<li style="text-align: left;">언제? ${fn:substring(diaryDetailList.viewing_date, 0, 10)}</li>
				<li style="text-align: left;">어디서? ${diaryDetailList.viewing_location}</li>
			</ul>
		
		<c:if test="${diaryDetailList.user_id eq sessionScope.userId }">
		<input type="button" id="btnDiaryModify" value="수정하기">	<!-- 수정 버튼 -->
		<input type="button" id="btnDiaryDelete" value="삭제하기"> <!-- 삭제 버튼 -->
		</c:if>
		<c:if test="${diaryDetailList.user_id ne sessionScope.userId }">
		<input class="btn-LH" type="button" id="btnDiary" value="좋아요" data-type="like" data-id="${diaryDetailList.diary_id }">	<!-- 수정 버튼 -->
		<input class="btn-LH" type="button" id="btnDiary" value="싫어요" data-type="hate" data-id="${diaryDetailList.diary_id }"> <!-- 삭제 버튼 -->
		</c:if>
		</c:forEach>
	</section>
</div>


<script type="text/javascript">

// 삭제 버튼을 클릭했을때
$('#btnDiaryDelete').click(function() {
	// alert("삭제버튼 클릭");

	// alert("디테일 다이어리의 인덱스 번호 : " + $("#diaryDetail").find('input[type="hidden"]').val());
	
	var result = confirm('삭제하시겠습니까?');

	if (result) {
		// 현재 다이어리의 인덱스
		diaryId = $("#diaryDetail").find('input[type="hidden"]').val()
		location.href = "diaryDelete?diaryId=" + diaryId;
	}
});

// 수정 버튼을 클릭했을때
$('#btnDiaryModify').click(function() {
	// alert("수정버튼 클릭");
	
	// 현재 다이어리의 인덱스
	diaryId = $("#diaryDetail").find('input[type="hidden"]').val()
	location.href = "diaryModify?diaryId=" + diaryId;
});

</script>