<%-- 
    Document   : pruebaError
    Created on : 11-dic-2015, 20:47:27
    Author     : Rumil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%= 0/0 %>
    </body>
</html>
