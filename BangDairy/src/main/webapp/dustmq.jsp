<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko" class="js flexbox csstransforms csstransforms3d csstransitions responsejs translated-ltr"><head>




<script charset="utf-8" src="https://platform.twitter.com/js/button.1378e6a69a23712ca26755ee3c4084b4.js"></script><link type="text/css" rel="stylesheet" charset="UTF-8" href="https://translate.googleapis.com/translate_static/css/translateelement.css"></head>
	<body style="" class="">
	<form id="searchTxtForm">
<input type="hidden" name="viewCount" id="viewCount" value="0">
<input type="hidden" name="startCount" id="startCount" value="0">

<div class="tableList">
	<table id ="more_list">
		<caption>더보기 기능 구현하기</caption>
		<colgroup>
			<col>
			<col style="width:14.19%">
		</colgroup>
		<thead>
			<tr>
				<th scope="col">제목</th>
				<th scope="col">작성자</th>
			</tr>
		</thead>
		<tbody>
			<!-- 반복영역 -->
			<c:forEach items="${resultList}" var="resultVO" varStatus="status">
				<tr>
				<!-- 제목, 작성자 -->
					<td>${resultVO.title}</td>
					<td>${resultVO.reg_date}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<div id="more_btn_div" align="center">
	<hr>
		<a id="more_btn_a" href="javascript:moreContent('more_list', 10);" >
			더보기(More)
		</a>
	<hr>
	</div>
</div>
</form>


<script>

 function moreContent(id, cnt){
    	
    	var list_length = $("#"+id+" tr").length-1; //tr갯수 구하기 , 1을 빼는 이유는 제목,작성자 tr이 하나 존재하기 때문.
    	var aname = id+"_btn";
    	var callLength = list_length;
    	
    	$('#startCount').val(callLength);
    	$('#viewCount').val(cnt);
    	
   	    $.ajax({
   	        type    :   "post",
   	        url     :   "/getMoreContents_ajax.do",
   	        data    :   $('#searchTxtForm').serialize(),
   	        dataType:   "json",
   	        success :   function(result) {
   	                       if(result.resultCnt > 0){
   	                    	   var list = result.resultList;
   	                    		   if(resultVO.title != '') {
   	                    			 $('#'+aname).attr('href',"javascript:moreContent('"+id+"', "+cnt+");");
   	                    			   getMoreList(list);
   	                    		   }else{
   	                    			$("#"+id+"_div").remove();
   	                    		   }
   	                    	   }
   	                       }
   	                 
   	     
   	    });
 };
   	    function getMoreList(list){
   	    	
   	    	var content = "";
   	    	var length = list.length;
   	    	for(i=0; i<list.length; i++){
   	    		var resultVO = list[i];
   	    		if(resultVO.title != ''){
	   	    		content += "<tr>";
	   	   	    	content += "<td>"+resultVO.title+"</td>";
	   	   	    	content += "<td>"+resultVO.reg_date+"</td>";
	   	 	    	content += "</tr>";
   	    		}
   	    	}
   	    	 $("#more_list tr:last").after(content); 
             // id가 more_list 인 tr의 마지막에 content 값을 추가함
   	    }

</script></body></html>