$(function(){
    /* 관리 페이지 */
    var searchWord = "all";
    var page = 1;
    var type = null;
    $(".drop-type").click(function(){
        page = 1;
        searchWord = "all";
        type = $(this).data("type")
        show(type,searchWord,page)
    })
    $(document).on('click',"#btn-more",function(){
        page += 1;
        show(type,searchWord,page);
    });
    /* 검색  */
    // 엔터칠 때
    $(document).on("keydown",".search",function(key){
        if(key.keyCode == 13){
            searchWord = $(this).val();
            if(searchWord == "") {
                searchWord = "all";
            }
            page = 1;
            show(type,searchWord,page)
        }
    });
    // 버튼 눌렀을 때
    $(document).on("click",".btn-search",function(){
        searchWord = $(".form-control").val();
        if(searchWord == "") {
            searchWord = "all";
        }
        page = 1;
        show(type,searchWord,page)
    });
    /* Q&A 작성 및 보기 */
    //Q&A 작성하기
    $(document).on("click",'.write-qna',function(e){
        var status =$(this).closest('td').data('status');
        if(status=="required") {
            var qnaid = $(this).closest('tr').find('td:first-child').text();
            var tr = "<tr><td colspan='5' data-qnaid='"+qnaid+"'><textarea style='height:300px' class='form-control write-text'></textarea></td>"+
            "<td><input type='button' value='작성완료' class='btn btn-primary qna-submit'/></td></tr>"
            $(this).closest('tr').after(tr);
            $(this).closest('td').data('status',"writing");
        }else if (status=="writing"){
            $(this).closest('tr').next().remove();
            $(this).closest('td').data('status',"required");
        }
    });
    //Q&A 작성 완료
    $(document).on('click','.qna-submit',function(){
        updateAnswer($(this));
    })
    //이미 입력한 답변 보기
    $(document).on("click",'.show-qna',function(){
        var id = $(this).closest('tr').find('td:first-child').text();
        var inputData = {"qnaId":id};
        var status =$(this).closest('td').data('status');
        var qnaid = $(this).closest('tr').find('td:first-child').text();
        var tr = "";
        if(status=="required") {
            $.ajax({
                type:"POST",
                url:"admin/"+type+"/answer/get",
                async : false,
                data:inputData,
                dataType: "text",
                success: function (data) {
                        tr = "<tr><td colspan='5' data-qnaid='"+qnaid+"'><textarea style='height:300px' class='form-control write-text' readonly='readonly'>"+data+"</textarea></td>"+
                        "<td><input type='button' value='수정' class='btn btn-primary qna-modify'/></td></tr>"
                        
                },
                error:function(e){
                    alert("답변 불러오기 오류");
                }
            });
            $(this).closest('tr').after(tr);
            if(tr!="") $(this).closest('td').data('status',"writing");
        }else if (status=="writing"){
            $(this).closest('tr').next().remove();
            $(this).closest('td').data('status',"required");
        }
    });
    /* 입력한 답변 수정 */
    $(document).on('click','.qna-modify',function(){
        $(this).closest('tr').find("textarea").removeAttr("readonly");
        $(this).closest('tr').find("textarea").addClass("write-text")
        $(this).val("수정완료");
        $(this).addClass("qna-submit");
    });

    /* 인디 영화 부분 */
    //허가요청, 허가, 비허가 클릭할 때
    $(document).on('click','.indie',function(){
        var id = $(this).closest('tr').find('td:first-child').text();
        var status =$(this).closest('td').data('status');
        var inputData = {"indieId":id};
        var tr = "";
        if(status=="required") {
            $.ajax({
                type:"POST",
                url:"admin/"+type+"/show",
                async : false,
                data:inputData,
                dataType: "html",
                success: function (data) {
                        tr = data;
                },
                error:function(e){
                    alert("인디영화 불러오기 오류");
                }
            });
            $(this).closest('tr').after(tr);
            if(tr!="") $(this).closest('td').data('status',"writing");
        }else if (status=="writing"){
            $(this).closest('tbody').find("tr[name="+id+"]").remove();
            $(this).closest('td').data('status',"required");
        }
    })
    /* TODO 승인, 벤 버튼 이벤트 */
    //허가     //벤
    $(document).on('click',".manage-indie",function(){
        var indietype = $(this).val();
        var indieConfirm = "n";
        if(indietype=="ban") {
            indieConfirm = "b";
        }else if (indietype =="permit"){
            indieConfirm = "y";
        }
        var id = $(this).closest("tr").attr('name');
        var result = confirm(id+ "번 영화를 " + indietype + " 하시겠습니까?");
        var inputData = {"indieId":id,"indieConfirm":indieConfirm}
        if(result){
            $.ajax({
                type:"POST",
                url:"admin/"+type+"/confirm",
                async : false,
                data:inputData,
                dataType: "text",
                success: function (data) {
                        if(data == 1){
                            alert("성공적으로 수정되었습니다.");
                            show(type,searchWord,page);
                        }else{
                            alert("수정에 실패하였습니다.");
                        }
                },
                error:function(e){
                    alert("인디영화 수정 오류");
                }
            });
        }
    })
    /* 유저 벤 */
    $(document).on('click',".ban-user",function () {  
        banControl($(this));
    });
    function banControl(input){
        var banType = input.data("bantype");
        var userid= input.data("id");
        var result = confirm(userid+"번 사용자를 벤하시겠습니까?");
        var userData = {"userId":userid};
        if (result){
            $.ajax({
                type:"POST",
                url:"admin/"+type+"/"+banType,
                async : false,
                data:userData,
                dataType: "text",
                success: function (data) {
                        if(data == 1){
                            alert("성공적으로 수정되었습니다.");
                            show(type,searchWord,page);
                        }else{
                            alert("수정에 실패하였습니다.");
                        }
                },
                error:function(e){
                    alert("유저 벤 수정 오류");
                }
            });
        }
    };
    /* 보여주기 함수 */
    function show(type,searchWord,page){
        $.ajax({
            type:"POST",
            url:"admin/"+type+"/"+encodeURI(searchWord)+"/"+page,
            async : false,
            dataType: "html",
            success: function (data) {
                $('.content-admin').html(data);

            },
            error:function(e){
                alert(e);
            }
        });
    }
    /* qna db에 저장하는 함수 */
    function updateAnswer(input){
        var answer =  input.closest('tr').find('.write-text').val();
        var id = input.closest('tr').find('td:first-child').data('qnaid');
        var inputData = {"qnaId":id,"qnaAnswer":answer}
        $.ajax({
            type:"POST",
            url:"admin/"+type+"/answer",
            async : false,
            data:inputData,
            dataType: "text",
            success: function (data) {
                if(data == 1){
                    alert("답변 입력 성공");
                    show(type,searchWord,page);
                }else{
                    alert("답변 입력 실패");
                }
            },
            error:function(e){
                alert("답변 입력 오류");
            }
        });
    }


    /* 통계 페이지 */
    //영화 통계
    $('.manage-a').click(function(){
        var a = $(this).data('a');
        showManage(a);
    })
    function showManage(a){
        $.ajax({
            type:"POST",
            url:"admin/manage/"+a,
            async : false,
            dataType: "html",
            success: function (data) {
                $('.content-admin').html(data);
            },
            error:function(e){
                alert(e);
            }
        });
    }
    /* 영화 정보 받아오기 */
    $('#getMovieapp').click(function(){
        alert("데이터 가져오기")
        $.ajax({
            type:"POST",
            url:"api/conn/movie",
            async : true,
            dataType: "text",
            success: function () {
                alert("성공적으로 데이터를 가져왔습니다.");

            },
            error:function(e){
                alert("데이터 가져오기에 실패했습니다.");
            }
        });
    });
    /*
     * 경호 추가
     * 넥사크로
     */
//    $('.ban-list').on('click',function(){
//    	$.ajax({
//            type:"POST",
//            url:"admin/userBanList",
//            async : true,
//            dataType: "text",
//            success: function (data) {
//            	$('.content-admin').html(data);
//
//            },
//            error:function(e){
//                alert("데이터 가져오기에 실패했습니다.");
//            }
//        });
//    });
});