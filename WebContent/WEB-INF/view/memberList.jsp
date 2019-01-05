<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {
	
	border-collapse:collapse; 
}
tr, td{
	border: 1px solid black;
	margin: 10px;
	padding: 10px;
}
</style>
</head>
<body>
	<table>
	<c:forEach var="member" items="${list}">
		<tr>
			<td>${member.memberid }</td>
			<td>${member.name }</td>
			<td>${member.password }</td>
			<td><fmt:formatDate value="${member.regdate }" pattern ="yyyy-MM-dd hh:mm"/> </td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>