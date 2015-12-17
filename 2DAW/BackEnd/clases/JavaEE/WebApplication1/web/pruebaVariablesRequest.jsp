<%-- 
    Document   : pruebaVariablesRequest
    Created on : 11-dic-2015, 21:14:59
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
        <h1>Hello World!</h1>
        La ip de tu ordenador es: <%= request.getRemoteHost() %> <br>
        El nombre del servidor es: <%= request.getServerName() %><br>
        El nombre del servidor es: <%= request.getServerPort() %><br>
        La ip del servidor es: <%= request.getRemoteAddr()%> <br>
        El protocolo que etás usando es: <%= request.getProtocol()%> <br>
    </body>
</html>
