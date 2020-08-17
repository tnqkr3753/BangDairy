$(function(){
	$('.monthly-diary').each(function(){
		$(this).css({cursor:"pointer"});
	});
	$(document).on('click','.monthly-diary',function(){
		$(this).closest("form").submit();
	});
});