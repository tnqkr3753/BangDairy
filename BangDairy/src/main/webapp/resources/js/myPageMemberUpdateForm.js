
jQuery(document).ready(function ($) {
	//파일 선택할 때
	$('#profile_img').change(function () {
		readURL(this);
	});
	//수정완료 버튼 누를 때
	$("#btn-updateConfirm").click(function(){
		clickUpdate();
	});
	/*
	 * 메소드 명		: readURL
	 * 메소드 기능		: 선택된 파일을 읽어 미리보기로 보여줌
	 * 변수				: input(type=file)
	 * 작성자			: 박윤태
	 */
	function readURL(input) {
			var reader = new FileReader(); 
			reader.onload = function(event) { 
				var img = document.createElement("img"); 
				img.setAttribute("src", event.target.result); 
				$("div#image_container").html(img); 
			}; 
			reader.readAsDataURL(input.files[0]); 
	}
		/*
	 * 메소드 명		: clickUpdate
	 * 메소드 기능		: 수정완료를 누르면 form데이터를 Controller로 넘긴다.
	 * 변수				: None
	 * 작성자			: 박윤태
	 */
	function clickUpdate() {
		var formData = new FormData($("#account")[0]);
		$.ajax({
			type: "POST",
			async : true,
			enctype: 'multipart/form-data', // 필수
			processData: false, // 필수
			contentType: false,	// 필수
			url: "myPage/info/updateUser",
			data : formData,
			dataType: "html",
			success: function (response) {
				if(response){
					$('.mypage-content').html(response);
				}
			},
			error: function(e){
				alert("comment 추가 후 불러오기 실패 :"+e);
			}
		})
	}
});
	/*
	 * 메소드 명		: chk_file_type
	 * 메소드 기능		: 선택된 파일이 이미지 파일인지 확인함
	 * 변수				: obj(input type=file)
	 * 작성자			: 박윤태
	 */
function chk_file_type(obj) {
	var file_kind = obj.value.lastIndexOf('.');
	var file_name = obj.value.substring(file_kind+1,obj.length);
	var file_type = file_name.toLowerCase();
	var check_file_type= new Array;
	var check_file_type=['jpg','gif','png','jpeg','bmp'];
	if(check_file_type.indexOf(file_type)==-1){
		alert('이미지 파일만 선택할 수 있습니다.');
		var parent_Obj=obj.parentNode
		var node=parent_Obj.replaceChild(obj.cloneNode(true),obj);
		obj.value = '';
		obj.focus();
		return false;
	}
}
