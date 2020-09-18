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
<title>register</title>

<style>
body {
	margin-top: 100px;
}
</style>




</head>



<body class="text-center">

	<div class="container-fluid">
		<div class="row">

			<div class="col-md-6 offset-md-3">

				<form action="<%=path %>/register.do" method="POST">

					<table class="col-md-12">
						<caption>
							<font color="red">${message}</font> <font color="red">${message2}</font>
						</caption>
						<tr>
							<th><label for="username">帳號:</label></th>
							<td><input type="text" id="username" name="username"
								placeholder="帳號" class="form-control" required size="25"
								maxlength="16"></td>
						</tr>

						<tr>
							<th><label for="passwd1">密碼:</label></th>
							<td><input id="passwd1" type="password" name="passwd1"
								placeholder="密碼" class="form-control" required size="25"
								maxlength="16"></td>
						</tr>

						<tr>
							<th><label for="passwd2">確認密碼:</label></th>
							<td><input id="passwd2" type="password" name="passwd2"
								class="form-control" placeholder="再次輸入密碼" required size="25"
								maxlength="16"></td>
						</tr>


						<tr>
							<th><label for="email">電子郵件:</label></th>
							<td><input id="email" type="text" name="email" size="25"
								maxlength="100" class="form-control" placeholder="電子郵件" required></td>
						</tr>


					</table>

					<table class="col-md-12">
						<tr>
							<td>
								<button class="btn btn-lg btn-primary btn-block" type="submit">送出</button>
							</td>

							<td>
								<button class="btn btn-lg btn-primary btn-block" type="reset">重新輸入</button>
							</td>
						</tr>
						<tr>
							<td><button class="btn btn-lg btn-primary btn-block"
									type="button" onclick="javascript:location.href='login'">login</button></td>
							<td><button class="btn btn-lg btn-primary btn-block"
									type="button" onclick="javascript:location.href='home'">home</button></td>
						</tr>



					</table>

				</form>
			</div>
		</div>
	</div>




	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>


</body>
</html>