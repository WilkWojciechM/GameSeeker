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
<title>Gra</title>
</head>
<body>

	<div class="container">
		<div class="page-header">
			<h2>ID: #${game.id}</h2>
			<h3>Formularz gry</h3>
		</div>
		<form:form method="post" modelAttribute="game" class="form-horizontal">
			<div class="form-group">
				<label class="control-label col-sm-2">Nazwa:</label>
				<div class="col-sm-10">
					<form:input path="name" class="form-control" style="width: 300px;" />
				</div>
				<form:errors path="name" />
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Wymagania:</label>
				<div class="col-sm-10">
					<form:textarea path="hardwareRequirements" class="form-control"
						style="width: 300px;" />
				</div>
				<form:errors path="hardwareRequirements" />
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Data wydania:</label>
				<div class="col-sm-10">
					<form:input type="text" path="created" id="datepicker"
						class="form-control" style="width: 300px;" />
				</div>
				<form:errors path="created" />
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Ograniczenia wiekowe:</label>
				<div class="col-sm-10">
					<form:select path="PEGI" items="${PEGI}" class="form-control"
						style="width: 300px;" />
				</div>
				<form:errors path="PEGI" />
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Opis:</label>
				<div class="col-sm-10">
					<form:textarea path="description" class="form-control"
						style="width: 300px;" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label><form:checkbox path="multiplayer" />Multiplayer</label>
					</div>
				</div>
				<form:errors path="multiplayer" />
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label><form:checkbox path="couchCoop" />Coop</label>
					</div>
				</div>
				<form:errors path="couchCoop" />
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Jezyki:</label>
				<div class="col-sm-10">
					<form:select path="language" items="${language}" multiple="true"
						class="form-control" style="width: 300px;" />
				</div>
				<form:errors path="language" />
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Cena:</label>
				<div class="col-sm-10">
					<form:input path="price" class="form-control" style="width: 300px;" />
				</div>
				<form:errors path="price" />
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Tagi gry:</label>
				<div>
					<c:forEach items="${game.tags}" var="tag">
			#${tag.name} 
			
			</c:forEach>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Dodaj tagi:</label>
				<div class="col-sm-10">
					<form:select path="tags" items="${tags}" multiply="true"
						itemValue="id" itemLabel="name" class="form-control"
						style="width: 300px;" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">URL obrazka:</label>
				<div class="col-sm-10">
					<form:input path="imageUrl" class="form-control"
						style="width: 300px;" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">URL filmu:</label>
				<div class="col-sm-10">
					<form:input path="movieUrl" class="form-control"
						style="width: 300px;" />
				</div>
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