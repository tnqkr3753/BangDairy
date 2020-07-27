$(document).ready(function(){
	var movieId = $('#movieId').val();
	alert(movieId)
	commentLoad(1,movieId);
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

	function commentLoad(pNum,movieId){
		$.ajax({
			type: "POST",
			async : true,
			contentType:'application/x-www-form-urlencoded;charset=UTF-8',
			url: "detail/"+movieId+"/commant/"+pNum,
			dataType: "html",
			success: function (response) {
				alert("성공 :" + response)
				$('ol.commentlist').html(response);
			},
			error: function(e){
				alert("comment 불러오기 실패 :"+e);
			}
			
		});
	}
});