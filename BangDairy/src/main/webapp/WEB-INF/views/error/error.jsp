<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <meta charset="utf-8">
    <meta name="description" content="">
    <meta name="author" content="">
    <style type="text/css">
	    #btnErrorGoIndex {
			font-family: 'Do Hyeon', sans-serif;
			font-size: 50px;
			width: 500px;
			height: 100px;
			text-transform: uppercase;
			letter-spacing: 2.5px;
			font-weight: 500;
			color: white;
			background-color: black;
			border: none;
			border-radius: 45px;
			box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
			transition: all 0.3s ease 0s;
			cursor: pointer;
			outline: none;
		}

		#btnErrorGoIndex:hover {
			background-color: #ffa500;
			box-shadow: 0px 15px 20px gray;
			color: white;
			transform: translateY(-7px);
		}
    </style>
    <link rel="stylesheet" href="/bangdairy/resources/css/dairycss/writeDiary.css">
</head>

<body>
	<div style="text-align: center;">
		<img src="/bangdairy/resources/images/error/error.png"
			style="width: 40%; text-align: center; margin:100px;" />
	</div>
	<div style="text-align: center;">
		<input type="button" onclick="location.href='/bangdairy/index.jsp' " id="btnErrorGoIndex" value="홈으로 이동하기" />
	</div>
</body>

</html>