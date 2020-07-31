
jQuery(document).ready(function ($) {
	$('.qnaList').css({
		"cursor":"pointer"
	});
	//Q&A 작성을 누를 때
	$("#btn-addQna").click(function(){
		clickInsertQnaForm();
	});
	//Q&A 작성 완료를 누를 때
	$('#btn-insertQna').click(function(){
		insertQna();
	})
	//Q&A 하나를 누를 때
	$('.qnaList').click(function(){
		selectQna($(this).find("td.id-value").text());
	})
	function insertQna(){
		if($('input[name=qnaTitle]').val()==""){
			alert("제목에 빈 값을 입력하면 안됩니다.");
			return false;
		}
		var formData = new FormData($('#qnaForm')[0]);
		$.ajax({
			type: "POST",
			async : true,
			processData: false, // 필수
			contentType: false,	// 필수
			url: "myPage/Qna/insertForm/insert",
			data : formData,
			dataType: "html",
			success: function (response) {
				if(response){
					alert("Q&A를 입력했습니다.");
					loadQnaList();
				}else{
					alert("Q&A를 입력에 실패했습니다.");
				}
			},
			error: function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
	}
	/*
	 * 메소드 명		: clickInsertQnaForm
	 * 메소드 기능		: Q&A 작성을 누르면 페이지를 넘겨주는 ajax
	 * 변수				: None
	 * 작성자			: 박윤태
	 */
	function clickInsertQnaForm() {
		$.ajax({
			type: "POST",
			async : true,
			url: "myPage/Qna/insertForm",
			dataType: "html",
			success: function (response) {
				if(response){
					$('.mypage-content').html(response);
				}
			},
			error: function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		})
	}
	/*
	 * 메소드 명		: selectQna
	 * 메소드 기능		: Q&A 를 누르면 해당 내용을 보여줌
	 * 변수				: qnaId
	 * 작성자			: 박윤태
	 */
	function selectQna(qnaId){
		$.ajax({
			type: "POST",
			async : true,
			url: "myPage/Qna/select",
			dataType: "html",
			data:{"qnaId":qnaId},
			success: function (response) {
				if(response){
					$('.mypage-content').html(response);
				}
			},
			error: function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		})
	}
});
