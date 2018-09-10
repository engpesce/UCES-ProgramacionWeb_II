<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Recovery page</title>
	<link href="css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div>
        <h2>Tempano de Hielo - Sistema de Pedidos Online</h2>
        <p>Ingrese su email para que le enviemos la información para recupérar el password</p>

        <form action="controller">
        
          <fieldset>
            <legend>Información de contacto:</legend>
            <label for="mail">Email:</label>
            <input type="mail" name="mail">
            <input type="submit" name="action" value="sendNotification">
          </fieldset>
        </form>
        
    </div>

</body>
</html>