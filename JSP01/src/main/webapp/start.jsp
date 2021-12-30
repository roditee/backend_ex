<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>start</title>
	</head>
	<body>
		JSP 환영합니다 <br><br>
		
		<%
			out.println("JSP를 시작합니다.");
		%>
		
		<br> 여기는 HTML 영역
		
		<%
			out.println("<br>여기는 JSP 영역");
		%>
	</body>
</html>