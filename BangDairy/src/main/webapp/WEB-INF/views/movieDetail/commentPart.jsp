<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
					<c:forEach items="${list}" var="comment">
						<li class="depth-1 comment">
							<!-- <div class="comment__avatar">
								<img width="50" height="50" class="avatar"
									src="images/avatars/user-01.jpg" alt="">
							</div> -->
							<div class="comment__content">
								<div class="comment__info">
									<cite>${comment.userId}</cite><span><c:if test="${comment.receipt == 1}">영수증 인증!</c:if></span>

									<div class="comment__meta">
										
										<time class="comment__time"><fmt:formatDate value="${comment.commentRegDate }" type="both"/></time>
									</div>
								</div>
								<div class="comment__text">
									<p>${comment.comment }</p>
								</div>
								<div class="starRev">
									<c:forEach begin="1" end="${comment.commentScore }">
									<span class="starR on">별</span>
									</c:forEach>
									
								</div>
							</div>
							<hr/>
						</li>
					</c:forEach>