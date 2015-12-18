<%-- 
    Document   : Formulario
    Created on : 17-dic-2015, 21:02:44
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
        <h1>Datos del alumno</h1>
        <form name="formulario" action="RecogerDatos">
            Nombre: <input type="text" name="nombre" value="" />
            Apellido 1: <input type="text" name="apellido1" value="" />
            Apellido 2: <input type="text" name="apellido2" value="" />
            <input type="submit" value="Enviar" name="enviar" />
        </form>
    </body>
</html>
