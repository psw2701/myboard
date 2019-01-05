<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	form {
	width: 400px;
	margin: 0 auto;
}
fieldset{
	padding-left: 
}
label {
	display: block;
}
</style>
</head>
<body>
	<form action="${pageContext.request.contextPath }/article/insert.do" method="post">
		<fieldset>
		<p>
			<label>제목</label>
			<input type="text" name="title" value="" size="40">
		</p>
		<p>
			<label>내용</label>
			<textarea rows="10" cols="50" name="content"></textarea>
		</p>
		<p>
			<input type="submit" value="새글 등록">
		</p>
		</fieldset>
	</form>
</body>
</html>