<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<table border="1">
		<h3>회원 정보 조회</h3>
			<tr align="center" bgcolor="gold"><th>학번</th><th>성명</th><th>전화</th><th>주소</th><th>학년</th></tr>
			<c:forEach var="data" items="${memList }">
				<tr><td>${data.id }</td>
						<td>${data.pwd }</td>
						<td>${data.name }</td>
						<td>${data.email }</td>
						<td>${data.joinDate }</td></tr>
			</c:forEach>
		</table>
	</body>
</html>