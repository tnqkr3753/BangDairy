$(document).ready(function(){ 
	
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
    	//아이디에 텍스트 입력시마다 ajax로 존재여부 결과를 가져온다.
    	$('#user_id').on("change keyup paste",function () {
    		var idCheck = $('#user_id').val();
    		if (idCheck.length==0){
    			$('#idCheckResult').html("");
    			return
    		}
    		
        	$.ajax({
        		data: {"user_id":idCheck},
        		url: 'AccountForm_idCheck.do',
        		success: function(data) {
        			var result = data;
        			if (result==0){
        				$('#idCheckResult').html("사용 가능한 아이디 입니다.");
        				allCheckResult=true;
        			}
        			else{
        				$('#idCheckResult').html("이미 사용중인 아이디 입니다.");
        				allCheckResult=false;
        			}
        		}
        	});
    	});
    	//이메일 정규식
    	$('#user_email').on("change keyup paste",function () {
    		var emailCheck = $('#user_email').val();
    		if(emailCheck.length==0){
    			$('#eMailCheckResult').html("");
    		}
    		else{
    			// 이메일 형식: 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식
    			var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
    			if(exptext.test(emailCheck) == false) { 
    				$('#eMailCheckResult').html("이메일 주소가 유효하지 않습니다.");
    				allCheckResult=false;
    			}
    			else{
    				$('#eMailCheckResult').html("사용 가능한 이메일 주소 입니다.");
    				allCheckResult=true;
    			}
    		}
    	});
    	
		$('#account_body').submit(function () {
			
		});
	};
	clAccount();
    accountSubmit();
});