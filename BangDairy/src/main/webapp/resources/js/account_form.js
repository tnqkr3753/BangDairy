$(document).ready(function(){ 
	/*
	 *  회원가입 취소버튼 이벤트
	 *  account_cancel : 취소 버튼 Id 값
	 *  작성자 : 이경호
	 */
	$('.account_form #account_cancel').on("click",function(){
		var siteBody = $('body');
		siteBody.removeClass('account-is-visible')
	});
	
	 /*
     * 2020-07-20 이경호 수정
     * 수정 내용 : 회원가입 버튼 활성화
     */
    var clAccount = function() {
		var siteBody = $('body');
    	var accountWrap = $('.fa-address-book-o')
    	accountWrap.on('click',function(e){
    		siteBody.addClass('account-is-visible');

    	});

    };
    //회원가입 메소드
    
    var accountSubmit = function () {
    	
    	/*
    	 * 2020-07-27 경호 추가
    	 * 추가 내용: 주민번호 입력단 숫자만 받게 하기
    	 * 설명 : 숫자 이외의 단어가 입력 될 시 replace를 통해 제거한다.
    	 */
    	$('.userReg').on("keyup", function() {
    	    $(this).val($(this).val().replace(/[^0-9]/g,""));
    	});
    	var allCheckResult = false;

    	//아이디에 텍스트 입력시마다 ajax로 존재여부 결과를 가져온다.
    	//아이디 정규식 : 6~20자 영문자,숫자 최소 한개씩
    	var regId = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/;
    	$('#user_id').on("keyup",function () {
    		var idCheck = $('#user_id').val();
    		if (regId.test(idCheck)==false){
    			$('#idCheckResult').html("영문자+숫자 최소 6자리");
    			$('.FilterResultId').removeClass('hideResult');
    			return;
    		}
    		if (idCheck.length==0){
    			$('#idCheckResult').html("");
    			$('.FilterResultId').addClass('hideResult');
    			return;
    		}
    		
        	$.ajax({
        		data: {"id":idCheck},
        		type:"post",
        		url: 'AccountForm_idCheck',
        		success: function(data) {
        			var result = data;
        			if (result==0){
        				$('#idCheckResult').html("사용 가능한 아이디 입니다.");
        				$('.FilterResultId').removeClass('hideResult');
        				
        				allCheckResult=true;
        			}
        			else{
        				$('#idCheckResult').html("이미 사용중인 아이디 입니다.");
        				allCheckResult=false;
        				$('.FilterResultId').removeClass('hideResult');
        			}
        		}
        	});
    	}); // 아이디 end
    	
//    	/*
//    	 * 2020-07-27 이경호 수정
//    	 * 수정 내용: 아이디 입력 input 벗어날시 사용여부 텍스트 숨기기
//    	 */
//    	$('#user_id').blur(function () {
//			$('.FilterResultId').addClass('hideResult');
//		});
    	
    	//이메일 정규식
    	//형식: 영문자+숫자 @ 영문자+숫자 . 영문자+숫자
    	var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
    	$('#user_email').on("change keyup paste",function () {
    		var emailCheck = $('#user_email').val();
    		if(emailCheck.length==0){
    			$('#eMailCheckResult').html("");
    			$('.FilterResultEmail').addClass('hideResult');
    		}
    		else{
    			if(exptext.test(emailCheck) == false) { 
    				$('#eMailCheckResult').html("이메일 주소가 유효하지 않습니다.");
    				$('.FilterResultEmail').removeClass('hideResult');
    				allCheckResult=false;
    			}
    			else{

    				$.ajax({
    					type:"post",
    					contentType:'application/x-www-form-urlencoded;charset=UTF-8',
    	        		data: {"email":emailCheck},
    	        		url: 'AccountForm_emailCheck',
    	        		success: function(data) {
    	        			var result = data;
    	        			if (result==0){
    	        				$('#eMailCheckResult').html("사용 가능한 이메일 주소 입니다.");
    	        				$('.FilterResultEmail').removeClass('hideResult');
    	        				allCheckResult=true;
    	        			}
    	        			else{
    	        				$('#eMailCheckResult').html("이미 사용중인 이메일 주소 입니다.");
    	        				allCheckResult=false;
    	        				$('.FilterResultEmail').removeClass('hideResult');
    	        			}
    	        		}
    	        	});
    			}
    		}
    	}); // 이메일 정규식 end
    	
    	
    	//비밀번호 정규식 체크
    	//조건1. 6~20 영문 대소문자
    	//조건2. 최소 1개의 숫자 혹은 특수 문자를 포함해야 함
    	var regPasswd = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/; 
    	$('#user_passwd').focusout(function () {
    		var passWdCheck = $('#user_passwd').val();
			if(regPasswd.test(passWdCheck)==false){
				$('#passwdCheckResult').html("6~20자 최소 1개의 숫자 또는 특수문자 ");
				$('.FilterResultPasswd').removeClass('hideResult');
				allCheckResult=false;
			}
			else{
				$('#passwdCheckResult').html("✔");
				$('.FilterResultPasswd').removeClass('hideResult');
				allCheckResult=true;
			}
		});
    	$('#user_passwd2').focusout(function () {
    		var passWdCheck2 = $('#user_passwd2').val();
			if(passWdCheck2 != $('#user_passwd').val()){
				$('#passwdCheckResult2').html("비밀번호 불일치");
				$('.FilterResultPasswd2').removeClass('hideResult');
				allCheckResult=false;
			}
			else{
				$('#passwdCheckResult2').html("✔");
				$('.FilterResultPasswd2').removeClass('hideResult');
				allCheckResult=true;
			}
		});
    	
    	
    	$('#onsubmit').on("click",function (e) {
    		
		    if (allCheckResult==true){
		    	e.preventDefault();
		    	/*
		    	 * 주민번호 합쳐서 보내주기
		    	 */
		    	$('#saveReg').val($('.userReg').val()+$('.userRegB').val());
		    	var userData = $('#accountForm').serialize();
		    	//비동기 통신으로 유저 정보 저장하고 결과값 받기.
		    	console.log(userData);
		    	$.ajax({
	        		data: userData,
	        		type:"POST",
	        		url: 'AccountUser',
	        		success: function(data) {
	        			var result = data;
	        			if (result==0){
	        				alert('가입실패 : DB오류');
	        			}
	        			else{
	        				alert('가입이 성공적으로 완료 되었습니다.');
	        				window.location.href="index.jsp";
	        			}
	        		}
	        	});
		    }
		});

    	
	};
	clAccount();
    accountSubmit();
});