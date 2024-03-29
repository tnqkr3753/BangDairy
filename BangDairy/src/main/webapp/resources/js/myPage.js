$(document).ready(function(){
	$(document).on('click','#btn-goList',function(){
		loadQnaList()
	})
	/*
	 * My Profile 하단의 Go 버튼을 눌렀을때 동작
	 */
	$('#btnMyProfile').click(function() {
		$.ajax({
			type : 'POST',	// 요청 메소드 타입
			url : "myPage/info",	// 클라이언트가 HTTP 요청을 보낼 서버의 주소
			dataType : "html",	// 서버가 리턴하는 데이터 타입
			error : function() {          // 통신 실패시
				alert('myPageMember 통신실패');
			},
			success : function(data) {    // Ajax 통신에 성공했을 때 호출될 이벤트 핸들러
				$('.mypage-content').html(data);	// myPage.jsp의 diary-content 클래스에 붙임
			}
		});
		var location = document.querySelector(".mypage-content").offsetTop;	// mypage-content Top 위치 구함
		window.scrollTo({top:location, behavior:'smooth'});	// Scroll 내려줌
	});
	
	/*
	 * Q&A 하단의 Go 버튼을 눌렀을때 동작
	 */
	$('#btnQA').click(function() {
		loadQnaList();
		var location = document.querySelector(".mypage-content").offsetTop;	// mypage-content Top 위치 구함
		window.scrollTo({top:location, behavior:'smooth'});	// Scroll 내려줌
	});
	
	/*
	 * Wish List 하단의 Go 버튼을 눌렀을때 동작
	 ***************************************** 수정필요 *************************************
	 */
	$('#btnWish').click(function() {
		loadWishList()
		var location = document.querySelector(".mypage-content").offsetTop;	// mypage-content Top 위치 구함
		window.scrollTo({top:location, behavior:'smooth'});	// Scroll 내려줌
	});

});
	/*
	* 나가기 : myPage로 이동
	*/
	function exit(){
		window.location.href="/bangdairy/myPage";
	};
	$('input.btn-cancle').click(function(){
		window.location.href="/bangdairy/myPage";
	});
	function loadWishList(){
		$.ajax({
			type : 'POST',	// 요청 메소드 타입
			url : "myPage/wishList",	// 클라이언트가 HTTP 요청을 보낼 서버의 주소
			dataType : "html",	// 서버가 리턴하는 데이터 타입
			error : function() {          // 통신 실패시
				alert('myPageWish 통신실패');
			},
			success : function(data) {    // Ajax 통신에 성공했을 때 호출될 이벤트 핸들러
				$('.mypage-content').html(data);	// myPage.jsp의 diary-content 클래스에 붙임
			}
		});
	}
	function loadQnaList(){
		$.ajax({
			type : 'POST',	// 요청 메소드 타입
			url : "myPage/Qna",	// 클라이언트가 HTTP 요청을 보낼 서버의 주소
			dataType : "html",	// 서버가 리턴하는 데이터 타입
			error : function() {          // 통신 실패시
				alert('myPageQA 통신실패');
			},
			success : function(data) {    // Ajax 통신에 성공했을 때 호출될 이벤트 핸들러
				$('.mypage-content').html(data);	// myPage.jsp의 diary-content 클래스에 붙임
			}
		});
	}