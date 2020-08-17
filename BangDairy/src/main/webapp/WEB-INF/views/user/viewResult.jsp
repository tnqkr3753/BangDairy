<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찾기 결과</title>
<!-- ========== css ============= -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<!-- ========== script ============= -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	
<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap');

table {
	font-family: 'Do Hyeon', sans-serif;
	font-size: 25px;
	text-align: center;
}
</style>

</head>
<body>
	<div class="table-responsive">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>결과</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${content }</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>