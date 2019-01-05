<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/article/update.do" method="post">
		<fieldset>
		<p>
			<label>번호</label>
			<input type="text" name="no" value="${no }">
		</p>
		<p>
			<label>내용</label>
			<textarea rows="10" cols="50" name="content" > ${content } </textarea>
		</p>
		<p>
			<input type="submit" value="글 수정">
		</p>
		</fieldset>
	</form>

</body>
</html>