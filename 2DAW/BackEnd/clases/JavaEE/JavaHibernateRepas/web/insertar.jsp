<%-- 
    Document   : insertar
    Created on : Feb 9, 2016, 9:24:45 PM
    Author     : Rumil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		<form action="RegistrarParticipante" method="POST">
			<input type="text" name="nombre" value="" />
			<input type="text" name="dorsal" value="" />
			<input type="text" name="apellidos" value="" />
			<input type="text" name="poblacion" value="" />
			<input type="text" name="club" value="" />
			<input type="submit" value="submit" />
		</form>
	</body>
</html>
