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
<title>Dane zmienione</title>
</head>
<body>
<div class="container">
	 <div class="page-header">
    <h1>${user.login}, Twoje dane zostaly zmienione.</h1>      
  </div>
	<div>Imie: ${user.firstName}</div>
	<div>Nazwisko: ${user.lastName}</div>
	<div>Email: ${user.email}</div>
	<div>Data urodzenia: ${user.dateOfBirth}</div>
	<a href="<c:url value='/${user.id}/account/profile'/>" class="btn btn-default">POWROT</a>
</div>	
	<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>