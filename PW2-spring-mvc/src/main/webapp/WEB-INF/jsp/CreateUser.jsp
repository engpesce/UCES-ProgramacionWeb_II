<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Tempano de Hielo - User Createion page</title>
	<link href="css/style.css" type="text/css" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<div class="content-form">
        <h2>Tempano de Hielo - Sistema de Pedidos Online</h2>
        <p>Creación de Usuario</p>
	
		<fieldset>
	        <legend>Información de contacto:</legend>
			<form:form method="post" action="createUser"
			  modelAttribute="user">
			    <form:label path="name">Name</form:label>
			    <form:input path="name" />
			     
			    <form:label path="password">Password</form:label>
			    <form:input path="password" />
			     
			    <input type="submit" value="Create" />
			</form:form>
	
	  		<c:if test="${isValid == false}">
	        	<span>El usuario no pudo ser creado. Por favor ingrese el User y el Pass correctamente!</span>
	        </c:if>
	        
		</fieldset>
        
    </div>

</body>
</html>