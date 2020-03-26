<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Login page</title>
	<link href="css/style.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.7.8/angular.js"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<div>
        <h2>Tempano de Hielo - Sistema de Pedidos Online</h2>
        <p>Ingrese su nombre y usuario para loguearse</p>

        <form action="controller" method=post>
        
          <fieldset>
            <legend>Información de contacto:</legend>
            <label for="nombre">User:</label>
            <input type="text" name="name" data-ng-model="name">
            <label for="nombre">Pass:</label>
            <input type="password" name="pass" data-ng-model="pass">
            <input type="submit" data-ng-disabled="!(name && pass)" name="action" value="login">
            
            <c:if test="${usuarioMal == true}">
            	<span>El usuario o la contraseña son incorrectos</span>
            </c:if>
            
            <%  if ( Boolean.valueOf(String.valueOf(request.getAttribute("showRecoveryLink"))) ){ %>
        	<p>Olvido su contraseña?</p>
        	<p> Haga click en el siguiente link para restablecerla...<a href="controller?action=recoveryPassword">AQUÍ</a></p>
           <% } %>
            
          </fieldset>
        </form>
        
    </div>


</body>
</html>