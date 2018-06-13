<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/GameSeeker/css/grayscale.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tag</title>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h3>Nowy tag</h3>
		</div>
		<form:form method="post" modelAttribute="tag" class="form-horizontal">
			<div class="form-group">
				<label class="control-label col-sm-2">Tag:</label>
				<div class="col-sm-10">
					<form:input path="name" class="form-control" style="width: 300px;" />
				</div>
				<form:errors path="name" />
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