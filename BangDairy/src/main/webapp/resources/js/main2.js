$(document).ready(function(){ 
    var main = $('.bxslider').bxSlider({ 
	
	    auto: false,	//자동으로 슬라이드
	
	    minSlides:1,
		maxSlides:10,
		slideWidth:300,
		slideMargin:30,
		moveSlides:1
		
	}); 
	
	
	    var main = $('.bxslider1').bxSlider({ 
	    	
	        auto: true,	//자동으로 슬라이드
	
	        minSlides:1,
	    	maxSlides:10,
	    	slideWidth:300,
	    	slideMargin:30,
	    	moveSlides:1
	    	
	    }); 
	
	$(".bx-stop").click(function(){	// 중지버튼 눌렀을때 
	
	    main.stopAuto(); 
	
	    $(".bx-stop").hide(); 
	
	    $(".bx-start").show(); 
	
	    return false; 
	
	}); 
	
	$(".bx-start").click(function(){	//시작버튼 눌렀을때 
	
	    main.startAuto(); 
	
	    $(".bx-start").hide(); 
	
	    $(".bx-stop").show(); 
	
	    return false; 
	
	}); 
	
	$(".bx-start").hide();	//onload시 시작버튼 숨김. 

	$('div.entry__thumb').click(function () {
		location.href="detail?movieId=K00228";
			// alert("클릭")
			// jQuery.ajax({
			// 	type: "POST",
			// 	url: "detail/K00228.do",
			// 	dataType: "html",
			// 	success: function (response) {
			// 		$(".header_sticky").html(response);
			// 		console.log(response)
			// 	},
			// 	error:function(er){
			// 	   alert("ajax 오류"+er)
			// 	}
			// });
	});
	
});  
