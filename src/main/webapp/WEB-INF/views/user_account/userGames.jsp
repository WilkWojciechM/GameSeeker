<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/GameSeeker/css/grayscale.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista gier</title>
</head>
<body>
<div class="container">
		<div class="page-header">
			<h1>${user.firstName}, oto lista Twoich ulubionych gier</h1>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th>Nazwa</th>
					<th>Szczegoly</th>
					<th>Usuwanie</th>
				</tr>
			</thead>
			<tbody>
			
	<c:forEach items="${userGames}" var="game">
		<tr>
			<td>${game.name}</td> 
			<td><a href="<c:url value='/${user.id}/account/${game.id}/details'/>">Szczegoly</a></td>
			<td><a href="<c:url value='/${user.id}/account/${game.id}/del'/>">DELETE</a></td>
		</tr>	
	</c:forEach>
	</tbody>
	</table>
	<a href="http://localhost:8080/GameSeeker/${user.id}/account/addgame" class="btn btn-default">Dodaj nowe gry</a>
	<a href="http://localhost:8080/GameSeeker/${user.id}/account/profile" class="btn btn-default">POWROT</a>
	</div>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>