$(function(){
	$('#btn-moreview').click(function(){
		$('.hide-tr').filter(function(index,selector){
			if(index <=10){
				$(selector).removeClass('hide-tr');
			}
		});
	});
	$('.search-tr').each(function(){
		$(this).css({cursor:"pointer"});
	})
	$(document).on('click','.search-tr',function(){
		var did = $(this).data('did');
		var uid = $(this).data('uid');
		$('#search-uid').val(uid);
		$('#search-did').val(did);
		$('#go-getdairy').submit();
	});
});