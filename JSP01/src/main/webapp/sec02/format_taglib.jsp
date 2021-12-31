<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>포매팅 태그 라이브러리</title>
	</head>
	<body>
		<h3>formatNumber : 숫자 포매팅</h3>
		<c:set var="price" value="100000000" />
		초기 문자열 형태 : ${price }<br>
		
		<fmt:formatNumber type="number" value="${price }" var="priceNumber" />
		일반 숫자로 표현 시 (천 단위 구분 자동으로 해줌) : ${priceNumber }<br>
		일반 숫자로 표현 - 천 단위 구분 없이 : <fmt:formatNumber type="number" value="${price }" groupingUsed="false"/><br>
		통화로 표현 시 : <fmt:formatNumber type="currency" currencySymbol="\\" value="${price }" /><br>
		퍼센트로 표현 : <fmt:formatNumber type="percent" value="${price }" groupingUsed="false"/><br>
		
		<h2>formatDate : 날짜 포매팅</h2>
		<c:set var="now" value="<%=new Date() %>" />
		Date<br>
		스타일 없이 : <fmt:formatDate type="date" value="${now }" /><br>
		스타일 full : <fmt:formatDate type="date" value="${now }" dateStyle="full" /><br>
		스타일 short : <fmt:formatDate type="date" value="${now }" dateStyle="short" /><br><br>
		
		Time 스타일 없이<br>
		<fmt:formatDate type="time" value="${now }" /><br>
		<fmt:formatDate type="both" value="${now }" /><br><br>
		
		Time 스타일 full<br>
		<fmt:formatDate type="both" value="${now }" dateStyle="full"/><br><br>
		
		Time 스타일 내맘대로<br>
		주의 : MM은 무조건 대문자 / HH 24시간제, hh 12시간제<br>
		<fmt:formatDate value="${now }" pattern="yyyy-MM-dd :hh:mm:ss"/><br>
		<fmt:formatDate value="${now }" pattern="yy-MM-dd :hh:mm:ss"/><br>
		<fmt:formatDate value="${now }" pattern="yyyy-MM-dd :HH:mm:ss"/><br>
		<fmt:formatDate value="${now }" pattern="yy-MM-dd :HH:mm:ss"/><br><br>
		
		한국 현재 시간 : 
		<fmt:formatDate type="both" value="${now }" dateStyle="full"/><br>
		뉴욕 현재 시간 : 
		<fmt:timeZone value="GMT-5">
			<fmt:formatDate type="both" value="${now }" dateStyle="full"/><br>
		</fmt:timeZone>
	</body>
</html>