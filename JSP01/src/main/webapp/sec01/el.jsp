<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EL 예제</title>
	</head>
	<body>
		\${100} : ${100 }<br>
		${3.14}<br>
		${"홍길동"}<br>
		${true }<br>
		${true&&true }<br>
		${10+1}<br>
		${100 mod 9}<br>
		<%-- ${"hello" + "world"}<br><!-- 주의 !! 문자열 연산 안 됨 (오류) --> --%>
	</body>
</html>