<%-- 
    Document   : MuestraDatosAlumno
    Created on : Jan 19, 2016, 1:31:25 PM
    Author     : Rumil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="alumno" scope="request" class="Entidad.Alumno" />
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		<h1>Datos Alumno</h2>
		Nombre: <jsp:getProperty name="alumno" property="nombre" /><br>
		Apellidos: <jsp:getProperty name="alumno" property="apellidos" /><br>
		Curso: <jsp:getProperty name="alumno" property="curso" /><br>
	</body>
</html>
