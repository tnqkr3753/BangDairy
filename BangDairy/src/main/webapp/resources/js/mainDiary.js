$(function(){
	$(document).on('click','.monthly-diary',function(){
		var diaryId = $(this).data('did');
		var userId = $(this).data("uid");
		$('#monthly-uid').val(userId);
		$('#monthly-did').val(diaryId);
		$("#go-getdairy").submit();
	});
});