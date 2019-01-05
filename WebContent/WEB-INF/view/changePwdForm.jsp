<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="changePwd.do" method="post">
		현재 암호 : <br>
		<input type="password" name="password"> 현재 암호가 일치하지 않습니다. <br>
		새 암호 : <br>
		<input type="password"  name="newPassword"><br>
		<input type="submit" value="암호 변경">
	</form>
</body>
</html>