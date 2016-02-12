<%-- 
    Document   : usuarios
    Created on : Feb 12, 2016, 9:07:37 PM
    Author     : Rumil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		<h1>Lista de usuarios</h1>
		<table border="1">
			<c:forEach var="usuario" items="${listaUsuarios}">
				<tr>
					<td><c:out value="${usuario.getNombre()}"></c:out> </td>
					<td><c:out value="${usuario.getClave()}"></c:out> </td>
					<td><c:out value="${usuario.getEmail()}"></c:out> </td>
				</tr>
			</c:forEach>
		</table>

	</body>
</html>
