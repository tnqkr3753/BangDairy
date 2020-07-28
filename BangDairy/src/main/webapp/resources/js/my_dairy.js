$(document).ready(function(){
		$('#write_dr').click(function() {
			$('.myRightTap').children().remove();
		$.ajax({
			type : 'POST',	// 요청 메소드 타입
			url : "write_dairy.jsp",	// 클라이언트가 HTTP 요청을 보낼 서버의 주소
			dataType : "html",	// 서버가 리턴하는 데이터 타입	
			success : function(data){
			alert("여기")
		    $('.myRightTap').html(data);
			}
	    });
	});
});	
	