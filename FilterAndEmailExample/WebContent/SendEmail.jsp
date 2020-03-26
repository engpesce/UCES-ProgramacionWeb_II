<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Envío de Email</title>
	<link href="css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div>
		<%if ( request.getAttribute("isValidRequest") != null && (Boolean) request.getAttribute("isValidRequest") ){ %>
			<div class="ok"> 
				<p>Email enviado correctamente!!</p> 
			</div>	
		<% } else if ( request.getAttribute("isValidRequest") != null && !(Boolean) request.getAttribute("isValidRequest") ){%>
			<div class="error"> 
				<p>No se pudo enviar el email. Debe completar lodos los campos correctamente.</p> 
			</div>
		<% } %>	
		
        <h2>Redacte y envíe el email</h2>
        <p>No olvide completar los campos necesarios</p>

        <form action="sendEmail">
        
          <fieldset>
            <legend>Envío de email:</legend>
            <label for="mailFrom">De:</label>
            <input type="mail" name="mailFrom">
            <br>
            
            <label for="mailTo">Para:</label>
            <input type="mail" name="mailTo">
            <br>
            
            <label for="subject">Asunto:</label>
            <input type="text" name="subject">
            <br>
         
            <label for="subject">Mensaje:</label>
            <textarea rows="4" cols="50" name="message" placeholder="Ingrese el mensaje aquí"></textarea>
            
            <input type="submit" name="sendEmail" value="Enviar">
          </fieldset>
        </form>
        
    </div>

</body>
</html>