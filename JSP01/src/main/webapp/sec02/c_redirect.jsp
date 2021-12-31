<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>c:redirect</title>
	</head>
	<body>
		<c:redirect url="c_redirect-result.jsp">
			<c:param name="name" value="${'홍길동' }" />
			<c:param name="email" value="${'hong@test.com' }" />
		</c:redirect>
	</body>
</html>