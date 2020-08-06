<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>

<!-- AJAX SUCCESS 시 붙일 부분 -->
<select id="recommendSelect">
	<option>영화를 선택해주세요.</option>
	<c:forEach items="${rList}" var="list">
		<!-- 키워드에 따라 검색해온 영화제목 리스트 뿌려줌 -->
		<option>${list.movieTitle} [${list.movieId}]</option>
	</c:forEach>
</select>

<script type="text/javascript">

$(document).ready(function() {
	$("#recommendSelect").change(function() {	// 셀렉트 박스가 변경되면
		// alert("변경");
		var selectValue = $(this).val();
		//alert(selectValue);
		
		// '영화를 선택해주세요'이면 영화 제목 input value 값 없애줌
		if (selectValue != "영화를 선택해주세요.") {
			$("#movieTitle").val(selectValue);
		} else {
			$("#movieTitle").val("");
		}
	});
});

</script>