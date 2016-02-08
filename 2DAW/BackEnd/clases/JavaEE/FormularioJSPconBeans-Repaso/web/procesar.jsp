<%-- 
    Document   : procesar
    Created on : Feb 2, 2016, 9:14:32 PM
    Author     : Rumil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuario" scope="request" class="entidad.Usuario" />
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		Los datos son <br>
		Nombre: <jsp:getProperty name="usuario" property="name" /><br>
		Email: <jsp:getProperty name="usuario" property="email" />
	</body>
</html>
