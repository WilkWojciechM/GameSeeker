<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/GameSeeker/css/grayscale.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Szczegoly</title>
</head>
<body>


	<div class="container">
		<div class="page-header">
			<div class="row">
				<div class="col-sm-3 col-md-6 col-lg-4">
					<h1>${game.name }</h1>
					<h4>
						<c:forEach items="${game.tags}" var="tag">
					#${tag} 
				</c:forEach>
					</h4>
				</div>
				<div class="col-sm-9 col-md-6 col-lg-8">
					<a href="<c:url value='/${user.id}/account/${game.id}/add'/>"
						class="btn btn-default">Dodaj do ulubionych</a> <a
						href="<c:url value='/${user.id}/account/games'/>"
						class="btn btn-default">Twoje gry</a>
				</div>
			</div>
		</div>



		<div class="row">
			<div class="col-sm-3 col-md-6 col-lg-4">
				<img src="${game.imageUrl}" alt="${game.name}" class="img-thumbnail"
					alt="Cinque Terre" width="304" height="236">
			</div>
			<div class="col-sm-9 col-md-6 col-lg-8">
				<h4>
					Data wydania: <span class="label label-default">${game.created }</span>
				</h4>
				<h4>
					Ograniczenie wiekowe: <span class="label label-default">PEGI
						${game.PEGI }</span>
				</h4>
				<h4>
					Jezyki: <span class="label label-default">${game.language}</span>
				</h4>
				<h4>
					Cena: <span class="label label-default">${game.price} zl</span>
				</h4>
			</div>
		</div>

		<h5>
			Wymagania: <span class="label label-default">${game.hardwareRequirements }</span>
		</h5>

		<h5>
			Opis: <span class="label label-default">${game.description}</span>
		</h5>

		<h6>
			Multiplayer: <span class="label label-default">${game.multiplayer}</span>
		</h6>
		<h6>
			Coop: <span class="label label-default">${game.couchCoop}</span>
		</h6>


		<div>
			<iframe width="420" height="315" src="${game.movieUrl}"> </iframe>
		</div>

	</div>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>