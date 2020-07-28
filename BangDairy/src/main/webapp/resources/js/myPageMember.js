jQuery(document).ready(function ($) {
    $('#btn-update').click(function(){
        $.ajax({
			type : 'POST',	// 요청 메소드 타입
			url : "myPage/info/updateForm",	// 클라이언트가 HTTP 요청을 보낼 서버의 주소
			dataType : "html",	// 서버가 리턴하는 데이터 타입
			error : function() {          // 통신 실패시
				alert('myPageMemberUpdateForm 통신실패');
			},
			success : function(data) {    // Ajax 통신에 성공했을 때 호출될 이벤트 핸들러
				$('.mypage-content').html(data);	// myPage.jsp의 diary-content 클래스에 붙임
			}
		});
		var location = document.querySelector(".mypage-content").offsetTop;	// mypage-content Top 위치 구함
		window.scrollTo({top:location, behavior:'smooth'});	// Scroll 내려줌
    });
    $('#btn-withdraw').click(function(){
        $.ajax({
			type : 'POST',	// 요청 메소드 타입
			url : "myPage/info/updateForm",	// 클라이언트가 HTTP 요청을 보낼 서버의 주소
			dataType : "html",	// 서버가 리턴하는 데이터 타입
			error : function() {          // 통신 실패시
				alert('myPageMemberUpdateForm 통신실패');
			},
			success : function(data) {    // Ajax 통신에 성공했을 때 호출될 이벤트 핸들러
				$('.mypage-content').html(data);	// myPage.jsp의 diary-content 클래스에 붙임
			}
		});
		var location = document.querySelector(".mypage-content").offsetTop;	// mypage-content Top 위치 구함
		window.scrollTo({top:location, behavior:'smooth'});	// Scroll 내려줌
    });
});