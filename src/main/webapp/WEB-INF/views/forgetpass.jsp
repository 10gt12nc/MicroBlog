<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<table>
		<caption>
			<font color="red">${error}</font> <font color="red">${error2}</font>
		</caption>
	</table>

	<c:choose>
		<c:when test="${id !=null}">

			<table>
				<tr>
					<td>你的舊密碼:${pass}</td>
				</tr>

			</table>
		
			重設新密碼:
			<form action="<%=path %>/reset_PassServlet" method="post">
				<input type="password" name="pass1" placeholder="密碼"
					class="form-control" required size="25" maxlength="16"> <input
					type="password" name="pass2" placeholder="確認密碼"
					class="form-control" required size="25" maxlength="16">

				<!--  字數最小限制? -->

				<input type="hidden" name="id" value="${id}"> <input
					type="hidden" name="pass" value="${pass}"> <input
					type="submit" value="送">

			</form>
		</c:when>
		<c:otherwise>

			<form action="<%=path %>/search_PassServlet" method="post">
				帳號:<input type="text" name="username"> <br> 郵件:<input
					type="text" name="email"> <input type="submit" value="送">

			</form>

		</c:otherwise>


	</c:choose>

	<br>
	<a href="login">login</a>
	<br>
	<a href="home">home</a>


</body>
</html>