<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정페이지</h1>
	
	<form action="./update" method="post">
		<input type="hidden" name="num" value="${dto.num}">
		
		<div>
			<label>도시명</label>
			<!--   속성명이 같을게 없을때 명명 생략가능 -> requestScope 나 pageScope 생략가능-->
			<input type="text" name="city" placeholder="${dto.city}">
		</div>
		<div>
			<label>기온</label>
			<input type="text" name="gion" placeholder="${dto.gion}"}>
		</div>
		<div>
			<label>상태</label>
			<input type="text" name="status" placeholder="${dto.status}">
		</div>
		<div>
			<label>습도</label>
			<input type="text" name="huminity" placeholder="${dto.huminity}">
		</div>
		
				
		<input type="submit" value=등록>	
			
	</form>
</body>
</html>