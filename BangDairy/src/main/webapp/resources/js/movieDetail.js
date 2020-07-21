$(document).ready(function(){
	alert("확인");
	
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
});