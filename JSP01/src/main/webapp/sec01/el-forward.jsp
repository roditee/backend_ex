<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EL 바인딩 예제</title>
	</head>
	<body>
		<%
			// setAttribute("속성명", "속성값")   // 속성명 = 바인딩 되는 변수 이름
			request.setAttribute("id", "hong");
			request.setAttribute("pwd", "1234");
			request.setAttribute("name", "홍길동");
			request.setAttribute("email", "hong@test.com");
		%>
		<!-- 받는 페이지에서는 setAttribute의 첫번째 파라미터 값만 가지고도 값 가져올 수 있음 -->
		<jsp:forward page="el-forward-result.jsp" />
	</body>
</html>