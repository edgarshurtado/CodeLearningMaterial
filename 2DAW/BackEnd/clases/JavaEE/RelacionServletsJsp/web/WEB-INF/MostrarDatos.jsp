<%-- 
    Document   : MostrarDatos
    Created on : 17-dic-2015, 21:20:10
    Author     : Rumil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="InformacionAlumno" scope="request" class="Entidad.InfoAlumno" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Datos Introducidos</h1>
        Nombre: <jsp:getProperty name="InformacionAlumno" property="nombre" /> <br>
        Apellido 1: <jsp:getProperty name="InformacionAlumno" property="nombre" /> <br>
        Apellido 2: <jsp:getProperty name="InformacionAlumno" property="nombre" /> <br>
    </body>
</html>
