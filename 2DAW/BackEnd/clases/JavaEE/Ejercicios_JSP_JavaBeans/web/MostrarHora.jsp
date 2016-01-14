<%-- 
    Document   : ejercicio2
    Created on : 13-ene-2016, 20:23:37
    Author     : Rumil
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
	<jsp:include page="cabecera.html"></jsp:include><br>

        <% 
            String time = null;
            Calendar cal = Calendar.getInstance(); 
            Date fecha = cal.getTime();
        %>
        <%=fecha.getHours()%> : <%=fecha.getMinutes() %>
    </body>
</html>
