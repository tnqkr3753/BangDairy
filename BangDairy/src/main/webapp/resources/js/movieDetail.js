$(document).ready(function(){
	var movieId = $('#movieId').val();
	var pageNum = 1;
	var totalpage = 1;
	var commentPerPage = 10;
	alert(movieId)
	commentLoad(pageNum,movieId);
	$(".rslides").responsiveSlides({
		pager:true,				 // 페이징
		auto:true,				 // 자동으로 넘어가기
		speed:1,				 // 속도
		prevText: "Previous",    // String: Text for the "previous" button
		nextText: "Next"         // String: Text for the "next" button
	});
	
	// 평점 클릭했을때
	$('.starRev span').click(function(){
		$(this).parent().children('span').removeClass('on');
		$(this).addClass('on').prevAll('span').addClass('on');
		return false;
	});
	//커맨트 Regist 클릭할 때
	$("#btn-insertComment").click(function(){
		insertComment();
	})
	//커맨트 더보기를 누를 때
	$('#btn-moreComment').click(function(){
		if(pageNum>=1&&pageNum<=totalpage){
			pageNum+=1;
			commentLoad(pageNum,movieId);
		}else{
			alert("마지막 페이지입니다.");
		}
	})
	/*
	 * 메소드명		: commentLoad
	 * 기능			: 총코멘트 숫자와 코멘트들을 읽어옴
	 * 변수			: pNum,movieId
	 * 작성자			: 박윤태
	 */
	function commentLoad(pNum,movieId){
		$.ajax({
			type: "POST",
			async : true,
			contentType:'application/x-www-form-urlencoded;charset=UTF-8',
			url: "comment/count/" + movieId,
			dataType: "text",
			success: function (response) {
				$('#comment-count').text(response);
				totalpage = response/commentPerPage+1;
				if(response!=0&&response%commentPerPage==0){
					totalpage-=1;
				}
			},
			error: function(e){
				alert("commentCount 불러오기 실패 :"+e);
			}
			
		});
		$.ajax({
			type: "POST",
			async : true,
			contentType:'application/x-www-form-urlencoded;charset=UTF-8',
			url: "detail/"+movieId+"/commant/"+pNum,
			dataType: "html",
			success: function (response) {
				$('ol.commentlist').append(response);
			},
			error: function(e){
				alert("comment 불러오기 실패 :"+e);
			}
			
		});
	}
	/*
	 * 메소드명		: insertComment
	 * 기능			: 코멘트 등록 (영수증 첨부)
	 * 변수			: 
	 * 작성자		: 박윤태
	 */
	function insertComment(){
		$('#commentScore').val($('div.starRev span.on').length-1)
		var formData = new FormData($('#contactForm')[0]);//.serialize();
		//alert(formData)
		$.ajax({
			type: "POST",
			async : true,
			enctype: 'multipart/form-data', // 필수
			processData: false, // 필수
			contentType: false,	// 필수
			url: "comment/insert",
			data : formData,
			dataType: "html",
			success: function (response) {
				alert("입력 성공")
				$('ol.commentlist').html(response);
			},
			error: function(e){
				alert("comment 추가 후 불러오기 실패 :"+e);
			}
		})
		//form reset
		$('#contactForm')[0].reset();
	}
});