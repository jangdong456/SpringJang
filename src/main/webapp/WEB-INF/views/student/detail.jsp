<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>detail Page</h1>
		
	<h3>${requestScope.dto.city}</h3>
	<h3>${requestScope.dto.gion}</h3>
	<h3>${requestScope.dto.status}</h3>
	<h3>${requestScope.dto.huminity}</h3>
	
	<form id="frm" action="delete" method="post">
	
		<input id="num" type="hidden" name="num" value="${requestScope.dto.num}" > 
	</form>
		
	<button id ="btn">DELETE</button>
	<button id ="up">UPDATE</button>
	
	<script type="text/javascript">
		const frm = document.getElementById("frm");
		const btn = document.getElementById("btn");
		const up = document.getElementById("up");
		
		
		btn.addEventListener("click",function(){
			frm.submit();
		})
		
		up.addEventListener("click",function(){

			frm.method="get"

			frm.action="update"
			frm.submit();
		})
		

	</script>
	
</body>
</html>