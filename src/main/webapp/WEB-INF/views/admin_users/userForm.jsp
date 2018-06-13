<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/GameSeeker/css/grayscale.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
</head>

<body>

	<div class="container">
		<div class="page-header">
			<h2>ID: #${user.id}</h2>
			<h3>Formularz uzytkownika</h3>
			
		</div>
		<div>
			<form:form method="post" modelAttribute="user" class="form-horizontal">
				<div class="form-group">
					<label class="control-label col-sm-2">Imie:</label>
					<div class="col-sm-10">
						<form:input path="firstName" class="form-control" style="width: 300px;"/>
					</div>
					<form:errors path="firstName" />
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">Nazwisko:</label>
					<div class="col-sm-10">
						<form:input path="lastName" class="form-control"  style="width: 300px;"/>
					</div>
					<form:errors path="lastName" />
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">Login:</label>
					<div class="col-sm-10">
						<form:input path="login" class="form-control"  style="width: 300px;"/>
					</div>
					<form:errors path="login" />
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">Haslo:</label>
					<div class="col-sm-10">
						<form:input path="password" class="form-control"  style="width: 300px;"/>
					</div>
					<form:errors path="password" />
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">Email:</label>
					<div class="col-sm-10">
						<form:input type="email" path="email" class="form-control"  style="width: 300px;"/>
					</div>
					<form:errors path="email" />
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">Data urodzenia:</label>
					<div class="col-sm-10">
						<form:input type="text" path="dateOfBirth" id="datepicker"	class="form-control"  style="width: 300px;"/>
					</div>
					<form:errors path="dateOfBirth" />
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							<label><form:checkbox path="admin" />Czy administrator</label>
						</div>
					</div>
					<form:errors path="admin" />
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Zatwierdz</button>
					</div>
				</div>
			</form:form>
		</div>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>