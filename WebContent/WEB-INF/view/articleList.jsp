<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
}

tr, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<table>
		<tr>
			<td colspan="4"><a href="${pageContext.request.contextPath }/article/insert.do">게시글쓰기</a></td>
		</tr>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${list }" var="article">
			<tr>
				<td>${article.article_no }</td>
				<td><a href="read.do?no=${article.article_no }">${article.title }</a></td>
				<td>${article.writer_name }</td>  
				<td>${article.read_cnt }</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>