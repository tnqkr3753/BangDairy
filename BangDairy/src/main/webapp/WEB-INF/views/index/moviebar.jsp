<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 영화 리스트 시작 -->
<div class="row masonry-wrap"  >
       
        <span class=title>${title }</span>
        <br/> 
 		<div class="bxslider" id="stastistical-part"> 
         <c:if test="${not empty vo.posterAddr }"></c:if>
        	
			<c:forEach items="${list }" var="vo"><!-- forEach 시작  -->
            <div class="masonry"style="background-color: black">
                <div class="grid-sizer">
             		<article class="masonry__brick entry format-standard" data-aos="fade-up" style="background-color: black">
                    	<div class="entry__thumb" style="background-color: black" >
                    		<input type="hidden" value="${vo.movieId }" class="movieId">
	                        <a href="#" class="entry__thumb-link" >
	                        <img src="${vo.posterAddr }" class="entry__thumb-link1"
	                                    <c:if test="${not empty vo.posterAddr }">
	                                    srcset="${vo.posterAddr } 1x" </c:if>
	                                    <c:if test="${empty vo.posterAddr }">
	                                    srcset="resources/images/thumbs/default_movie.png 1x" </c:if>
	                                    alt="" onerror="resources/images/thumbs/default_movie.png">
	                    	</a>
                    	</div>
    
    					<div class="board" style="background-color: black">
  
  
		                    <div class="entry__text" style="background-color: black">
		                        <div class="entry__header" style="background-color: black">
                            		<h1 class="entry__title"><a href="Independent.do"><p class=rr>${vo.movieTitle}</p></a></h1>
                            	</div>
                         		<div class="entry__date" style="background-color: black">
                               		<a href="#"><div  align="right">${vo.viewingClass }</div></a>
                            	</div>
                        		<div class="entry__excerpt" style="background-color: black">
                        		</div>
		                        <div class="entry__meta" style="background-color: black">
		                            <span class="entry__meta-links">
		                                 <a href="https://www.naver.com/"><span><i class="fa fa-play-circle-o fa-2x " aria-hidden="true"title="예고편시청"></i></spen></a>
		                                <!-- 아이콘 색 변경하려면  -->
		                                <a href="#0" style="color:red"><span><i class="fa fa-heart fa-2x" aria-hidden="true"title="좋아요"></i></spen></a>
		                            </span>
		                        </div>
                         	</div>
                         
                         	</div>
                         </article>
                    </div>
				</div>
	            </c:forEach><!-- forEach 끝  -->
			</div>
		</div>
                 <!-- 영화 리스트 끝 -->