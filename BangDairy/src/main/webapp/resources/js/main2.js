$(document).ready(function(){ 
	getMovieWithScore();
	getGenreWithHits();
	function bxstart (){
		var bx = $('.bxslider').bxSlider({ 
			auto: false,	//자동으로 슬라이드
			minSlides:1,
			maxSlides:10,
			slideWidth:300,
			slideMargin:30,
			moveSlides:1,
			controls: true
		}); 
	}
	    var main = $('.bxslider1').bxSlider({ 
	    	
	        auto: true,	//자동으로 슬라이드
	
	        minSlides:1,
	    	maxSlides:10,
	    	slideWidth:300,
	    	slideMargin:30,
	    	moveSlides:1
	    	
	    }); 
	$(".bx-start").hide();	//onload시 시작버튼 숨김. 

	$('div.entry__thumb').click(function () {
		var movieId = $(this).attr('mid');
		location.href="detail?movieId="+movieId;
	});
	/* 		메소드 명 		: getMovieWithScore
	* 		기능			: 평점순 영화를 index에 띄워줌
	*		변수			: None
	*		작성자			: 박윤태
	*/
	function getMovieWithScore(){
		$.ajax({
			type: "POST",
			async : true,
			url: "getm/score",
			dataType: "html",
			success: function (response) {
				$('#title_movie_list').html(response);
				bxstart();
			},
			error: function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				alert("평점 순 영화 불러오기 실패");
			}
			
		});
	}
	/* 		메소드 명 		: getGenreWithHits
	* 		기능			: 인기있는 장르 3개를 받아온 뒤 getMovieWithGenre 호출
	*		변수			: None
	*		작성자			: 박윤태
	*/
	function getGenreWithHits(){
		//데이터를 받고 다음 내용을 실행하기 위해 동기화 
		$.ajax({
			type: "POST",
			async : true,
			url: "getm/hits",
			dataType: "json",
			contentType: "application/json",
			success: function (response) {
				getMovieWithGenre(response['0'],$('#first_movie_list'))
				getMovieWithGenre(response['1'],$('#second_movie_list'))
				getMovieWithGenre(response['2'],$('#third_movie_list'))
				
			},
			error: function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				alert("장르 순서 불러오기 실패");
			}
			
		});
	}
	/* 		메소드 명 		: getMovieWithGenre
	* 		기능			: 장르의 조회수 높은 영화 10개를 인덱스에 뿌림
	*		변수			: genreId
	*		작성자			: 박윤태
	*/
	function getMovieWithGenre(genreId,temp){
		//데이터를 받고 다음 내용을 실행하기 위해 동기화
		$.ajax({
			type: "POST",
			async : true,
			url: "getm/genre/"+genreId,
			dataType: "html",
			success: function (response) {
				temp.html(response);
				bxstart();
			},
			error: function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				alert("장르 별 영화 불러오기 실패");
			}
			
		});
	}
});  
