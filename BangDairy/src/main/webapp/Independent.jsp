<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
<!--- 아이콘가지고오는 링크 fa fa-twier 등등
    ================================================== -->
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">


<!--- bx슬라이더
    ================================================== -->



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

    		<%@ include file="header_menu.jsp"%>

 <section class="s-content">
<form name="frm" id="frm" method="get" action="index.jsp">
			<div class="distribution" title="배급신청" style="display: block;" id="box">
				<h4>신청인</h4>
				<table class="">
				  <colgroup><col width="130px"><col width=""></colgroup>
				  <tbody><tr>
					<th>감독</th>
				    <td><input type="text" name="distri_name" id="distri_name" class="type01" style="width:150px;" msg="감독을"value="123"> </td>
				  </tr>
				  <tr>
					<th>e-mail</th>
				   <td><input type="text" name="distri_email" id="distri_email" class="type01" style="width:300px;" msg="이메일을"value="123"> </td>
				  </tr>
				  <tr>
					<th>핸드폰</th>
				    <td>
					  <select title="통신사번호 선택" style="width:80px;" id="distri_phone1" name="distri_phone1" >
		                <option value="">선택</option>
		                <option value="010" selected="">010</option> 
		                <option value="011">011</option>
		                <option value="016">016</option>
		                <option value="017">017</option>
		                <option value="018">018</option>
		                <option value="019">019</option>                         
		              </select> -
		              <input type="text" name="distri_phone2" id="distri_phone2" title="휴대전화 중간자리 입력" value="123" maxlength="4" class="type01" style="width:80px;" msg="번호를" onkeydown="onlyNumber(this)"> -
		              <input type="text" name="distri_phone3" id="distri_phone3" title="휴대전화 마지막자리 입력" value="123" maxlength="4" class="type01" style="width:80px;" msg="번호를" onkeydown="onlyNumber(this)">
					</td>
				  </tr>
				</tbody></table>
				
				<h4>작품정보</h4>
				<table class="">
				  <colgroup><col width="130px"><col width=""></colgroup>
				  <tbody><tr>
					<th>한글제목</th>
				    <td><input type="text" value="123"name="distri_movie_subject" id="distri_movie_subject" class="type01" style="width:500px;" msg="한글제목을"> </td>
				  </tr>
				  <tr>
					<th>영문제목</th>
				   <td><input type="text" value="123"name="distri_movie_esubject" id="distri_movie_esubject" class="type01" style="width:500px;" msg="영문제목을"> </td>
				  </tr>
				  <tr>
					<th>장편/단편</th>
				    <td>
						<select title="장편/단편 선택" style="width:80px;" name="distri_movie_type" id="distri_movie_type">
							<option value="long" selected="">장편</option> 
							<option value="short">단편</option>                      
		              </select>
					</td>
				  </tr>
				  <tr>
					<th>길이</th>
				   <td><input type="text" name="distri_movie_length1"value="123" id="distri_movie_length1" class="type01" style="width:50px;" msg="분을" onkeydown="onlyNumber(this)"> 분&nbsp;&nbsp;  <input type="text" value ="423"name="distri_movie_length2" id="distri_movie_length2" class="type01" style="width:50px;" msg="초를" onkeydown="onlyNumber(this)"> 초 </td>
				  </tr>
				  <tr>
					<th>제작년도</th>
				   <td><input type="text" name="distri_movie_year" value="123"id="distri_movie_year" class="type01" style="width:50px;" msg="제작년도를" onkeydown="onlyNumber(this)"> 년&nbsp;&nbsp;  <input type="text" name="distri_movie_month"value ="423" id="distri_movie_month" class="type01" style="width:50px;" msg="제작월을" onkeydown="onlyNumber(this)"> 월 </td>
				  </tr>
				  <tr>
					<th>제작포맷</th>
				    <td><input type="text" name="distri_movie_mformat" value="123"id="distri_movie_mformat" class="type01" style="width:380px;" msg="제작포맷을"></td>
				  </tr><input type="hidden" name="distri_movie_sformat" id="distri_movie_sformat">
				  <!-- <tr>
					<th>상영포맷</th>
				    <td><input type="text" name="distri_movie_sformat" id="distri_movie_sformat" class="type01" style="width:380px;"/>&nbsp;&nbsp; 제작포맷과 다른 경우 </td>
				  </tr> -->
				  <tr>
					<th>언어/자막언어</th>
				    <td><input type="text" name="distri_movie_lang" value="123"id="distri_movie_lang" class="type01" style="width:380px;" msg="언어/자막언어를"> </td>
				  </tr>
				  <tr>
					<th>컬러/흑백</th>
				    <td><input type="text" name="distri_movie_color" value="123"id="distri_movie_color" class="type01" style="width:380px;" msg="컬러/흑백을"> </td>
				  </tr>
				  <tr>
					<th>장르</th>
				    <td><input type="radio" name="distri_movie_genre"value="123" id="distri_movie_genre" value="1"> 극영화&nbsp;&nbsp; <input type="radio" name="distri_movie_genre" id="distri_movie_genre" value="2"> 실험영화&nbsp;&nbsp; <input type="radio" name="distri_movie_genre" id="distri_movie_genre" value="3"> 다큐멘터리&nbsp;&nbsp; <input type="radio" name="distri_movie_genre" id="distri_movie_genre" value="4"> 애니메이션</td>
				  </tr>
				  <tr>
					<th>시놉시스</th>
				    <td><textarea name="distri_movie_synop" id="distri_movie_synop" rows="5" cols="" msg="시놉시스를"></textarea> </td>
				  </tr>
				  <tr>
					<th>연출의도</th>
				    <td><textarea name="distri_movie_direct" id="distri_movie_direct" rows="5" cols="" msg="연출의도를"></textarea> </td>
				  </tr>
				  <tr>
					<th>영화제 상영리스트</th>
				    <td><textarea name="distri_movie_festival" id="distri_movie_festival" rows="5" cols="" msg="영화제 상영리스트를"></textarea> </td>
				  </tr>	
				  <tr>
					<th>작품 링크</th> 
				    <td><input type="text" name="movie_link" id="movie_link" class="type01" style="width:425px;" value="">&nbsp; 예) http://www.naver.com</td> 
				  </tr>
				  <tr>
					<th>비고</th> 
				    <td>
						<textarea name="movie_note" id="movie_note" rows="5"></textarea><br>
						<span class="tt02" style="display:none;">* 장편의 경우 작품 기획서를 doona@indiestory.com 으로 보내주시기 바랍니다.</span>
					</td> 

				  </tr>
				</tbody></table>

				<h4>사용음악</h4>
				<table class="music_table">
				  <colgroup><col width=""><col width="20%"><col width="13%"><col width="15%"><col width="11%"><col width="15%"><col width="8%"></colgroup>
				  <thead>
					  <tr>
						<th>곡명</th>
						<th>작곡자/작사자/편곡자</th>
						<th>연주자</th>
						<th>음반제목/음반사</th>
						<th>사용시간<br>예) 75분</th>
						<th>저작권허락유무</th>
						<th>추가/삭제</th>
					  </tr>
				  </thead>
				  <tbody id="music_tbody">

					  <tr id="seq_1">
						<td><input type="text" value="123"name="music_title[]" class="type02" style="width:100%;"> </td>
						<td><input type="text" value="123"name="music_writer[]" class="type02" style="width:100%;"> </td>
						<td><input type="text" value="123"name="music_player[]" class="type02" style="width:100%;"> </td>
						<td><input type="text" value="123"name="music_album_title[]" class="type02" style="width:100%;"> </td>
						<td><input type="text" value="123"name="music_time[]" class="type02" style="width:100%;"> </td>
						<td>
							<select title="저작원" style="width:100%;" name="music_copyright" id="music_copyright">
								<option value="예" selected="">유</option> 
								<option value="아니오">무</option>                      
							</select>
						</td>
						<td class="c"><a href="javascript:fn_Choice()"><i class="fa fa-plus-square-o fa-2x" aria-hidden="true"></i></a></td>
					  </tr>

				  </tbody>
				</table>
				<p class="r pr10 pt10"><a href="javascript:fn_submit()"><img src="resources/images/아이유.jpg" alt=""></a></p>				

			</div></form>


 </section>


		<%@ include file="footer.jsp"%>


    <!-- preloader
    ================================================== -->
    <div id="preloader">
        <div id="loader">
            <div class="line-scale">
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
    </div>


    <!-- Java Script
    ================================================== -->

    <script src="resources/js/plugins.js"></script>
   <script src="resources/js/main.js"></script>
      <script src="resources/js/j.independent.js"></script>
<script src="resources/js/j.checkForm.js"></script>

</body>

</html>