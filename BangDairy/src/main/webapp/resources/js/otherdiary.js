
$(document).ready(function(){

	// 좋아요 버튼을 클릭했을때
	$('#btnDiaryLike').click(function() {

		diaryId = $('#aaa').val();
		
			$.ajax({
				type : 'POST',	// 요청 메소드 타입
				url : "updatelike/" + diaryId,	// 클라이언트가 HTTP 요청을 보낼 서버의 주소
				dataType : "html",	// 서버가 리턴하는 데이터 타입
				
				error : function(e) {          // 통신 실패시
					alert('diaryAjax 통신실패' + e);
					
				},
				success : function(data) {    // Ajax 통신에 성공했을 때 호출될 이벤트 핸들러
					location.reload();
					$('#likehate').html(url);
				}
			});
		

});
	// 싫어요 버튼을 클릭했을때
	$('#btnDiaryHate').click(function() {
	
		diaryId = $('#aaa').val();
		
		$.ajax({
			type : 'POST',	// 요청 메소드 타입
			url : "updatehate/" + diaryId,	// 클라이언트가 HTTP 요청을 보낼 서버의 주소
			dataType : "html",	// 서버가 리턴하는 데이터 타입
			error : function(e) {          // 통신 실패시
				alert('diaryAjax 통신실패' + e);
			},
			success : function(data) {    // Ajax 통신에 성공했을 때 호출될 이벤트 핸들러
				location.reload();
				$('.likehate').html(url);
			}
		});
	});
});
