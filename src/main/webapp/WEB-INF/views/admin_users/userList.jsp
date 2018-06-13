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
<title>Uzytkownicy</title>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>Lista użytkowników</h1>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th>Imie i naziwsko</th>
					<th>Login</th>
					<th>Edycja</th>
					<th>Usuwanie</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.firstName} ${user.lastName}</td>
						<td>${user.login}</td>
						<td><a href="<c:url value='/user/${user.id}/edit'/>">EDIT</a></td>
						<td><a href="<c:url value='/user/${user.id}/del'/>">DELETE</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>


			<a href="http://localhost:8080/GameSeeker/user/form" class="btn btn-default">Dodaj usera</a>

			<a href="http://localhost:8080/GameSeeker/admin" class="btn btn-default">Admin</a>

			<a href="http://localhost:8080/GameSeeker" class="btn btn-default">Home</a>

	</div>

	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>