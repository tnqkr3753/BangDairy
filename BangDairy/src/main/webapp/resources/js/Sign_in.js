$(document).ready(function(){ 
	 /*
     * 2020-07-20 이경호 수정
     * 수정 내용 : 회원가입 버튼 활성화
     */
    var clSignIn = function() {
		var siteBody = $('body');
    	var signIn = $('#show-login')
    	signIn.on('click',function(e){
    		siteBody.addClass('Sign-is-visible');

    	});

    };
    /*
     * 2020-07-29 경호 수정
     * 수정 내용 : 취소 버튼 클릭시 메인으로 돌아가기
     */
    $('#login-cancel-btn').on("click",function(){
    	var siteBody = $('body');
    	siteBody.removeClass('Sign-is-visible');
    });
    /*
     * 2020-07-24 이경호 작업
     * 작업 내용 : 로그인 활성화
     */

    
    	$('#login-btn').on("click",function(e){
/*    		e.preventDefault();
    		e.stopPropagation();*/
    		var userData = $('#SignForm').serialize();
    		$.ajax({
    			type:"POST",
    			url:"SignInUser",
    			data: userData,
    			success: function (data) {
    				if(data==1){
    					alert("로그인 성공");
    					window.location.href="index.jsp"
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