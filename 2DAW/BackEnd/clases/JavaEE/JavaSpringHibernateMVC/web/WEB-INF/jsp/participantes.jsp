<%-- 
    Document   : participantes
    Created on : Jan 25, 2016, 8:11:51 PM
    Author     : Rumil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		<h1>Listado de Participantes!</h1>

		<table border="1">
			<tr>
				<td>Nombre</td>
				<td>Apellidos</td>
				<td>Club</td>
				<td>Poblacion</td>
			</tr>
			<c:forEach var="participante" items="${listaParticipantes}">
				<tr>
					<td> <c:out value="${participante.getNombre()}"></c:out></td>
					<td> <c:out value="${participante.getApellidos()}"></c:out></td>
					<td> <c:out value="${participante.getClub()}"></c:out></td>
					<td> <c:out value="${participante.getPoblacion()}"></c:out></td>
				</tr>
			</c:forEach>



		</table>
	</body>
</html>
