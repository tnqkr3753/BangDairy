$(function(){
	
	var searchWord = $('#search-word-indie').val();
	
	$(".btnPaging").click(function() {
			var pNum = $(this).val();
			getPage(pNum,searchWord);
	});



	$("#good").click(function(){
		goodId=$(this).val();
		
		$.ajax({
			type : 'GET', // 요청 메소드 타입
			url : "goodId/"+goodId, // 클라이언트가 HTTP 요청을 보낼 서버의 주소
			//dataType : "html", 
			 async: false,
			error : function(request,status,error) { // 통신 실패시

			
			},
			success : function(data) { // Ajax 통신에 성공했을 때 호출될 이벤트 핸들러
		
					alert("통신성공")

			}
			
		});
		location.reload();
	
	});
	$("#bad").click(function(){
		badId=$(this).val();
		
		$.ajax({
			type : 'GET', // 요청 메소드 타입
			url : "badId/"+badId, // 클라이언트가 HTTP 요청을 보낼 서버의 주소
			//dataType : "html", // 서버가 리턴하는 데이터 타입
			 async: false,
			error : function(e) { // 통신 실패시
			
			},
			success : function(data) { // Ajax 통신에 성공했을 때 호출될 이벤트 핸들러
			
					alert("통신성공")
				
			}
			
		});
		location.reload();
		
	});
	/* 박윤태 수정 */
	$(document).on("keydown",'.form-control',function(key){
		if(key.keyCode == 13){
			searchWord = $(this).val();
			if(searchWord == "") {
				searchWord = "all";
			}
			getPage(1,searchWord);
		}
	
	});
});


	function login_need(){
		alert("로그인이 필요합니다.")
	}
var isRun = false;
function getPage(pNum,searchWord){
	if(searchWord =="" || searchWord ==null){
			searchWord="all"
	}
		if(isRun == true) { return; }
		isRun = true;
				$.ajax({
					type : 'GET', // 요청 메소드 타입
					url : "listIndie2/" + pNum+"/"+searchWord, // 클라이언트가 HTTP 요청을 보낼 서버의 주소
					dataType : "html", // 서버가 리턴하는 데이터 타입
					async: false,
					error : function(e) { // 통신 실패시
						alert('btnPaging 통신실패' + e);
					},
					success : function(data) { // Ajax 통신에 성공했을 때 호출될 이벤트 핸들러
						isRun  = false;
						$('#movie-list').html(data);
					
					}
				});
					$('html').scrollTop(0);
	}










    
