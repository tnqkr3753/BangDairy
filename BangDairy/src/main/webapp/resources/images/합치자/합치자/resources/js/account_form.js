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
    clAccount();
});