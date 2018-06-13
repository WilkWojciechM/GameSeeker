<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/GameSeeker/css/grayscale.min.css">
<title>Propozycje gier</title>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h2>${user.firstName},otowybrane dla Ciebie gry!</h2>
		</div>
		<div>
			<i>${message}</i>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th>Nazwa</th>
					<th>Szczegoly</th>
					<th>Dodaj</th>
					<th>Tagi</th>
				</tr>
			</thead>
			<tbody>
				
					<c:forEach items="${suggestedGames}" var="game">
						<tr>
							<td>${game.name}</td>
							<td><a
								href="<c:url value='/${user.id}/account/${game.id}/details'/>">Szczegoly</a></td>
							<td><a
								href="<c:url value='/${user.id}/account/${game.id}/add'/>">LUBIE</a></td>
							<td>${game.tags}</td>
						</tr>
					</c:forEach>
			</tbody>
		</table>

		<a href="<c:url value='/${user.id}/account/games'/>"
			class="btn btn-default">POWROT DO TWOICH GIER</a> 
		<a	href="http://localhost:8080/GameSeeker/${user.id}/account/profile" class="btn btn-default">POWROT
			DO PROFILU</a>
	</div>
</body>
</html>