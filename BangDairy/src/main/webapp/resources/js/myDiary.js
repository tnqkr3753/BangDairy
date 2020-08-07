$(document).ready(function(){

	alert("js 연결 확인");
	pNum = 1;
	$.ajax({
		type : 'POST',	// 요청 메소드 타입
		url : "showDiaryList/" + pNum,	// 클라이언트가 HTTP 요청을 보낼 서버의 주소
		dataType : "html",	// 서버가 리턴하는 데이터 타입
		error : function(e) {          // 통신 실패시
			alert('diaryAjax 통신실패' + e);
		},
		success : function(data) {    // Ajax 통신에 성공했을 때 호출될 이벤트 핸들러
			$('.myRightTap').html(data);	// searchTab의 아이디가 movieSearch인 div에 붙임
		}
	});
	
});