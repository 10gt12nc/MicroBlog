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
<title>登入</title>




<style>
body {
	margin-top: 100px;
}
</style>


</head>

<body class="text-center">

	<c:if test="${sessionScope.login !=null}">
		<c:redirect url="homeG"></c:redirect>
	</c:if>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6 offset-md-3">

				<form action="<%=path %>/login.do" method="post" class="form-signin">

					<h1 class="h3 mb-3 font-weight-normal">請登入</h1>
					<p>
						<label for="inputEmail" class="sr-only">帳號:</label> <input
							type="text" id="inputEmail" name="username" class=" form-control"
							placeholder="帳號" required autofocus>
					</p>
					<p>
						<label for="Passwd" class="sr-only">密碼:</label> <input
							type="password" id="Passwd" name="passwd" class="form-control"
							placeholder="密碼" required>
					</p>

					<button class="btn btn-lg btn-primary btn-block" type="submit">登入</button>
					<p>
					<table class="col-md-12 ">
						<tr>

							<td><button class="btn btn-lg btn-primary btn-block"
									type="button" onclick="javascript:location.href='register'">register</button></td>
							<td><button class="btn btn-lg btn-primary btn-block"
									type="button" onclick="javascript:location.href='home'">home</button></td>
							<td><button class="btn btn-lg btn-primary btn-block"
									type="button"
									onclick="javascript:location.href='retrieve_pass'">retrieve_pass</button></td>

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