$(document).ready(function(){
	// alert("js 연결 확인");
	myDiaryShow();

	$(document).on('click','.btn-LH',function(){
		var did =  $(this).data("id");
		var dtype = $(this).data("type");
		var inputData = {"type":dtype,"diaryId":did};
		$.ajax({
			type : 'POST',	// 요청 메소드 타입
			url : "getdairy/likehate",	// 클라이언트가 HTTP 요청을 보낼 서버의 주소
			dataType : "text",	// 서버가 리턴하는 데이터 타입
			data:inputData,
			error : function(e) {          // 통신 실패시
				alert('좋아요 싫어요 통신실패' + e);
			},
			success : function(data) {    // Ajax 통신에 성공했을 때 호출될 이벤트 핸들러
				if(data==1){
					location.reload();
				}else if(data==2){
					alert("수정되었습니다.");
					location.reload();
				}else{
					alert("입력에 실패했습니다.");
				}
			}
		});
	});
	function myDiaryShow(){
		pNum = 1;
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
	}
});