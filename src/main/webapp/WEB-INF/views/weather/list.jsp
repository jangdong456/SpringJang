<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/tables.css" rel="stylesheet">
</head>
<body>
	<h2 style="text-align: center;">날씨 정보 리스트</h2>
	<table border="1" class="tbl">
		<thead>
			<tr>
				<th>num</th>
				<th>city</th>
				<th>gion</th>
				<th>status</th>
				<th>huminity</th>
			</tr>
		</thead>
		<c:forEach items="${requestScope.list}" var="weather"> <!-- arraylist에 변수에 넣고 -->
			<tbody>
				<tr>
					<td>${pageScope.weather.num}</td>
					<td><a href="./detail?num=${pageScope.weather.num}">${pageScope.weather.city}</a></td>
					<td>${pageScope.weather.gion}</td>
					<td>${pageScope.weather.status}</td>
					<td>${pageScope.weather.huminity}</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	
	<div> 
		<a href="./add">날씨 등록</a>
	</div>
</body>
</html>