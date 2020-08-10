<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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
		</c:forEach>
		<input type="button" id="btnDiaryModify" value="수정하기">	<!-- 수정 버튼 -->
		<input type="button" id="btnDiaryDelete" value="삭제하기"> <!-- 삭제 버튼 -->
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