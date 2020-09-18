<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html>
<html lang="zh-Hant-TW">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>

<style>
body {
	margin-top: 20px;
}

div {
	margin: 5px;
}
</style>

</head>
<body>
	<div class="container">
		<div>

			<h4>
				<c:out value="登入成功,你好:${sessionScope.login}"></c:out>
			</h4>
		</div>
		<div>
			<input class="btn btn-lg btn-primary btn-block" type="button"
				onclick="window.location='loginOutServlet'" value="登出"></input>
		</div>
		<div>
			<input class="btn btn-lg btn-primary btn-block" type="button"
				onclick="window.location='search_MessageServlet'" value="會員訊息頁面"></input>
		</div>
		<div>

			<button class="btn btn-lg btn-primary btn-block" type="button"
				onclick="javascript:location.href='home'">home</button>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</body>
</html>