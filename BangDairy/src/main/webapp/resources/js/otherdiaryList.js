$(document).ready(function(){
alert("dddd");
	pNum = 1;
	$.ajax({
		type : 'POST',	// 요청 메소드 타입
		url : "showODiaryList/" + pNum,	
		dataType : "html",	
		error : function(e) {       
			alert('통신실패' + e);
		},
		success : function(data) {    
			alert(data);
			$('#maretabtab').html(data);
		}
	});
});

