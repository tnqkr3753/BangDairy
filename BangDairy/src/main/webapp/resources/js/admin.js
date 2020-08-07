$(function(){
    var searchWord = "all";
    var page = 1;
    var type = null;
    $(".dropdown-item").click(function(){
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
    $(document).on("keydown",".form-control",function(key){
        if(key.keyCode == 13){
            searchWord = $(this).val();
            page = 1;
            show(type,searchWord,page)
        }
    })
    $(document).on("click",".btn-search",function(){
        searchWord = $(".form-control").val();
        page = 1;
        show(type,searchWord,page)
    })
    //보여주기
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
});