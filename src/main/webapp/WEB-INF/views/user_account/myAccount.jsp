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
<title>GameSeeker - Twoj profil</title>
</head>
<body>

	<div class="container">
		<div class="page-header">
			<h1>Witaj, ${user.firstName}</h1>
			<h2>Znajdz idealne gry dla siebie na GameSeeker!</h2>
		</div>

		<div>
			<p class="text-info">${message}</p>
		</div>

			<a
				href="http://localhost:8080/GameSeeker/${user.id}/account/suggestedGames" class="btn btn-default btn-lg">SZUKAJ
				NOWYCH GIER </a>

			<a href="http://localhost:8080/GameSeeker/${user.id}/account/games" class="btn btn-default">Twoje
				gry</a>

			<a href="http://localhost:8080/GameSeeker/${user.id}/account/hobbies" class="btn btn-default">Twoje
				zainteresowania</a>

			<a href="http://localhost:8080/GameSeeker/${user.id}/account/edit" class="btn btn-default">Edytuj
				swoj profil</a>

			<a href="http://localhost:8080/GameSeeker" class="btn btn-default">Home</a>

	</div>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>