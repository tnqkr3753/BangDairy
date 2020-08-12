<%@page import="com.kosmo.bangdairy.vo.GenreVO"%>
<%@page import="com.kosmo.bangdairy.vo.IndieGenreVO"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
<!--- 아이콘가지고오는 링크 fa fa-twier 등등
    ================================================== -->
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">





    <!--- basic page needs
    ================================================== -->
    <meta charset="utf-8">
    <title>Philosophy</title>
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- mobile specific metas
    ================================================== -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <!-- resources/css
    ================================================== -->
    
    
    <link rel="stylesheet" href="resources/css/base.css">
    <link rel="stylesheet" href="resources/css/vendor.css">
    
    <link rel="stylesheet" href="resources/css/main.css">
	<link rel="stylesheet" href="resources/css/independent.css">
	
    <!-- script
    ================================================== -->
    <script src="resources/js/modernizr.js"></script>
    <script src="resources/js/pace.min.js"></script>


    <!-- favicons
    ================================================== -->
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="icon" href="favicon.ico" type="image/x-icon">


<script src="https://code.jquery.com/jquery-1.11.3.js"></script> 




</head>


<body id="top">

    <!-- pageheader
    ================================================== -->
    
 <%@ include file = "../../../header_menu.jsp" %>









 <section class="s-content">
<form  id="frm"  method='post' action="indieinsert" enctype="multipart/form-data" >
			<div class="distribution"  style="display: block" id="box" >
				<h4>신청인</h4>
				<table class="">
				  <colgroup><col width="130px"><col width=""></colgroup>
				  
				  <tbody>
				  
				  <tr>
				  
					<th>감독</th>
				    <td><input type="text" name="indieDirector" id="distri_name"  class="type01" style="width:120px;" msg="감독을" maxlen=10> </td>
				  <td><input type="hidden" name=indieConfirm value="y"></td>
				  </tr>
				   <tr>
					<th>배우</th>
					 <td id=actorbutton>
				  <input type="text"  class="type01" name="indieActor" style="width:70px" msg="배우를" >
				  	  </td>

				  </tr> <td> <p style="cursor:pointer"><img src="resources/images/add.ico" id="makebtn" class="reMove" style="width:60px" title="추가"></p></td><td><p style="cursor:pointer"><img src="resources/images/add.ico" id="reMOve" class="reMove" style="width:60px" title="삭제"></td>
				 
				 
 			
<!-- 		<td><input id="profile_img" type="file" name='indiePosterAddr' value="" accept="image/gif,image/jpg,image/png" onchange="chk_file_type(this)" > -->
				  </tbody>		   
				  
				   
				<!--   <tr>
					<th>e-mail</th>
				   <td><input type="text" name="distri_email" id="distri_email" class="type01" style="width:30%;" msg="이메일을"> </td>
				  </tr>
				  <tr>
					<th>핸드폰</th>
				    <td>
					  <select title="통신사번호 선택" style="width:10%;" id="distri_phone1" name="distri_phone1" >
		                <option value="">선택</option>
		                <option value="010" selected="">010</option> 
		                <option value="011">011</option>
		                <option value="016">016</option>
		                <option value="017">017</option>
		                <option value="018">018</option>
		                <option value="019">019</option>                         
		              </select> -
		              <input type="text" name="distri_phone2" id="distri_phone2" title="휴대전화 중간자리 입력"  maxlength="4" class="type01" style="width:10%;" msg="번호를" onkeydown="onlyNumber(this)"> -
		              <input type="text" name="distri_phone3" id="distri_phone3" title="휴대전화 마지막자리 입력"  maxlength="4" class="type01" style="width:10%;" msg="번호를" onkeydown="onlyNumber(this)">
					</td>
				  </tr> -->
			</table>
				
				<h4>작품정보</h4>
				<table class="">
				  <colgroup><col width="130px"><col width=""></colgroup>
				  <tbody><tr>
		<th>제목</th>
				    <td><input type="text" name="indieTitle"  id="distri_movie_subject" class="type01" style="width:120px;" msg="제목을" msg="감독을" maxlen=20> </td>
				  </tr>
			      <tr>
		<th>키워드</th>
				  <td id=actorbu>
				  <input type="text" name="indieKeyword" class="type01 " style="width:70px" msg="키워드를" maxlen="10">
				  </td>
				  </tr> 	
	              <td><p style="cursor:pointer"><img src="resources/images/add.ico" id="makeky" style="width:60px" title="추가"></p></td><td><p style="cursor:pointer" title="추가"><img src="resources/images/add.ico" id="removeky" class="reMove" style="width:60px" title="삭제"></td>


		          <tr>
		<th>작품링크</th>
				   <td><input type="text" name="indieAddr"  class="type01" style="width:30%;"msg="작품징크" > 예) https://www.youtube.com/watch?v=My9OW-W2Jso</td>
				  </tr>
				  
				  
				  
				  
				  
				  
		<th>나라</th>
				
				    <td><input type="text" name="indieCountry" id="distri_movie_lang" class="type01" style="width:60px;" msg="언어/자막언어를"> </td>
				  </tr>	
				  <tr>
				  <th>장르</th>
				<td id="ganre"><!-- GenreVO 에 있는 db값을 없어와서 옵션에 넣어준다. -->
				<% List<GenreVO> result =  (List<GenreVO>)request.getAttribute("result"); %>
						<select title="장르" style="width:80px;" name="genreId" id="genreTitle">
						<% for (GenreVO vo : result){ %>
							<option value=<%=vo.getGenreTitle()%>><%=vo.getGenreTitle() %></option>     
						<%}; %>  
		              </select>
		             
					</td>
              </tr>
              	  <tr> 
				 <th>포스터url</th>
				   <td><input  type="file" name='file' msg="포스터를" class="type01"></td>
				  </tr>
				    <tr>
					<th>만든날짜</th>
				 <td><input type="text" name="indieMakedate" autocomplete="off" placeholder="yyyy-mm-dd" class="type01" style="width:120px;"> 
				  </tr>
          
				  <tr>
				  
					<th>줄거리</th>
				    <td><textarea name="indiePlot"   id="distri_movie_direct" rows="5" style="width:100%;" cols="" msg="연출의도를" maxlen=1000></textarea> </td>
				  </tr>   
				 
				  
				</tbody></table>
			</div></form>

<p class="r pr10 pt10"><a href="javascript:fn_submit()"><button style="margin-left:80%">신청하기</button></a></p>

  
 </section>





 <%@ include file="../../../footer.jsp" %> 
    <!-- Java Script
    ================================================== -->

    <script src="resources/js/plugins.js"></script>
   <script src="resources/js/main.js"></script>
      <script src="resources/js/j.independent.js"></script>
<script src="resources/js/j.checkForm.js"></script>
<script src="resources/js/j_ajax.js"></script>
</body>

</html>