<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
					<c:forEach items="${list}" var="comment">
						<li class="depth-1 comment">
							<!-- <div class="comment__avatar">
								<img width="50" height="50" class="avatar"
									src="images/avatars/user-01.jpg" alt="">
							</div> -->
							<div class="comment__content">
								<div class="comment__info">
									<cite>${comment.userId}</cite>

									<div class="comment__meta">
										<time class="comment__time">${comment.commetRegDate }</time>
									</div>
								</div>
								<div class="comment__text">
									<p>${comment.comment }</p>
								</div>
							</div>
						</li>
					</c:forEach>