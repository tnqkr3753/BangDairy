<%@page import="java.util.List"%>
<%@page import="com.kosmo.bangdairy.vo.DairyVO"%>
<%@page import="com.kosmo.bangdairy.vo.MovieVO"%>
<%@page import="com.kosmo.bangdairy.vo.WishMovieVO"%>
<%@page import="com.kosmo.bangdairy.vo.DairyUserVO"%>
<%@page import="com.kosmo.bangdairy.vo.AccountFormVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>				

							<c:forEach items="${otherdddlist }" var="diy">
							
								<div class="likehate">
								<input type="hidden" id="aaa" value="${diy.diary_id}">								
								<button id="btnDiaryLike" style="float: left; margin-left: 60%;" type="submit" >
									좋아요 ${diy.likehit }<i class="fa fa-thumbs-up"></i>
								</button>

								<button id="btnDiaryHate" style="float: right;" type="submit" id="btnDiaryHate">
									싫어요 ${diy.hatehit }<i class="fa fa-thumbs-down"></i>
								</button>
							
							</div>
							</c:forEach>
			
						
<script >

