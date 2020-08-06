$(document).ready(function(){
	var movieId = $('#movieId').val();
	var pageNum = 1;
	var totalpage = 1;
	var commentPerPage = 10;
	commentLoad(pageNum,movieId);
	$(".rslides").responsiveSlides({
		maxwidth:300,
		pager:false,				 // 페이징
		auto:true,				 // 자동으로 넘어가기
		speed:1,				 // 속도
		nav : true,
		prevText: "Previous",    // String: Text for the "previous" button
		nextText: "Next"         // String: Text for the "next" button
	});
	// 평점 클릭했을때
	$('.comments-wrap .starRev span').click(function(){
		$(this).parent().children('span').removeClass('on');
		$(this).addClass('on').prevAll('span').addClass('on');
		return false;
	});
	//커맨트 Regist 클릭할 때
	$("#btn-insertComment").click(function(){
		insertComment();
	})
	//커맨트 더보기를 누를 때
	$('#btn-moreComment').click(function(){
		if(pageNum>=1&&pageNum<=totalpage){
			pageNum+=1;
			commentLoad(pageNum,movieId);
		}else{
			alert("마지막 페이지입니다.");
		}
	});
	//찜목록에 추가 누를 때
	$('#wish-add').click(function(){
		insertWish();
	})
	/*
	 * 메소드명		: commentLoad
	 * 기능			: 총코멘트 숫자와 코멘트들을 읽어옴
	 * 변수			: pNum,movieId
	 * 작성자			: 박윤태
	 */
	function commentLoad(pNum,movieId){
		$.ajax({
			type: "POST",
			async : true,
			url: "comment/count/" + movieId,
			dataType: "text",
			success: function (response) {
				$('#comment-count').text(response+" Comments");
				totalpage = response/commentPerPage+1;
				if(response!=0&&response%commentPerPage==0){
					totalpage-=1;
				}
			},
			error: function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				alert("commentCount 불러오기 실패");
			}
			
		});
		$.ajax({
			type: "POST",
			async : true,
			contentType:'application/x-www-form-urlencoded;charset=UTF-8',
			url: "detail/"+movieId+"/commant/"+pNum,
			dataType: "html",
			success: function (response) {
				$('ol.commentlist').append(response);
			},
			error: function(e){
				alert("comment 불러오기 실패 :"+e);
			}
			
		});
	}
	/*
	 * 메소드명		: insertComment
	 * 기능			: 코멘트 등록 (영수증 첨부)
	 * 변수			: none
	 * 작성자		: 박윤태
	 */
	function insertComment(){
		$('#commentScore').val($('div.starRev span.on').length)
		var formData = new FormData($('#contactForm')[0]);//.serialize();
		//alert(formData)
		$.ajax({
			type: "POST",
			async : true,
			enctype: 'multipart/form-data', // 필수
			processData: false, // 필수
			contentType: false,	// 필수
			url: "comment/insert",
			data : formData,
			dataType: "html",
			success: function (response) {
				if(response==1){
					alert("코맨트 입력 성공");
					$('ol.commentlist').html("");
					commentLoad(1,movieId);
				}else{
					alert("코맨트 입력 실패");
				}
			},
			error: function(e){
				alert("이미 코맨트를 입력했습니다. :"+e);
			}
		})
		//form reset
		$('#contactForm')[0].reset();
	}
		/*
	 * 메소드명		: insertWish
	 * 기능			: 찜목록 추가
	 * 변수			: none
	 * 작성자		: 박윤태
	 */
	function insertWish(){
		$.ajax({
			type: "POST",
			async : true,
			contentType:'application/x-www-form-urlencoded;charset=UTF-8',
			url: "detail/addWish",
			data :  {"movieId":movieId},
			dataType: "html",
			success: function (response) {
				if(response==1){
					alert("찜목록 입력 성공");
				}else{
					alert("찜목록 입력 실패");
				}
			},
			error: function(e){
				alert("이미 찜목록에 추가했습니다. :"+e);
			}
		})
		//form reset
	}
	var modal = document.getElementById('myModal');
 
        // Get the button that opens the modal
        var btn = document.getElementById("btn-preview");
 
        // Get the <span> element that closes the modal
        var span = document.getElementsByClassName("close")[0];                                          
 
        // When the user clicks on the button, open the modal 
        btn.onclick = function() {
            modal.style.display = "block";
        }
 
        // When the user clicks on <span> (x), close the modal
        span.onclick = function() {
            modal.style.display = "none";
        }
 
        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }

});
