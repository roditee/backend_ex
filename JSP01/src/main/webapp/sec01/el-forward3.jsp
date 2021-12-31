<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="sec01.StudentBean" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<%
		StudentBean s1 = new StudentBean("2001003", "홍길동", "010-5555-5555", "서울", 4);
		StudentBean s2 = new StudentBean("2001005", "이몽룡", "010-1234-1234", "인천", 3);
		StudentBean s3 = new StudentBean("2001006", "성춘향", "010-1234-5656", "전북", 2);
		
		List studentList = new ArrayList();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		
		request.setAttribute("stdList", studentList);
		 %>
		 <jsp:forward page="el-forward-result3.jsp" />
	</body>
</html>