<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.nexacro17.xapi.data.DataTypes"%>
<%@ page import="com.nexacro17.xapi.tx.PlatformType"%>
<%@ page import="com.nexacro17.xapi.tx.HttpPlatformResponse"%>
<%@ page import="com.nexacro17.xapi.data.PlatformData"%>
<%@ page import="com.nexacro17.xapi.data.DataSet"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.kosmo.bangdairy.vo.AccountFormVO"%>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	DataSet ds1 = (DataSet)request.getAttribute("ds");
	PlatformData pData = new PlatformData();
	pData.addDataSet(ds1);
	HttpPlatformResponse res = 
			new HttpPlatformResponse(response,PlatformType.CONTENT_TYPE_XML,"utf-8");
	out.clear();
	out = pageContext.pushBody();
	res.setData(pData);
	res.sendData();
%>


</body>
</html>