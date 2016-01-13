<%-- 
    Document   : muestraDetalleParticipante
    Created on : 12-ene-2016, 21:06:24
    Author     : Rumil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="participante" scope="request" class="Entidad.Participante" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Datos del participante</h1>
        Dorsal: <jsp:getProperty name="participante" property="dorsal" /> <br>
        Nombre: <jsp:getProperty name="participante" property="nombre" /> <br>
        Apellidos: <jsp:getProperty name="participante" property="apellidos" /> <br>
        
    </body>
</html>
