$(document).ready(function(){ 
	getSessionId();
	/* 		메소드 명 		: getListAsNormal
	* 		기능			: 로그인 되지 않은 유저들의 리스트를 띄워줌
	*		변수			: None
	*		작성자			: 박윤태
	*/
	function getListAsNormal(){
		getMovieWithScore();
		getGenreWithHits();
	}
	/* 		메소드 명 		: bxstart
	* 		기능			: 리스트를 bx슬라이더로 만들어준다
	*		변수			: None
	*		작성자			: 박윤태
	*/
	function bxstart (){
		var bx = $('.bxslider').bxSlider({ 
			auto: false,	//자동으로 슬라이드
			minSlides:1,
			maxSlides:10,
			slideWidth:300,
			slideMargin:30,
			moveSlides:2,
			controls: false,
			touchEnabled:true,
			pager:false
		}); 
	}
	$(".bx-start").hide();	//onload시 시작버튼 숨김. 
	$(document).on('click',".entry__thumb",function(){
		var movieId = $(this).find(".movieId").val();
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
	/* 		메소드 명 		: getSessionId
	* 		기능			: 서버에서 session Id의 존재 여부를 얻어온다
	*		변수			: None
	*		작성자			: 박윤태
	*/
	function getSessionId(){
		$.ajax({
			type: "POST",
			async : true,
			url: "check/session",
			dataType: "text",
			success: function (response) {
				if(response=='true'){
					getActorMovieWithWish($('#first_movie_list'));
					getMovieWithUserGenre($('#second_movie_list'));
				}else{
					getListAsNormal();
				}
			},
			error: function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				alert("세션 가져오기 실패");
			}
			
		});
	}
	/* 		메소드 명 		: getActorMovieWithWish
	* 		기능			: 마이페이지에 저장한 영화 관련 리스트 가져오기
	*		변수			: None
	*		작성자			: 박윤태
	*/
	function getActorMovieWithWish(div){
		$.ajax({
			type: "POST",
			async : true,
			url: "getm/wish",
			dataType: "html",
			success: function (response) {
				div.html(response);
				bxstart();
			},
			error: function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				alert("장르 별 영화 불러오기 실패");
			}
			
		});
	}
		/* 		메소드 명 		: getMovieWithUserGenre
	* 		기능			: 유저가 남긴 평점 줌 평균이 높은 장르의 영화 중 조회수가 높은 영화 중 내가 보지 않은 영화
	*		변수			: None
	*		작성자			: 박윤태
	*/
	function getMovieWithUserGenre(div){
		$.ajax({
			type: "POST",
			async : true,
			url: "getm/scoregenre",
			dataType: "html",
			success: function (response) {
				div.html(response);
				bxstart();
			},
			error: function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				alert("장르 별 영화 불러오기 실패");
			}
			
		});
	}
});  
