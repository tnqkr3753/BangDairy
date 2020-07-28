$(document).ready(function(){ 
	/*
	 *  회원가입 취소버튼 이벤트
	 *  account_cancel : 취소 버튼 Id 값
	 *  작성자 : 이경호
	 */
	$('.account_container #account_cancel').on("click",function(){
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
    	var allCheckResult = false;
    	var regId = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/;
    	var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
    	
    	//조건1. 6~20 영문 대소문자
    	//조건2. 최소 1개의 숫자 혹은 특수 문자를 포함해야 함
    	
    	var regPasswd = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/; 
    	
    	
    	/*
    	 * 2020-07-27 이경호 수정
    	 * 수정 내용: 아이디 입력 input 벗어날시 사용여부 텍스트 숨기기
    	 */
    	$('#user_id').blur(function () {
			$('.FilterResultId').addClass('hideResult');
		});
    	
    	
    	//아이디에 텍스트 입력시마다 ajax로 존재여부 결과를 가져온다.
    	$('#user_id').on("change keyup paste",function () {
    		var idCheck = $('#user_id').val();
    		if (regId.test(idCheck)==false){
    			$('#idCheckResult').html("영문자와 숫자로 이루어진 조합 6자리 이상만 가능합니다.");
    			return
    		}
    		if (idCheck.length==0){
    			$('#idCheckResult').html("");
    			return
    		}
    		
        	$.ajax({
        		data: {"user_id":idCheck},
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
    	
    	//이메일 정규식
    	$('#user_email').on("change keyup paste",function () {
    		var emailCheck = $('#user_email').val();
    		if(emailCheck.length==0){
    			$('#eMailCheckResult').html("");
    		}
    		else{
    			// 이메일 형식: 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식
    			
    			if(exptext.test(emailCheck) == false) { 
    				$('#eMailCheckResult').html("이메일 주소가 유효하지 않습니다.");
    				allCheckResult=false;
    			}
    			else{
    				$('#eMailCheckResult').html("사용 가능한 이메일 주소 입니다.");
    				allCheckResult=true;
    			}
    		}
    	}); // 이메일 정규식 end
    	
    	
    	//비밀번호 정규식 체크
    	$('#user_passwd').focusout(function () {
    		var passWdCheck = $('#user_passwd').val();
			if(regPasswd.test(passWdCheck)==false){
				$('#passwdCheckResult').html("최소 1개의 숫자 또는 특수문자와 6~20자의 비밀번호를 입력해주세요");
				allCheckResult=false;
			}
			else{
				$('#passwdCheckResult').html("규격에 맞음");
				allCheckResult=true;
			}
		});
    	$('#user_passwd2').focusout(function () {
    		var passWdCheck2 = $('#user_passwd2').val();
			if(passWdCheck2 != $('#user_passwd').val()){
				$('#passwdCheckResult2').html("비밀번호 불일치");
				allCheckResult=false;
			}
			else{
				$('#passwdCheckResult2').html("확인");
				allCheckResult=true;
			}
		});
    	
    	
    	$('#onsubmit').on("submit",function (e) {

    		e.preventdefault();
		    if (allCheckResult==true){
		    	this.submit();
		    }
		});

    	
	};
	clAccount();
    accountSubmit();
});