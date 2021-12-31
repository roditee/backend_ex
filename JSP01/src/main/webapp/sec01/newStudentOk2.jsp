<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EL : param 내장 객체 사용</title>
	</head>
	<body>
		<%
		request.setCharacterEncoding("utf-8");
		%>
		
		<h3>학생 정보 출력 (EL param 객체 사용)</h3>
		학번 : ${param.stdNo }<br>
		성명 : ${param.stdName }<br>
		전화번호 : ${param.stdPhone }<br>
		주소 : ${param.stdAddress }<br>
		학년 : ${param.stdYear }<br>
		
		<h3>로그인 페이지로 이동하는 여러 가지 방법</h3>
		url 사용 : <a href="http://localhost:8080/JSP01/sec01/login.jsp">로그인</a><br>
		<a>에서 ContextPath + ServletPath (URI) 사용 : <a href="/JSP01/sec01/login.jsp">로그인</a><br>
		getContextPath() 메소드 이용 : <a href="<%=request.getContextPath() %>/sec01/login.jsp">로그인</a><br>
		pageContext 내장 객체 사용 : <a href="${pageContext.request.contextPath}/sec01/login.jsp">로그인</a><br>
		
	</body>
</html>