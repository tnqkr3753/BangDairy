<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<div id="diaryListAjax" class="table-responsive">
	<c:if test="${empty myDiaryList}">
	<h3 style="font-size:30px;"><hr/><br/><br/>작성한 다이어리가 없습니다.<br/>먼저 다이어리를 작성해주세요!<br/><br/><hr/></h3>
	</c:if>
	
	<c:if test="${!empty myDiaryList}">
	<table>
		<thead>
			<tr>
				<th>이미지</th>
				<th>다이어리<br/>제목</th>
				<th>영화 제목</th>
				<th>조회수</th>
			</tr>
		</thead>

		<div class="tab-search">
			<tbody class="diaryList">
				<!-- 다이어리 리스트에서 하나씩 뽑아옴 -->
				<c:forEach items="${myDiaryList}" var="myDiaryList">

					<tr>
						<input type="hidden" value="${myDiaryList.diary_id}">
						<!-- 다이어리 이미지 -->
						<td><c:if test="${not empty myDiaryList.diary_image}">
								<img src="resources/upload/diary/${myDiaryList.diary_image}"
									style="width: 100px; height: 100px;">
							</c:if>
							<c:if test="${empty myDiaryList.diary_image}">
								<img src="resources/images/defaultImage.png"
									style="width: 100px; height: 100px;">
							</c:if>
						</td>
						<!-- 다이어리 제목 -->
						<td>${myDiaryList.diary_title}</td>
						<!-- 영화 제목 -->
						<td>${myDiaryList.movieTitle}</td>
						<!-- 다이어리 조회수 -->
						<!-- **************************** 수정필요 **************************** -->
						<td>${myDiaryList.diary_hits}</td>
					</tr>
				</c:forEach>
			</tbody>
		</div>
	</table>
	</c:if>
</div>

<div class="row">
	<div class="col-full">
		<nav class="pgn">
			<!-- ********** 페이징 ********** -->
			<c:if test="${totalPage < 5}">
				<!-- 전체페이지 수가 5보다 작을때 -->
				<c:forEach var="i" begin="1" end="${totalPage}">
					<button class="btnDiaryList" value='${i}'>${i}</button>
				</c:forEach>
			</c:if>

			<c:if test="${totalPage >= 5}">
				<!-- 전체페이지 수가 5보다 클때 -->
				<c:if test="${pNum == 1}">
					<!-- 현재 페이지가 1페이지일때 뒤 4개의 페이지 보여줌 -->
					<c:forEach var="i" begin="${pNum}" end="${pNum+4}">
						<button class="btnDiaryList" value='${i}'>${i}</button>
					</c:forEach>
				</c:if>
				<c:if test="${pNum == 2}">
					<!-- 현재 페이지가 2페이지일때 1페이지, 뒤 3개의 페이지 보여줌 -->
					<c:forEach var="i" begin="${pNum-1}" end="${pNum+3}">
						<button class="btnDiaryList" value='${i}'>${i}</button>
					</c:forEach>
				</c:if>
				<c:if test="${pNum >= 3 and pNum <= totalPage-2}">
					<!-- 현재 페이지가 3페이지 이상일때 앞 2개, 뒤 2개의 페이지 보여줌 -->
					<c:forEach var="i" begin="${pNum-2}" end="${pNum+2}">
						<button class="btnDiaryList" value='${i}'>${i}</button>
					</c:forEach>
				</c:if>
				<c:if test="${pNum == totalPage-1}">
					<c:forEach var="i" begin="${pNum-3}" end="${pNum+1}">
						<!-- 현재 페이지가 마지막 페이지-1일때 -->
						<button class="btnDiaryList" value='${i}'>${i}</button>
					</c:forEach>
				</c:if>
				<c:if test="${pNum == totalPage}">
					<!-- 현재 페이지가 마지막 페이지일때 -->
					<c:forEach var="i" begin="${pNum-4}" end="${pNum}">
						<button class="btnDiaryList" value='${i}'>${i}</button>
					</c:forEach>
				</c:if>
			</c:if>
			<!-- ********** 페이징 ********** -->

			<c:if test="${totalPage > 5 and pNum < totalPage-2}">
				<!-- 전체 페이지의 개수 표시 -->
			... <button class="btnDiaryList" value='${totalPage}'>${totalPage}</button>
			</c:if>
		</nav>
	</div>
</div>

<script type="text/javascript">

// 다이어리 리스트 버튼 클릭했을때
	$(".btnDiaryList").click(function() {
		pNum = $(this).val();
		// alert(pNum);
		var userId = $('.myleftTap').data('id');
		var userData=null;
		if (userId!=null && userId!=""){
			userData = {"userId":userId};
		}
		$.ajax({
			type : 'POST',	// 요청 메소드 타입
			url : "showDiaryList/" + pNum,	// 클라이언트가 HTTP 요청을 보낼 서버의 주소
			dataType : "html",	// 서버가 리턴하는 데이터 타입
			data:userData,
			error : function(e) {          // 통신 실패시
				alert('diaryAjax 통신실패' + e);
			},
			success : function(data) {    // Ajax 통신에 성공했을 때 호출될 이벤트 핸들러
				$('.myRightTap').html(data);
			}
		});
	
		// 버튼 눌렀을때 리스트의 상단으로 스크롤 이동
		var offset = $(".myRightTap").offset();
		$('html, body').animate({scrollTop:offset.top}, 400);
	});

// 커서 : 포인트
$(".diaryList tr").hover(function() {
	$(this).css("cursor", "pointer");
});

// 다이어리 리스트 클릭하면 Ajax로 상세페이지 붙이기
$(".diaryList tr").click(function(){
	var diaryId = $(this).find('input[type="hidden"]').val();
	getDiaryOne(diaryId);
});
	function getDiaryOne(diaryId) {
	
	// alert("tr 클릭");
	// alert("선택한 행의 다이어리번호 : " + $(this).find('input[type="hidden"]').val());
	
	// 지금 선택한 다이어리의 인덱스 번호

		$.ajax({
			type : 'POST',	// 요청 메소드 타입
			url : "showDetailList/" + diaryId,	// 클라이언트가 HTTP 요청을 보낼 서버의 주소
			dataType : "html",	// 서버가 리턴하는 데이터 타입
			error : function(e) {          // 통신 실패시
				alert('showDetailList 통신실패' + e);
			},
			success : function(data) {    // Ajax 통신에 성공했을 때 호출될 이벤트 핸들러
				$('.diaryDetail').html(data);
			}
		});
	
		// tr 눌렀을때 다이어리 내용 볼수있게 스크롤 이동
		var offset = $(".myDiaryHeader").offset();
		$('html, body').animate({scrollTop:offset.top}, 400);
	}
	$(function(){
		var did = $(".myRightTap").data('did');
		//갈 영화페이지가 있을 때
		if (did!=null&&did!=""){
			getDiaryOne(did);
		}
		$('.myRightTap').data("did","");
		var did = $(".myRightTap").data('did');
		});

</script>