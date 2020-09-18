<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="tw.com.microblog.bean.Messagez"%>
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
<title>會員訊息</title>



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
				<c:out value="你好:${sessionScope.login}"></c:out>
			</h4>
		</div>
		<div>
			<font color="red">${errormessage}</font>
		</div>
		<div>
			<input class="btn btn-lg btn-primary btn-block" type="button"
				onclick="window.location='loginOut.do'" value="登出"></input>
		</div>
		<div>
			<button class="btn btn-lg btn-primary btn-block" type="button"
				onclick="javascript:location.href='forgetpass'">修改密碼</button>
		</div>
		<div>
			<button class="btn btn-lg btn-primary btn-block" type="button"
				onclick="javascript:location.href='home'">home</button>
		</div>
		<div>
			<form action="<%=path %>/new_Messsge.do" method="post">
				<textarea rows="4" cols="60" name="message" required></textarea>
				<button type="submit">送出</button>
			</form>
		</div>

		<div>
			<table border="1">
				<c:forEach items="${Messagez}" var="messagez">
					<tr>
						<!-- %= .get()% -->
						<td style="vertical-align: top;">${messagez.message}</td>
						<td>
							<form action="<%=path %>/delete_Message.do" method="post">
								<input type="hidden" name="id" value="${messagez.id}"> <input
									class="btn btn-lg btn-primary btn-block" type="submit"
									value="刪除"></input>
							</form>
						</td>
						<td>
							<form action="editMessage" method="post">
								<input type="hidden" name="id" value="${messagez.id}"> <input
									type="hidden" name="message" value="${messagez.message}">
								<input class="btn btn-lg btn-primary btn-block" type="submit"
									value="編輯"></input>
							</form>
						</td>
						<td>
							<form action="<%=path %>/open_Message.do" method="post">
								<select name="open">
									<option value="true">公開</option>
									<option value="false">隱藏</option>
								</select>
								<p>
									<input type="hidden" name="id" value="${messagez.id}">
									<input class="btn btn-lg btn-primary btn-block" type="submit"
										value="送出"></input>
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</body>
</html>