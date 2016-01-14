<%-- 
    Document   : formulario1
    Created on : 13-ene-2016, 20:58:55
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
	<jsp:include page="cabecera.html"></jsp:include><br>
        <%
            if(request.getParameter("nombre") == null){
        %>
        <form action="formulario1.jsp">
            Nombre Película: <input type="text" name="nombre" value="" /> <br>
            Número Dias Alquiler: <input type="text" name="dias" value="" /> <br>
            Edad del cliente: <br>
            <input type="radio" name="edad" value="Menor de 7 años" />Menor de 7 años<br>
            <input type="radio" name="edad" value="Menor de 14 años" />Menor de 14 años<br>
            <input type="radio" name="edad" value="Menor de 18 años" />Menor de 18 años<br>
            <input type="radio" name="edad" value="Mayor de 18 años" />Mayor de 18 años<br>
            
            Forma de pago: <br>
            <select name="pago">
                <option>VISA</option>
                <option>MasterCard</option>
            </select>
            <hr>
            Especificaciones extras: <br>
            <textarea name="extras"></textarea>
	    <input type="submit" value="Enviar" />
        </form>
        <%
            }else{
                String nombre = request.getParameter("nombre");
                String dias = request.getParameter("dias");
                String edad = request.getParameter("edad");
                String pago = request.getParameter("pago");
                String extras = request.getParameter("extras");
        %>
        <jsp:setProperty name="alquiler" property="nombre" value="<%= nombre %>" />
        <jsp:setProperty name="alquiler" property="dias" value="<%= dias %>" />
        <jsp:setProperty name="alquiler" property="edad" value="<%= edad %>" />
        <jsp:setProperty name="alquiler" property="pago" value="<%= pago %>" />
        <jsp:setProperty name="alquiler" property="extras" value="<%= extras %>" />

	<jsp:forward page="formulario2.jsp"></jsp:forward>
        <%
            }
        %>
    </body>
</html>
