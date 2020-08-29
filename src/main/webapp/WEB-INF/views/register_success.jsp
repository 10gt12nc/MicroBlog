<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<form action="sendVerifyLinkServlet" method="post">
		<input type="hidden" name="form" value="linmicroblog@gmail.com"> <input
			type="hidden" name="to" value="linmicroblog@gmail.com"> <input
			type="hidden" name="subject" value="驗證"> 
		<input type="hidden" name="id" value="${id}"> <input
			type="hidden" name="email" value="${email}"> <input
			type="submit" value="寄Gmail驗證">

	</form>




	<br>

	<input class="btn btn-lg btn-primary btn-block" type="button"
		onclick="window.location='home.jsp'" value="首頁"></input>
	<br>或 登入
	<input class="btn btn-lg btn-primary btn-block" type="button"
		onclick="window.location='login.jsp'" value="登入頁"></input>



	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</body>
</html>