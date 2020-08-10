<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="com.kosmo.bangdairy.vo.IndieVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

							<%	List<IndieVO> result=(List<IndieVO>)request.getAttribute("result"); %>
		<%int a=1; %>
		<% for (IndieVO vo : result){ %>
			<%
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 ");
%>				
    <tr>
      <th scope="row"><%=a %></th>
    <%-- <td><a href="#" onclick="indie_list_submit()?"> <input type="submit" name=indieid value=<%=vo.getIndieId()%>><%=vo.getIndieTitle()%></a></td> --%>
      <td><a href="indieDet?indieid=<%=vo.getIndieId()%>"><%=vo.getIndieTitle() %></a></td>
      <td><%=vo.getIndieDirector()%></td>
      <td><%=vo.getGenreId() %></td>
      <!-- vo.getIndieUpdateDate() -->
     <td ><div class="starRev" >
		<span class="starR on">별1</span> <span class="starR">별2</span>
		<span class="starR">별3</span> <span class="starR">별4</span>
		<span class="starR">별5</span>
		</div>
										</td>
										
										
										
    </tr>
  
           <%a++; %>
    <%}; %>
