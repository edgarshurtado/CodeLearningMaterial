<%-- 
    Document   : insertar
    Created on : Feb 9, 2016, 9:24:45 PM
    Author     : Rumil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="participante" scope="request" class="entidad.Participante" />
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		<form action="RegistrarParticipante" method="POST">
			Nombre: <input type="text" name="nombre" value="<jsp:getProperty name="participante" property="nombre" />" /> <br>
			<input type="text" name="dorsal" value="<jsp:getProperty name="participante" property="dorsal" />" /> <br>
			<input type="text" name="apellidos" value="<jsp:getProperty name="participante" property="apellidos" />" /> <br>
			<input type="text" name="poblacion" value="<jsp:getProperty name="participante" property="poblacion" />" /> <br>
			<input type="text" name="club" value="<jsp:getProperty name="participante" property="club" />" /> <br>
			<input type="submit" value="submit" />
		</form>
	</body>
</html>
