<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 변수 설정 --> <!-- value 값으로 EL 사용 가능 -->
<c:set var="id" value="hong" scope="page" />
<c:set var="pwd" value="1234" scope="page" />
<c:set var="name" value="${'홍길동' }" scope="page" />
<c:set var="age" value="${20 }" scope="page" />

<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>c:set 태그</title>
	</head>
	<body>
		${id }<br>
		${pwd }<br>
		${name }<br>
		${age }<br>
		
		<a href="${contextPath }/sec01/login.jsp">로그인</a>
	</body>
</html>