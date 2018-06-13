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
<title>Hobby</title>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>${user.firstName},listaTwoich zainteresowan</h1>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>Nazwa</th>
					<th>Usuwanie</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${user.hobbies}" var="hobby">
					<tr>
						<td>${hobby.name}</td>
						<td><a
							href="<c:url value='/${user.id}/account/${hobby.id}/hobbyDelete'/>">DELETE</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<a href="<c:url value='/${user.id}/account/hobbyAdd'/>"
			class="btn btn-default">Dodaj hobby</a><br> 
		<a href="<c:url value='/${user.id}/account/profile'/>"
			class="btn btn-default">PROFIL</a>
	</div>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>		
</body>
</html>