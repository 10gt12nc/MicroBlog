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

	<c:if test="${param.id == null}">
		<c:redirect url="/search_Message.do"></c:redirect>
	</c:if>

	<font color="red">${errormessage}</font>

	<p>
		<c:out value="舊message : ${param.message}"></c:out>
	<p>
	<hr>
	修改的新訊息:
	<p>
	<form action="<%=path %>/edit_Message.do" method="post">
		<input type="hidden" name="id" value="${param.id}"> <input
			type="hidden" name="message" value="${param.message}">

		<textarea rows="4" cols="60" name="new_message" required></textarea>
		<input class="btn btn-lg btn-primary btn-block" type="submit"
			value="送出"></input>
	</form>


	<input class="btn btn-lg btn-primary btn-block" type="button"
		onclick="window.location='search_Message.do'" value="會員訊息頁面"></input>
	<input class="btn btn-lg btn-primary btn-block" type="button"
		onclick="window.location='loginOut.do'" value="登出"></input>

	<a href="home">home</a>


</body>
</html>