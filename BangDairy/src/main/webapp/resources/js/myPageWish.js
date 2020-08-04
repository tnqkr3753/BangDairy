$(document).ready(function(){
    $('.delete-wish').click(function(){
        var movieId = $(this).closest("tr").find('input[name=movieId]').val();
        if(confirm("정말 삭제하시겠습니까?")){
            $.ajax({
                type: "POST",
                async : true,
                contentType:'application/x-www-form-urlencoded;charset=UTF-8',
                url: "myPage/wishList/delete",
                dataType: "text",
                data:{"movieId":movieId},
                success: function (response) {
                    if(response){
                        alert("찜목록에서 삭제되었습니다.");
                        loadWishList();
                    }else{
                        alert("찜목록에서 삭제가 실패했습니다.")
                    }
                },
                error: function(e){
                    alert("찜목록 삭제 실패 :"+e);
                }
                
            });
        }else{
            alert("삭제를 취소했습니다.");
        }
    });
});