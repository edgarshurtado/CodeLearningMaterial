<%-- 
    Document   : Vista
    Created on : 14-dic-2015, 20:13:26
    Author     : Rumil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuario" scope="request" class="Entidad.infoUsuario" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Usted indicó la siguiente información!</h1>
        
        <b>Nombre: </b><jsp:getProperty name="usuario" property="name" /><br>
        <b>Email: </b><jsp:getProperty name="usuario" property="email" /><br>
        
        <p><b>Esta respuesta ha sido generada desde un jsp independiente
            de la lógica de negocio</b></p>
    </body>
</html>
