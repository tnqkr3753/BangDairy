$(document).ready(function(){ 
	 /*
     * 2020-07-20 이경호 수정
     * 수정 내용 : 회원가입 버튼 활성화
     */
    var clSignIn = function() {
		var siteBody = $('body');
    	var signIn = $('.fa-sign-in')
    	signIn.on('click',function(e){
    		siteBody.addClass('Sign-is-visible');

    	});

    };
    /*
     * 2020-07-24 이경호 작업
     * 작업 내용 : 로그인 활성화
     */

    
    	$('#SignForm').on("submit",function(e){
    		e.preventDefault();

    		var userData = $('#SignForm').serialize();
    		$.ajax({
    			type:"POST",
    			url:"SignInUser.do",
    			data: userData,
    			dataType:"json",
    			success: function (data) {
    				if(data==1){
    					alert("로그인 성공");
    					window.location.reload();
    				}
    				else {
    					alert("로그인 실패");
    				}

				},
				error:function(e){
    			alert(e);
				}
    		});
    	});

    clSignIn();
});