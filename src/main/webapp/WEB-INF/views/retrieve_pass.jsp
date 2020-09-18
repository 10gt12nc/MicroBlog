<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<font color="red">${message}</font>
	<p>
	<form action="<%=path %>/mail_GetPassServlet" method="post">
		帳號:<input type="text" name="username" required> <br>郵件:<input
			type="text" name="email" required> <input type="submit"
			value="送"> <br> <a href="home">home</a> <br> <a
			href="login">login</a>
	</form>

</body>
</html>