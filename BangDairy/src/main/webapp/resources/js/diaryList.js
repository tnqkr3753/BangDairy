$(function(){
	$('#btn-moreview').click(function(){
		alert("클릭");
		$('.hide-tr').filter(function(index,selector){
			if(index <=10){
				$(selector).removeClass('hide-tr');
			}
		});
	});
});