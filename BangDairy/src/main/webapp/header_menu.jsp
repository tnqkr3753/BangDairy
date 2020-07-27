<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                        <img src="resources/images/123.png" alt="Homepage" >
                    </a>
                </div> <!-- end header__logo -->

                <ul class="header__social">
                    <li>
                        <a href="#0"><i class="fa fa-sign-in" id=pa aria-hidden="true"></i>로그인</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-address-book-o" aria-hidden="true">회원가입</i></a>
                    </li>
                  
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
                        <li class="current"><a href="index.jsp" title="">Home</a></li>
                        <li class="has-children">
                            <a href="#0" title="">Chart</a>
                            <ul class="sub-menu">
                            <li><a href="movieDetail.jsp">movieDetail</a></li>
                            <li><a href="movieList.jsp">movieList</a></li>
                            <li><a href="category.html">Family</a></li>
                            <li><a href="category.html">Management</a></li>
                            <li><a href="category.html">Travel</a></li>
                            <li><a href="category.html">Work</a></li>
                            </ul>
                        </li>
                        <li class="has-children">
                            <a href="#0" title="">Diary</a>
                            <ul class="sub-menu">
                            <li><a href="single-audio.jsp">다이어리 메인</a></li>
                            <li><a href="single-video.jsp">내 다이어리</a></li>
                            <li><a href="single-gallery.html">Gallery Post</a></li>
                            <li><a href="single-standard.html">Standard Post</a></li>
                            </ul>
                        </li>
                        <li class="has-children">
                         <a href="#0" title="">인디스토리</a>
                         
                          <ul>
                         	<li><a href="Independent.do">신청2</a></li>
                            <li><a href="mainIndependent.do">인d디2</a></li>
                            <li><a href="test.do">test</a></li>
                            </ul>
                    <!-- end header__nav -->

                    <a href="#0" title="Close Menu" class="header__overlay-close close-mobile-menu">Close</a>

                </nav> <!-- end header__nav-wrap -->

            </div> <!-- header-content -->
        </header> <!-- header -->
        </div>
        <%@ include file="account_form.jsp"%>
		<%@ include file="Sign_In.jsp"%>
		<script type="text/javascript" src="resources/js/account_form.js"></script>
		<script type="text/javascript" src="resources/js/Sign_in.js"></script>
		<script type="text/javascript" src="resources/js/search.js"></script>
</body>
</html>