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
<%@ include file="../../../account_form.jsp"%>
<%@ include file="../../../Sign_In.jsp"%>


 <section class="s-content">
<form name="frm" id="frm" method="GET" action="indieinsert"  enctype="Multipart/form-data">
			<div class="distribution" title="배급신청" style="display: block" id="box" >
				<h4>신청인</h4>
				<table class="">
				  <colgroup><col width="130px"><col width=""></colgroup>
				  <tbody>
				  <tr>
					<th>감독</th>
				    <td><input type="text" name="indieDirector"  class="type01" style="width:30%;" msg="감독을"> </td>
				  </tr>
				   
				  
				   
				<!--   <tr>
					<th>e-mail</th>
				   <td><input type="text" name="distri_email" id="distri_email" class="type01" style="width:30%;" msg="이메일을"value="123"> </td>
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
		              <input type="text" name="distri_phone2" id="distri_phone2" title="휴대전화 중간자리 입력" value="123" maxlength="4" class="type01" style="width:10%;" msg="번호를" onkeydown="onlyNumber(this)"> -
		              <input type="text" name="distri_phone3" id="distri_phone3" title="휴대전화 마지막자리 입력" value="123" maxlength="4" class="type01" style="width:10%;" msg="번호를" onkeydown="onlyNumber(this)">
					</td>
				  </tr> -->
				</tbody></table>
				
				<h4>작품정보</h4>
				<table class="">
				  <colgroup><col width="130px"><col width=""></colgroup>
				  <tbody><tr>
					<th>한글제목</th>
				    <td><input type="text" name="indieTitle" id="distri_movie_subject" class="type01" style="width:20%;" msg="한글제목을"> </td>
				  </tr>
				  <tr>
				   	<th>포스터url</th>
				    <td><input type="text" name="indiePosterAddr"  class="type01" style="width:60%"; msg="포스터 url">ex :  http://www.indieforbunnies.com/wp-content/uploads/2019/10/indie-846x423.jpg </td>
				  </tr>
<!-- 				  <tr> -->
<!-- 					<th>영문제목</th> -->
<!-- 				   <td><input type="text" value="123"name="distri_movie_esubject" id="distri_movie_esubject" class="type01" style="width:20%;" msg="영문제목을"> </td> -->
<!-- 				  </tr> -->
<!-- 				  <tr> -->
<!-- 					<th>장편/단편</th> -->
<!-- 				    <td> -->
<!-- 						<select title="장편/단편 선택" style="width:20%;" name="distri_movie_type" id="distri_movie_type"> -->
<!-- 							<option value="long" selected="">장편</option>  -->
<!-- 							<option value="short">단편</option>                       -->
<!-- 		              </select> -->
<!-- 					</td> -->
<!-- 				  </tr> -->
<!-- 				  <tr> -->
<!-- 					<th>길이</th> -->
<!-- 				   <td><input type="text" name="distri_movie_length1"value="123" id="distri_movie_length1" class="type01" style="width:10%;" msg="분을" onkeydown="onlyNumber(this)"> 분&nbsp;&nbsp;  <input type="text" value ="423"name="distri_movie_length2" id="distri_movie_length2" class="type01" style="width:10%" msg="초를" onkeydown="onlyNumber(this)"> 초 </td> -->
<!-- 				  </tr> -->
				  <tr>
					<th>업데이트날짜</th>
				   <td>
<!-- 				   <input type="text" name="indieMakedate " value="123"id="distri_movie_year" class="type01" style="width:10%;"msg="제작년도를" onkeydown="onlyNumber(this)"> 년&nbsp;&nbsp;   -->
<!-- 				   <input type="text" name="indieMakedate"value ="423" id="distri_movie_month" class="type01" style="width:10%;" msg="제작월을" onkeydown="onlyNumber(this)"> 월  -->
<!-- 				   <input type="text" name="indieMakedate"value ="423" id="distri_movie_day" class="type01" style="width:10%;" msg="제작일을" onkeydown="onlyNumber(this)"> 월  -->
				   </td>
				  </tr>
				  
			  <tr>
					<th>키워드?</th>
				   <td>
				  <input type="text" name="indieKeyword" value="123"class="type01" style="width:5%;">
				  <input type="text" name="indieKeyword" value="123"class="type01" style="width:5%;">
				  <input type="text" name="indieKeyword" value="123"class="type01" style="width:5%;">
				  </td>
				  </tr> 
				  <tr>
					<th>작품링크</th>
				   <td><input type="text" name="indieAddr" value="123" class="type01" style="width:30%;"msg="작품징크" > 예) https://www.youtube.com/watch?v=My9OW-W2Jso</td>
				  </tr>
