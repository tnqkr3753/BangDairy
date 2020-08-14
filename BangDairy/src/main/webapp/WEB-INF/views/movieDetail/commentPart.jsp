<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
					<c:forEach items="${list}" var="comment">
						<li <c:if test="${comment.receipt eq 0}">class="depth-1 comment normal-comment" </c:if>
						<c:if test="${comment.receipt eq 1}">class="depth-1 comment receipt-comment"</c:if>>
							<div class="comment__star">
								<div class="starRevC">
									<c:forEach begin="1" end="${comment.commentScore }">
									<span class="starR on">별</span>
									</c:forEach>
								</div>
							</div>
							<!-- <div class="comment__avatar">
								<img width="50" height="50" class="avatar"
									src="images/avatars/user-01.jpg" alt="">
							</div> -->
							<div class="comment__content">
								<div class="comment__info">
									<cite>${comment.userId}</cite>
									<c:if test="${comment.receipt == 1}"><div><span class="badge badge-pill badge-danger">영수증 인증!</span></div></c:if>
									<div class="comment__meta">
										
										<time class="comment__time"><fmt:formatDate value="${comment.commentRegDate }"  type="date" dateStyle="full" /></time>
									</div>
								</div>
								<div class="comment__text">
									<p>${comment.comment }</p>
								</div>

							</div>
							<hr/>
						</li>
					</c:forEach>