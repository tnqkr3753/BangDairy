$(document).ready(function(){
	radioClick();
	
	// 평점 클릭했을때
	$('.starRev span').click(function(){
		$(this).parent().children('span').removeClass('on');
		$(this).addClass('on').prevAll('span').addClass('on');
		return false;
	});

	// 네비게이션 바
	var pull=$('#pull');
	
	menu=$('nav ul');
	menuHeight=menu.height();  
	
	$(pull).on('click', function(e){
		e.preventDefault();
		menu.slideToggle();   	      	
	});
	
	$(window).resize(function(){
		
		var w=$(window).width();
		if(w>600 && menu.is(':hidden'))
		{menu.removeAttr('style');}
	});
	
	// 영화 리스트 페이지에서 라디오 버튼(조건)을 클릭했을때
	$(".search__tab").click(function() {
		// alert("라디오 버튼 클릭했을때")
		radioClick();
	
	});
	
	// 셀렉트 박스가 변경되었을때
	$("#orderBy").on('change', function() {
		// alert("select box 변경")
		pNum = 1;
		selectOrder = $("#orderBy").val();
		// alert(selectOrder);
		
		$.ajax({
			type : 'POST',	// 요청 메소드 타입
			url : "searchBy/" + tabName + "/" + pNum + "/" + selectOrder + "/" + genre,	// 클라이언트가 HTTP 요청을 보낼 서버의 주소
			dataType : "html",	// 서버가 리턴하는 데이터 타입
			error : function(e) {          // 통신 실패시
				alert('select 통신실패' + e);
			},
			success : function(data) {    // Ajax 통신에 성공했을 때 호출될 이벤트 핸들러
				$('#movieSearch').html(data);	// searchTab의 아이디가 movieSearch인 div에 붙임
			}
		});
		
	});
	
	// 라디오 버튼을 클릭했을때
	function radioClick() {
		genre = $('.active').text();
		pNum = 1;
		tabName = $('input:radio[name="searchTab"]:checked').val(); // 선택된 라디오 버튼의 value 값
		// alert(tabName);
		
		selectOrder = $("#orderBy").val();
		
		$.ajax({
			type : 'POST',	// 요청 메소드 타입
			url : "searchBy/" + tabName + "/" + pNum + "/" + selectOrder + "/" + genre,	// 클라이언트가 HTTP 요청을 보낼 서버의 주소
			dataType : "html",	// 서버가 리턴하는 데이터 타입
			error : function(e) {          // 통신 실패시
				alert('radio 통신실패' + e);
			},
			success : function(data) {    // Ajax 통신에 성공했을 때 호출될 이벤트 핸들러
				$('#movieSearch').html(data);	// searchTab의 아이디가 movieSearch인 div에 붙임
			}
		});
	}
	
	var s = $("ul > li");
	
	// 장르 선택했을때
	s.find('a').click(function() {
		pNum = 1;
		
		s.removeClass("active");     // 원래 선택되어있던 active 클래스 삭제
		$(this).parent().addClass("active");	// active 클래스 추가
		
		var genre = $(this).text();	// 현재 내가 선택한 장르
		// alert(genre);
		
		$.ajax({
			type : 'POST',	// 요청 메소드 타입
			url : "searchBy/" + tabName + "/" + pNum + "/" + selectOrder + "/" + genre,	// 클라이언트가 HTTP 요청을 보낼 서버의 주소
			dataType : "html",	// 서버가 리턴하는 데이터 타입
			error : function(e) {          // 통신 실패시
				alert('genre 통신실패' + e);
			},
			success : function(data) {    // Ajax 통신에 성공했을 때 호출될 이벤트 핸들러
				$('#movieSearch').html(data);
			}
		});
	});
});