<!-- 				  <tr> -->
<!-- 					<th>제작포맷</th> -->
<!-- 				    <td><input type="text" name="distri_movie_mformat" value="123"id="distri_movie_mformat" class="type01" style="width:30%;" msg="제작포맷을"></td> -->
<!-- 				  </tr> -->
				  <!-- <tr>
					<th>상영포맷</th>
				    <td><input type="text" name="distri_movie_sformat" id="distri_movie_sformat" class="type01" style="width:380px;"/>&nbsp;&nbsp; 제작포맷과 다른 경우 </td>
				  </tr> -->
				  <tr>
					<th>나라</th>
				    <td><input type="text" name="indieCountry" id="distri_movie_lang" class="type01" style="width:20%;" msg="언어/자막언어를"> </td>
				  </tr>
<!-- 				  <tr> -->
<!-- 					<th>컬러/흑백</th> -->
<!-- 				    <td><input type="text" name="distri_movie_color" value="123"id="distri_movie_color" class="type01" style="width:20%;" msg="컬러/흑백을"> </td> -->
<!-- 				  </tr> -->
				  
				  <th>장르</th>
				
				<td id="ganre"><!-- GenreVO 에 있는 db값을 없어와서 옵션에 넣어준다. -->
				<% List<GenreVO> result =  (List<GenreVO>)request.getAttribute("result"); %>
						<select title="장르" style="width:80px;" name="genreId" id="genreTitle">
						<% for (GenreVO vo : result){ %>
							<option value=<%=vo.getGenreTitle()%>><%=vo.getGenreTitle() %></option>     
						<%}; %>  
		              </select>
		              <select title="장르" style="width:80px;" name="genreId" id="genreTitle">
						<% for (GenreVO vo : result){ %>
							<option value=<%=vo.getGenreTitle()%>><%=vo.getGenreTitle() %></option>     
						<%}; %>  
		              </select>
					</td>
              
				  <tr>
					<th>연출의도 plot</th>
				    <td><textarea name="indiePlot" id="distri_movie_direct" rows="5" style="width:100%;" cols="" msg="연출의도를"></textarea> </td>
				  </tr> 
				   
				  
				   
		
			
				                                
<!-- 				  <tr> -->
<!-- 					<th>영화제 상영리스트</th> -->
<!-- 				    <td><textarea name="distri_movie_festival" id="distri_movie_festival" rows="5" style="width:100%;" cols="" msg="영화제 상영리스트를"></textarea> </td> -->
<!-- 				  </tr>	 -->
<!-- 				  <tr> -->
<!-- 					<th>작품 링크</th>  -->
<!-- 				    <td><input type="text" name="movie_link" id="movie_link" class="type01" style="width:100%;"" value="">&nbsp; 예) http://www.naver.com</td>  -->
<!-- 				  </tr> -->
				  <tr>
					<th>비고</th> 
				    <td>
						<textarea name="movie_note" id="movie_note" rows="5"></textarea><br>
						<span class="tt02" style="display:none;">* 장편의 경우 작품 기획서를 doona@indiestory.com 으로 보내주시기 바랍니다.</span>
					</td> 

				  </tr>
				</tbody></table>

			
				<p class="r pr10 pt10"><a href="javascript:fn_submit()"><img src="resources/images/아이유.jpg" alt=""></a></p>				

			</div></form>


 </section>


  



<%@ include file="../../../footer.jsp" %>
    <!-- Java Script
    ================================================== -->

    <script src="resources/js/plugins.js"></script>
   <script src="resources/js/main.js"></script>
      <script src="resources/js/j.independent.js"></script>
<script src="resources/js/j.checkForm.js"></script>

</body>

</html>