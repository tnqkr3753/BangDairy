$(document).ready(function(){

	$('#movieTitle').keyup(function() {	// 영화 제목 input 창에 키보드 입력 이벤트가 발생할때
		// alert($(this).val());
		movieTitle = $(this).val();	// 현재 내가 입력한 글자 얻어옴
		
		if(movieTitle != "") {	// 얻어온 글자가 존재하면
			$(".recommendTitle").show();
			
			$.ajax({
				type : 'POST', // 요청 메소드 타입
				url : "searchMovieTitle/" + encodeURI(movieTitle), // 특수문자, 한글 인코딩해서 movieTitle 보냄
				dataType : "html",
				error : function(request, status, error) {
					// alert("error code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error) // 에러 코드 자세히 보기
					alert("유효하지 않은 문자를 입력하셨습니다.")
				},
				success : function(data) {
					$(".recommendTitle").html(data);
				}
			});
		}
		
		if(movieTitle == "") {	// 만약 얻어온 글자가 없다면
			$(".recommendTitle").hide();	// select box 붙이는 클래스인 recommendTitle 안 보이게
		}
	});
});