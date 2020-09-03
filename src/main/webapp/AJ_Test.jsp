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


function testPost(){
	 $.ajax({ 
			type:"POST", //請求方式
			url:"AjaxGet_MessageServlet", //請求路徑：${base}/類所在的名稱空間/類名（配置檔案中執行對應類的那個name），名稱空間是在配置檔案中定義。
			data:{ "name":"zah","pass":"123"},  //傳參
			dataType: 'json',   //返回值型別
			
		
			//(json) 返回值
		
			success:function(json){	
	    	  
			    alert(json[0].username+":"+ json[0].password
			    	+"--"+	json[1].username+":"+ json[1].password
			    );   
			   
			    // 需解析，否则返回 object
			    var result = JSON.stringify(json);  
              	console.log(result)
			    $("#showArea01").text(result);
			    //json[0]就相當於u1物件 
			    
			    //Map json.u1.username 
	    	      
	           }
			});
			
}
function testGet(){
	 $.ajax({ 
			type:"GET",
			url:"AjaxGet_MessageServlet", 
			dataType: 'json',   
			success:function(json){	
			    var result = JSON.stringify(json);  
                console.log(result)
			    $("#showArea02").text(result);
	           }
			});
		
 }

</script>


</head>
<body>

<input type="button" name="b" value="POST測試" onclick="testPost();" >
<hr>
<br>
<div id="showArea01"></div>
<hr>
<br>
<input type="button" name="b" value="GET測試" onclick="testGet();" >
<hr>
<br>
<div id="showArea02"></div>
<hr>
<br>

<input type="button" value="點我顯示資料" id="clickMe"> 
	<table id="showTable" border="1"> 
		<tr> 
			<td>姓名</td> 
			<td>訊息</td> 
		</tr> 
	</table> 
	<script> 
		$("#clickMe").click( function(){ 
			var url = "AjaxGet_MessageServlet"; 
			$.ajax({ 
					type:'get', 
					url:url, 
					dataType: 'json', 
					success:function(data){ 
						$.each(data,function(i,list){ 
							var _tr = $(
									"<tr><td>"
									+list.username+
									"</td><td>"
									+list.message+
									"</td></tr>"); 
							
							$("#showTable").append(_tr); 
					})
				}
		    }) 
		})
	</script>
	 
</body>
</html>