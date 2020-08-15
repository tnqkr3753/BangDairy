<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 세션에서 아이디 가져오기 -->
<%String userId = (String)session.getAttribute("userId");%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<div class="header_sticky">
        <header class="header">
            <div class="header__content row">

                <div class="header__logo">
                    <a class="logo" href="index.jsp">
                        <img src="/bangdairy/resources/images/123.png" alt="Homepage" >
                    </a>
                </div> <!-- end header__logo -->

				<!-- 2020-07-28 경호 수정
					  수정내용 : 로그인 시 메뉴바 아이콘 변경
				 -->
				 
                <ul class="header__social">
                	<%if (userId==null){ %>
                    <li>
                        <a id="show-login"><i class="fa fa-sign-in" id="pa" aria-hidden="true"></i>로그인</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-address-book-o" aria-hidden="true">회원가입</i></a>
                    </li>
                    
                    <%}else{ %><!-- end If -->
                    <ul class="header__nav">
                    	<li class="has-children">
                    	<a href='#'><i id='mark-user-id' class="f	a" aria-hidden="true"><%=userId%>님</i></a>
                    		<ul class="sub-menu">
	                    		<li><a href="myPage">마이 페이지</a></li>
	                    		<li><a id="logout-btn" href="#">로그아웃</a></li>
                    		</ul>
                    	</li>
                    </ul>
					<%} %>
                  
                </ul> <!-- end header__social -->
                
                <a class="header__search-trigger" href="#0"></a>

                <div class="header__search">
                    <form role="search" method="get" class="header__search-form" action="#">
                        <label>
                            <span class="hide-content">Search for:</span>
                            <input type="search" class="search-field" placeholder="2626526" value="" name="s" title="Sear:" autocomplete="off">
                        </label>
                        <input type="submit" class="search-submit" value="Search">
                    </form>
        
                    <a href="#0" title="Close Search" class="header__overlay-close">Close</a>

                </div>  <!-- end header__search -->


                <a class="header__toggle-menu" href="#0" title="Menu"><span>Menu</span></a>

                <nav class="header__nav-wrap">

                    <h2 class="header__nav-heading h6">Site Navigation</h2>

                    <ul class="header__nav">
                        <li class="current"><a href="index.jsp" title="">메인</a></li>
                        <li class="has-children">
                            <a href="#0" title="">영화</a>
                            <ul class="sub-menu">
                            <li><a href="movieList.jsp">영화정보</a></li>
                            </ul>
                        </li>
                        <li class="has-children">
                            <a href="#0" title="">다이어리</a>
                            <ul class="sub-menu">
                            <li><a href="main_dairy.jsp">다이어리 메인</a></li>
                            <li><a href="my_dairy.jsp">내 다이어리</a></li>
                            <li><a href="write_dairy.jsp">다이어리 작성</a></li>
                            </ul>
                        </li>
                        <li class="has-children">
                         <a href="#0" title="">인디극장</a>
                         
                          <ul>
                
                            <li><a href="indieList">인디영화</a></li>
                            <li><a href="Independent">신청</a></li>
                           
                            </ul>
                    <!-- end header__nav -->

                    <a href="#0" title="Close Menu" class="header__overlay-close close-mobile-menu">Close</a>

                </nav> <!-- end header__nav-wrap -->

            </div> <!-- header-content -->
        </header> <!-- header -->
        </div>
        <%@ include file="/account_form.jsp"%>
		<%@ include file="/Sign_In.jsp"%>
		<script type="text/javascript" src="/bangdairy/resources/js/account_form.js"></script
</body>
</html>>
		<script type="text/javascript" src="/bangdairy/resources/js/Sign_in.js"></script>
		<script type="text/javascript" src="/bangdairy/resources/js/search.js"></script>