<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>


<div class="table-responsive">
	<table>
		<thead style="font-size:40px; font-family: 'Do Hyeon', sans-serif;">
			<tr>
				<th>포스터</th>
				<th>영화제목</th>
				<th>장르</th>
				<th>개봉일</th>
				<th>평점</th>
			</tr>
		</thead>
		<c:if test="${empty mList}">
			<!-- mList가 비어있을때 (즉, 검색결과가 없을때) -->
			<tbody>
				<td colspan="5">일치하는 검색 결과가 없습니다.</td>
			</tbody>
		</c:if>

		<c:if test="${!empty mList}">
			<!-- mList에 내용이 있을때 (즉, 검색결과가 있을때) -->
			<c:forEach items="${mList}" var="list">
				<div class="tab-search">
					<tbody class="movieList">
						<!-- 영화 리스트 1개 START -->
						<tr style="font-size:25px;">
							<td><input type="hidden" value="${list.movie_id}"
								class="movieId"> <img src="${list.poster_addr}"
								onerror="this.src='resources/images/defaultImage.png'"
								width="100px" height="100px"> <br /> <c:choose>
									<c:when test="${empty list.score}">
										<!-- 평점이 null일때 -->
									등록된 평점이 없습니다.
									</c:when>
									<c:otherwise>
										<div class="starRev"
											style="font-size: 20px; font-weight: bold;">
											<img src="resources/images/star.png"
												style="vertical-align: middle; height: 30px; width: 30px;">
											&nbsp;<span style="vertical-align: middle;">${list.score}</span>
										</div>
									</c:otherwise>
								</c:choose></td>
							<td>${list.movie_title}</td>
							<!-- 영화 제목 -->
							<td>${list.gtitle}</td>
							<!-- 장르 -->
							<td style="width:14%;">${list.opening_date}</td>
							<!-- 개봉일 -->

							<!-- 평점 START -->
							<td><c:if test="${empty userId}">
								로그인해야 평점을 입력할 수 있습니다!!
								</c:if> <c:if test="${!empty userId}">

									<c:if test="${list.count == 0}">
										<div class="starRev">
											<span class="starR">별1</span> <span class="starR">별2</span> <span
												class="starR">별3</span> <span class="starR">별4</span> <span
												class="starR">별5</span>
										</div>
									</c:if>
									<c:if test="${list.count == 1}">
										<img src="resources/images/complete.png" style="width:30px;"/>
										입력완료
										</c:if>
								</c:if></td>
						</tr>
						<!-- 평점 END -->
					</tbody>
				</div>
				<!-- 영화 리스트 1개 END -->
			</c:forEach>
		</c:if>
	</table>
</div>

<div class="row" id="btnPaging">
	<div class="col-full">
		<nav class="pgn">
			<!-- ********** 페이징 ********** -->
			<c:if test="${totalPage < 5}">
				<!-- 전체페이지 수가 5보다 작을때 -->
				<c:forEach var="i" begin="1" end="${totalPage}">
					<button class="btnPaging" value='${i}'>${i}</button>
				</c:forEach>
			</c:if>

			<c:if test="${totalPage >= 5}">
				<!-- 전체페이지 수가 5보다 클때 -->
				<c:if test="${pNum == 1}">
					<!-- 현재 페이지가 1페이지일때 뒤 4개의 페이지 보여줌 -->
					<c:forEach var="i" begin="${pNum}" end="${pNum+4}">
						<button class="btnPaging" value='${i}'>${i}</button>
					</c:forEach>
				</c:if>
				<c:if test="${pNum == 2}">
					<!-- 현재 페이지가 2페이지일때 1페이지, 뒤 3개의 페이지 보여줌 -->
					<c:forEach var="i" begin="${pNum-1}" end="${pNum+3}">
						<button class="btnPaging" value='${i}'>${i}</button>
					</c:forEach>
				</c:if>
				<c:if test="${pNum >= 3 and pNum <= totalPage-2}">
					<!-- 현재 페이지가 3페이지 이상일때 앞 2개, 뒤 2개의 페이지 보여줌 -->
					<c:forEach var="i" begin="${pNum-2}" end="${pNum+2}">
						<button class="btnPaging" value='${i}'>${i}</button>
					</c:forEach>
				</c:if>
				<c:if test="${pNum == totalPage-1}">
					<c:forEach var="i" begin="${pNum-3}" end="${pNum+1}">
						<!-- 현재 페이지가 마지막 페이지-1일때 -->
						<button class="btnPaging" value='${i}'>${i}</button>
					</c:forEach>
				</c:if>
				<c:if test="${pNum == totalPage}">
					<!-- 현재 페이지가 마지막 페이지일때 -->
					<c:forEach var="i" begin="${pNum-4}" end="${pNum}">
						<button class="btnPaging" value='${i}'>${i}</button>
					</c:forEach>
				</c:if>
			</c:if>
			<!-- ********** 페이징 ********** -->

			<c:if test="${totalPage > 5 and pNum < totalPage-2}">
				<!-- 전체 페이지의 개수 표시 -->
			... <button class="btnPaging" value='${totalPage}'>${totalPage}</button>
			</c:if>
		</nav>
	</div>
