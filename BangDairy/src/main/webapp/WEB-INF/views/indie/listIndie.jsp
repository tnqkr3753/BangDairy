<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="com.kosmo.bangdairy.vo.IndieVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>

<!--- basic page needs
    ================================================== -->
<meta charset="utf-8">
<title>Video Post Format - Philosophy</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- mobile specific metas
    ================================================== -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- CSS
    ================================================== -->
    
<link rel="stylesheet" href="resources/css/base.css">
<link rel="stylesheet" href="resources/css/vendor.css">
<link rel="stylesheet" href="resources/css/main.css">
<link rel="stylesheet" href="resources/css/movieList.css">


<!-- script
    ================================================== -->
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="resources/js/modernizr.js"></script>
<script src="resources/js/pace.min.js"></script>

<!-- favicons
    ================================================== -->
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<link rel="icon" href="favicon.ico" type="image/x-icon">

<!-- jquery lib import -->

</head>

<body id="back">
	<%@ include file="../../../header_menu.jsp"%>

	<!-- s-content
    ================================================== -->


	
<div id="movie-list">
		<!-- end row comments -->
	<div class="row">
	<div class="col-full">
		<nav class="pgn">
		
			<!-- ********** 페이징 ********** -->
		<%-- 	<c:if test="${totalPage < 5}"> --%>
				<!-- 전체페이지 수가 5보다 작을때 -->
				<c:forEach var="i" begin="1" end="5">
					<button class="btnPaging" value='${i}'>${i}</button>
					
				</c:forEach>
		<%-- 	</c:if> --%>

<%-- 			<c:if test="${totalPage >= 5}">
				<!-- 전체페이지 수가 5보다 클때 -->
				<c:if test="${pNum == 1}">
					<!-- 현재 페이지가 1페이지일때 뒤 4개의 페이지 보여줌 -->
					<c:forEach var="i" begin="${pNum}" end="${pNum+4}">
					
						<button class="btnPaging" value='${i}'>${i}</button>
					</c:forEach>
				</c:if>
				<c:if test="${pNum == 2}">
					<!-- 현재 페이지가 2페이지일때 1페이지, 뒤 3개의 페이지 보여줌 -->
					<c:forEach var="i" begin="${pNum-1}" end="${pNum+3}">
						<button class="btnPaging" value='${i}'>${i}</button>
					</c:forEach>
				</c:if>
				<c:if test="${pNum >= 3 and pNum <= totalPage-2}">
					<!-- 현재 페이지가 3페이지 이상일때 앞 2개, 뒤 2개의 페이지 보여줌 -->
					<c:forEach var="i" begin="${pNum-2}" end="${pNum+2}">
						<button class="btnPaging" value='${i}'>${i}</button>
					</c:forEach>
				</c:if>
				<c:if test="${pNum == totalPage-1}">
					<c:forEach var="i" begin="${pNum-3}" end="${pNum+1}">
						<!-- 현재 페이지가 마지막 페이지-1일때 -->
						<button class="btnPaging" value='${i}'>${i}</button>
					</c:forEach>
				</c:if>
				<c:if test="${pNum == totalPage}">
					<!-- 현재 페이지가 마지막 페이지일때 -->
					<c:forEach var="i" begin="${pNum-4}" end="${pNum}">
						<button class="btnPaging" value='${i}'>${i}</button>
					</c:forEach>
				</c:if>
			</c:if> --%>
			<!-- ********** 페이징 ********** -->

<%-- 			<c:if test="${totalPage > 5 and pNum < totalPage-2}"> --%>
				<!-- 전체 페이지의 개수 표시 -->
			... <button class="btnPaging" value='${totalPage}'>${totalPage}</button>
<%-- 			</c:if> --%>
		</nav>
	</div>
</div>
	</div>
	<!-- end comments-wrap -->
	<!-- Comments END -->

	<%@ include file="../../../footer.jsp"%>

<script type="text/javascript">



		</script>
		


	<!-- Java Script
    ================================================== -->
	
<script src="resources/js/j_ajax.js"></script>
	<script src="resources/js/plugins.js"></script>
	<script src="resources/js/main.js"></script>
	
	 <script src="resources/js/j.independent.js"></script>
	 <script type="text/javascript">
		$(function(){
			getPage(1,'all');
			});
	 </script>
</body>

</html>