<%-- 
    Document   : formulario2
    Created on : 13-ene-2016, 20:59:03
    Author     : Rumil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="alquiler" scope="request" class="Entidad.AlquilerBean" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
	Nombre : 	<jsp:getProperty name="alquiler" property="nombre" /><br>
	Dias : 	<jsp:getProperty name="alquiler" property="dias" /><br>
	Edad : 	<jsp:getProperty name="alquiler" property="edad" /><br>
	Pago : 	<jsp:getProperty name="alquiler" property="pago" /><br>
	Extras : 	<jsp:getProperty name="alquiler" property="extras" /><br>
    </body>
</html>
