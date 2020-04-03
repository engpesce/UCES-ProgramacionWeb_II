<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Tempano de Hielo - Recuperación de Password</title>
	<link href="css/style.css" type="text/css" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<div class="content-form">
		<c:if test="true">

			<h1>Aqui esta ejecutando la sarlanga</h1>
		</c:if>


		<c:if test="${numero > 2000}">
			<h2>Aqui entro por el parámetro!! ${numero}</h2>
		</c:if>

		<c:forEach var="i" begin="1" end="5">
		         Item <c:out value="${i}" />
			<p>
		</c:forEach>
	</div>
</body>
</html>