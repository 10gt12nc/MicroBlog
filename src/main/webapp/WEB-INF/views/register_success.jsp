<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>success</title>
</head>
<body>
	成功送出表單

	<br>
	<form action="<%=path %>/sendVerifyLink.do" method="post">
		<input type="hidden" name="form" value="linmicroblog@gmail.com">
		<input type="hidden" name="to" value="linmicroblog@gmail.com">
		<input type="hidden" name="subject" value="驗證"> <input
			type="hidden" name="id" value="${id}"> <input type="hidden"
			name="email" value="${email}"> <input type="submit"
			value="寄Gmail驗證">

	</form>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</body>
</html>