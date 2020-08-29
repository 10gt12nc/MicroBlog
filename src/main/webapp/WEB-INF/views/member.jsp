<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="tw.com.microblog.bean.Messagez"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>會員訊息</title>
</head>
<body>
	<c:out value="安安你好:${sessionScope.login}"></c:out>
	<br>
	<font color="red">${errormessage}</font>

	<input class="btn btn-lg btn-primary btn-block" type="button"
		onclick="window.location='loginOut'" value="登出"></input>

	<input class="btn btn-lg btn-primary btn-block" type="button"
		onclick="window.location='home.jsp'" value="回首頁"></input>

	<input class="btn btn-lg btn-primary btn-block" type="button"
		onclick="window.location='forgetpass.jsp'" value="修改密碼">

	<form action="new_MesssgeServlet" method="post">
		<textarea rows="4" cols="60" name="message" required></textarea>
		<button type="submit">送出</button>
	</form>

	<hr>
	<br>
	<table border="1">
		<c:forEach items="${Messagez}" var="messagez">
			<tr>
				<!-- %= .get()% -->
				<td style="vertical-align: top;">${messagez.message}</td>
				<td>
					<form action="del_MessageServlet" method="post">
						<input type="hidden" name="id" value="${messagez.id}"> <input
							class="btn btn-lg btn-primary btn-block" type="submit" value="刪除"></input>
					</form>
				</td>
				<td>
					<form action="/WEB-INF/views/edit_message.jsp" method="post">
						<input type="hidden" name="id" value="${messagez.id}"> <input
							type="hidden" name="message" value="${messagez.message}">
						<input class="btn btn-lg btn-primary btn-block" type="submit"
							value="編輯"></input>
					</form>
				</td>
				<td>
					<form action="open_MessageServlet" method="post">
						<select name="open">
							<option value="true">公開</option>
							<option value="false">隱藏</option>
						</select>
						<p>
							<input type="hidden" name="id" value="${messagez.id}"> <input
								class="btn btn-lg btn-primary btn-block" type="submit"
								value="送出"></input>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	



	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</body>
</html>