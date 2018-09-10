<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Login page</title>
	<link href="css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div>
        <h2>Tempano de Hielo - Sistema de Pedidos Online</h2>
        <p>Ingrese su nombre y usuario para loguearse</p>

        <form action="validate">
        
          <fieldset>
            <legend>Información de contacto:</legend>
            <label for="nombre">User:</label>
            <input type="text" name="name">
            <label for="nombre">Pass:</label>
            <input type="password" name="pass">
            <input type="submit" name="action" value="enviar">
            
            <c:if test="${Boolean.valueOf(String.valueOf(showRecoveryLink))}">
        		<p>Olvido su contraseña?</p>
        		<p> Haga click en el siguiente link para restablecerla...
        			<a href="controller?action=recoveryPassword">AQUÍ</a>
        		</p>
           </c:if>
            
          </fieldset>
        </form>
        
    </div>


</body>
</html>