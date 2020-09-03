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



<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script type="text/javascript">
	$(document).ready(
			function() {

				//第一次讀取
				$returntrue = cartnumber();

				//自動更新
				if ($returntrue) {
					setInterval(function() {
						cartnumber();
					}, 10000); //預設10000毫秒自動重複執行cartnumber()函數
				}

				function cartnumber() {
					var url = "get_OpenMessageServlet";
					$.ajax({
						type : 'get',
						url : url,
						dataType : 'json',
						success : function(data) {

							$.each(data, function(i, list) {
								var _tr = $("<tr><td>" + list.username + ":"
										+ "</td><td>" + list.message
										+ "</td></tr>");

								$("#showTable").append(_tr);

							})
						},
						error : function() {

							window.location.href = "home";
							console.log('ajax error!');

						}

					})

				}
				return true;
			});
</script>


</head>
<body>




	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6 offset-md-3">


				<br>
				<table id="showTable" border="1">
					<tr>
						<td>使用者</td>
						<td>訊息</td>
					</tr>
				</table>

				<hr>
				<br>



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



</body>
</html>