$(document).ready(function(){
	alert("movieList 확인이야");
	
	// 평점 클릭했을때
	$('.starRev span').click(function(){
		$(this).parent().children('span').removeClass('on');
		$(this).addClass('on').prevAll('span').addClass('on');
		return false;
	});

	// 네비게이션 바
	var pull=$('#pull');
	
	menu=$('nav ul');
	menuHeight=menu.height();  
	
	$(pull).on('click', function(e){
		e.preventDefault();
		menu.slideToggle();   	      	
	});
	
	$(window).resize(function(){
		var w=$(window).width();
		if(w>600 && menu.is(':hidden'))
		{menu.removeAttr('style');}
	});
});