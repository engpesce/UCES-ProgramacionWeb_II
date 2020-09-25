<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Migrando Servlets a Spring MVC</title>
	<link href="css/style.css" type="text/css" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<div class="content-form">
        <h1>Migrando Servlets a Spring MVC</h1>

        <form action="sendRecoveryUser" method=post>
        
          <fieldset>
            <legend>Información de usuario a recuperar:</legend>
            <label for="nombre">Username:</label>
            <input type="text" name="name" >
            
            <input type="submit" value="Enviar" />
          </fieldset>
        </form>
        
    </div>

</body>
</html>