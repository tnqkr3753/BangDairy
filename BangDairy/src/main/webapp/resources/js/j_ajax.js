
var isRun = false;
$(".btnPaging").click(function() {
		
		pNum = $(this).val();
		if(isRun == true) { return; }

		 isRun = true;
alert("사사")
				$.ajax({
					type : 'GET', // 요청 메소드 타입
					url : "listIndie2/" + pNum, // 클라이언트가 HTTP 요청을 보낼 서버의 주소
					
					dataType : "html", // 서버가 리턴하는 데이터 타입
					error : function(e) { // 통신 실패시
						alert('btnPaging 통신실패' + e);
					},
					success : function(data) { // Ajax 통신에 성공했을 때 호출될 이벤트 핸들러
						 isRun  = false;
						
					

						$('#movie-list').html(data);

						
					}
				});

		$('html').scrollTop(0);


				
})


$("#good").click(function(){
	goodId=$(this).val();

	
	alert(goodId)	
	
	$.ajax({
		
		type : 'GET', // 요청 메소드 타입
		
		url : "goodId/"+goodId, // 클라이언트가 HTTP 요청을 보낼 서버의 주소
		
//		dataType : "json", // 서버가 리턴하는 데이터 타입
		
		error : function(e) { // 통신 실패시
			
			alert(' 1통신실패' + e);
		},
		success : function(data) { // Ajax 통신에 성공했을 때 호출될 이벤트 핸들러
//			$('#movie-list').html(data);
			if(data == 1){
				alert("통신성공")
			}else{
				alert("실패")
			}
		}
	});


	
});


$("#bad").click(function(){
	badId=$(this).val();
	
	
	alert(badId)	
	
	$.ajax({
		
		type : 'GET', // 요청 메소드 타입
		
		url : "badId/"+badId, // 클라이언트가 HTTP 요청을 보낼 서버의 주소
		
//		dataType : "json", // 서버가 리턴하는 데이터 타입
		
		error : function(e) { // 통신 실패시
			
			alert(' 1통신실패' + e);
		},
		success : function(data) { // Ajax 통신에 성공했을 때 호출될 이벤트 핸들러
//			$('#movie-list').html(data);
			if(data == 1){
				alert("통신성공")
			}else{
				alert("실패")
			}
		}
	});


	
	
});

function login_need(){
	alert("로그인이 필요합니다.")
}

    
