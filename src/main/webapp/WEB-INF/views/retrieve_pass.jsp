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
	<form action="mail_GetPass" method="post">
		帳號:<input type="text" name="username" required> 郵件:<input
			type="text" name="email" required> <input type="submit"
			value="送"> <input class="btn btn-lg btn-primary btn-block"
			type="button" onclick="window.location='home.jsp'" value="回首頁">
		</input> <input class="btn btn-lg btn-primary btn-block" type="button"
			onclick="window.location='login.jsp'" value="回登入頁"></input>
	</form>

</body>
</html>