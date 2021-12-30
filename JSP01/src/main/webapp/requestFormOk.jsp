<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>request 객체 관련 메소드 예제</title>
	</head>
	<body>
		<%!
			// 선언부에 변수 선언 (스크립트릿에 선언해도 됨 (메소드 제외))
			String name, id, pwd, hp, year, department;
			String[] interest; // 체크박스
		%>
		
		<%
			// 스크립트릿 영역
			// 폼에서 전송된 데이터 받아서 변수에 저장
			request.setCharacterEncoding("utf-8");
		
			name = request.getParameter("name");
			id = request.getParameter("id");
			pwd = request.getParameter("pwd");
			hp = request.getParameter("hp1") + "-" + request.getParameter("hp2") + "-" +request.getParameter("hp3");
			year = request.getParameter("year");
			interest = request.getParameterValues("interest");
			department = request.getParameter("department");
		%>
		
		<!-- 변수에 저장된 값 출력 -->
		이름 : <%= name %><br>
		아이디 : <%= id %><br>
		비밀번호 : <%= pwd %><br>
		핸드폰 번호 : <%= hp %><br>
		학년 : <%= year %>학년<br>
		
		<!-- 배열은 for문 사용해서 각 요소 반복하여 출력 -->
		관심분야 :
		<% 
			for(int i=0; i<interest.length; i++) {
		%>
			<%= interest[i] + " " %>
		<% } %>
		
		학과 : <%= department %><br>
	</body>
</html>