</div>

<script type="text/javascript">

	$(".btnPaging").each(function(){	// 버튼 색 변경
		if ($(this).val() == ${pNum}) {
			$(this).css("background-color", "black");	
			$(this).css("color", "white");
		}
	});
	
	$(".btnPaging").click(function() {

		genre = $('.active').text();
		
		// alert("페이지 버튼 클릭 확인");
		tabName = $('input:radio[name="searchTab"]:checked').val(); // 선택된 라디오 버튼의 value 값
		pNum = $(this).val(); // 현재 클릭한 페이지 num
		
		// alert(tabName);
		// alert(pNum);

		selectOrder = $("#orderBy").val();

		$.ajax({
			type : 'POST', // 요청 메소드 타입
			url : "searchBy/" + tabName + "/" + pNum + "/" + selectOrder + "/" + genre, // 클라이언트가 HTTP 요청을 보낼 서버의 주소
			dataType : "html", // 서버가 리턴하는 데이터 타입
			error : function(e) { // 통신 실패시
				alert('btnPaging 통신실패' + e);
			},
			success : function(data) { // Ajax 통신에 성공했을 때 호출될 이벤트 핸들러
				$('#movieSearch').html(data); // searchTab의 아이디가 movieSearch인 div에 붙임
			}
		});

		$('html').scrollTop(0); // 페이지 변경되면 다시 맨 위로
	});

	// 마우스 커서 모양
	$(".movieList td:not(:last-child)").hover(function() {
		$(this).css("cursor", "pointer");
	});

	// 영화 리스트 클릭했을때 상세정보 페이지로 넘어감
	$(".movieList td:not(:last-child)").click(function() {
		// alert("detail 페이지로 넘어가자");
		
		movieId = $(this).closest('tr').find(".movieId").val(); // movie_id 가져옴

		location.href = "detail?movieId=" + movieId;
	});

	// 평점 클릭했을때
	$('.starRev span').click(function() {
		// alert("평점 클릭");
		$(this).parent().children('span').removeClass('on');
		$(this).addClass('on').prevAll('span').addClass('on');
		
		var resultStar = confirm('평점을 입력하시겠습니까?');	// 평점 확인

		if (resultStar) { // 확인 버튼을 누르면
			// alert("확인");
			
			// 선택한 별 개수
			starLength = $('div.starRev span.on').length;

			
			// alert(starLength); // 1~5 숫자로 완전 잘 출력됨!!
			movieId = $(this).closest('tr').find(".movieId").val();
			
			$.ajax({
				type : 'POST', // 요청 메소드 타입
				url : "insertStar/" + starLength + "/" + movieId, // 클라이언트가 HTTP 요청을 보낼 서버의 주소
				dataType : "html", // 서버가 리턴하는 데이터 타입
				error : function(e) { // 통신 실패시
					alert('통신실패' + e);
				},
				success : function(data) { // Ajax 통신에 성공했을 때 호출될 이벤트 핸들러
					alert("평점이 입력되었습니다!!");
				}
			});
			
			location.reload(true); // 평점이 입력된 다음 페이지 리로드
		}
		
		return false;
	});
</script>