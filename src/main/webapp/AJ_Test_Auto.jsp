<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
					var url = "AjaxGet_MessageServlet";
					$.ajax({
						type : 'get',
						url : url,
						dataType : 'json',
						success : function(data) {
							$.each(data, function(i, list) {
								var _tr = $("<tr><td>" + list.username+":"
										+ "</td><td>" + list.message
										+ "</td></tr>");

								$("#showTable").append(_tr);
							})
						},
						error : function() {

							console.log('ajax error!');

						}

					})

				}
				return true;
			});
</script>


</head>
<body>

	<table id="showTable" border="1">
		<tr>
			<td>使用者</td>
			<td>訊息</td>
		</tr>
	</table>


</body>
</html>