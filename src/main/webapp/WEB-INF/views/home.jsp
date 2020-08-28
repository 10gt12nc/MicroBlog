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


<script>
    


        function fun() {

            $.ajax({

                url: "get_OpenMessage",
                type: "post",
                data: {
                    "name": "LLL",
                    "age": "1100"
                },
                success: function() {
                    alert(data);
                }


            });





        }


    }
    
    //-------------------------

//執行$.ajax的JS檔案code


$(document).ready(function(){

//第一次讀取
 $returntrue=cartnumber();

//自動更新
if($returntrue){
setInterval(function(){ cartnumber(); }, 10000);  //預設10000毫秒自動重複執行cartnumber()函數
}
function cartnumber(){

$.ajax({

url: xoopsjsurl + '/modules/neillibrary/ajax.php',

type: 'POST',

data: { id: '1'},

success: function(response) {

$('#test').html(response);

},

error: function() {

console.log('ajax error!');

}

})

}
   return true; 
});


</script>

</head>
<body>


https://neohsuxoops.blogspot.com/2018/04/ajaxfunction.html

要顯示資料的內容區

<div id='test'> </div>





    <input type="button" value="GET" onclick="fun();">



	<div>0 0 0 0 0 0</div>

	<div>0 0改jQuery撈資料0 0</div>












	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6 offset-md-3">



				<div>



					<form action="get_OpenMessage" method="post">
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

						<c:out value="會員空間:"></c:out>
						<input class="btn btn-lg btn-primary btn-block" type="button"
							onclick="window.location='search_Message'" value="會員訊息頁面"></input>
						<c:out value="登出:"></c:out>
						<input class="btn btn-lg btn-primary btn-block" type="button"
							onclick="window.location='loginOut'" value="登出"></input>
					</c:when>
					<c:otherwise>
						<c:out value="登入:"></c:out>
						<input class="btn btn-lg btn-primary btn-block" type="button"
							onclick="window.location='login.jsp'" value="登入"></input>
						<p>
							<c:out value="申請:"></c:out>
							<input class="btn btn-lg btn-primary btn-block" type="button"
								onclick="window.location='register.jsp'" value="註冊"></input>
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