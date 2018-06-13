<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Uzytkownik</title>
</head>
<body>
	<h1>Logowanie</h1>
	<c:forEach items="${users}" var="user">
${user.firstName} ${user.lastName} <b>Login: ${user.login}</b>
		<a href="<c:url value='/${user.id}/account/profile'/>">PROFIL</a>
		<br>
	</c:forEach>
	<div>
		<a href="http://localhost:8080/GameSeeker">Home</a>

	</div>
</body>
</html>