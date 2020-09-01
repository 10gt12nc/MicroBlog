<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<font color="red">${message}</font>
	<p>
	<form action="mail_GetPassServlet" method="post">
		帳號:<input type="text" name="username" required> 郵件:<input
			type="text" name="email" required> <input type="submit"
			value="送"> 
			
			<a href="home">home</a>
			<a href="login">login</a>
	</form>

</body>
</html>