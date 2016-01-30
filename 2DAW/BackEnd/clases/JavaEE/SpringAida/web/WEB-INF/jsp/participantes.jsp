<%-- 
    Document   : participantes
    Created on : 25-ene-2016, 20:13:33
    Author     : AIDA
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--Per a poder utilitzar les funcions amb prefix c--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de Participantes</h1>
        
        <table border="1">
            
            <c:forEach var="participante" items="${listaParticipantes}"> <%--el mateix nom que apareix en ParticipanteController entre " listaParticipantes"--%>
            <tr>
                <td><c:out value="${participante.getNombre()}"></c:out></td>
                <td><c:out value="${participante.getApellidos()}"></c:out></td>
                <td><c:out value="${participante.getPoblacion()}"></c:out></td>
                <td><c:out value="${participante.getClub()}"></c:out></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
