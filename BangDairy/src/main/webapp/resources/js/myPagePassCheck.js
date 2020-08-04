
jQuery(document).ready(function ($) {
	//파일 선택할 때
	$('#profile_img').change(function () {
		readURL(this);
	});
	//비밀번호확인 버튼 누를 때
	$("#btn-Confirm").click(function(){
		clickPassCheck("myPage/info/deleteUser");
	});

		/*
	 * 메소드 명		: clickUpdate
	 * 메소드 기능		: 비밀번호확인 누르면 form데이터를 Controller로 넘긴다.
	 * 변수				: None
	 * 작성자			: 박윤태
	 */

});
function clickPassCheck(url) {
	var pass= $('#pass').val();
	var chkPass = $('#passwordCheck').val();
	alert(pass + chkPass);
	if(pass!=""){
		if(pass!=chkPass){
			alert("비밀번호가 일치하지 않습니다");
			return false;
		}
	}
	var data = {"userPassword":pass}
	$.ajax({
		type: "POST",
		async : true,
		url: url,
		data : data,
		dataType: "text",
		success: function (response) {
			if(response==1){
				alert("탈퇴되었습니다. 이용해주셔서 감사합니다");
				window.location.href="index.jsp";
			}else{
				alert("정보가 올바르지 않습니다. 다시 확인해주세요");
			}
		},
		error: function(request,status,error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}

