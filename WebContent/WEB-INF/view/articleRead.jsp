<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse: collapse;
	border: 1px solid black;
}

tr, td {
	border: 1px solid black;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
	<table>
		<tr>
			<td>번호</td>
			<td>${map.article.article_no }</td>
		</tr>
		<tr>
			<td>작성자이름</td>
			<td>${map.article.writer_name }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${map.article.title }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${map.content.content }</td>
		</tr>
	</table>
	<a href="list.do">[목록]</a> <a href="update.do?no=${map.article.article_no }&content=${map.content.content }">[게시글수정]</a> <a href="delete.do?no=${map.article.article_no }">[게시글삭제]</a>
</body>
</html>