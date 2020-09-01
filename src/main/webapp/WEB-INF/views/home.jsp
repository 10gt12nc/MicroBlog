<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>首頁</title>




</head>
<body>


	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6 offset-md-3">

				<div>

					<form action="get_OpenMessageServlet" method="post">
						<input type="submit" value="取得新資訊" name="OpenMessage"
							class="btn btn-lg btn-primary btn-block"></input>
						<table border="1">
							<c:forEach items="${OMessagez}" var="omessagez">
								<tr>
									<!-- %= .get()% -->
									<td style="vertical-align: top;">${omessagez.username}</td>
									<td>說:</td>
									<td style="vertical-align: top;">${omessagez.message}</td>
								</tr>
							</c:forEach>
						</table>

					</form>

				</div>



				<c:choose>
					<c:when test="${sessionScope.login !=null}">

						<c:out value="會員訊息頁面:"></c:out>

						<input class="btn btn-lg btn-primary btn-block" type="button"
							onclick="window.location='search_MessageServlet'" value="會員訊息頁面"></input>

						<c:out value="登出:"></c:out>
						<input class="btn btn-lg btn-primary btn-block" type="button"
							onclick="window.location='loginOutServlet'" value="登出"></input>
					</c:when>
					<c:otherwise>
						<c:out value="登入:"></c:out>
						<a href="login">login</a>
						<p>
							<c:out value="申請:"></c:out>
							<a href="register">register</a>
					</c:otherwise>
				</c:choose>


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