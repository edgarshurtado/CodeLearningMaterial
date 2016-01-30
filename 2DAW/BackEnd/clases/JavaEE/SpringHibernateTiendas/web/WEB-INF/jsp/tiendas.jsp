<%-- 
    Document   : tiendas
    Created on : Jan 28, 2016, 9:01:46 PM
    Author     : Rumil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%
			String titulo  = (String)request.getAttribute("titulo");
		%>
		<title><%= titulo%></title>
	</head>
	<body>
		<h1>${titulo}</h1>
		<h2> ${mensaje}</h2>
		<table border="1">
			<c:forEach var="tienda" items="${lista}">
				<tr>
					<td><c:out value="${tienda.getStoreName()}"></c:out></td>
					<td><c:out value="${tienda.getStoreAddress()}"></c:out></td>
					<td><c:out value="${tienda.getStoreCity()}"></c:out></td>
					<td> <a href="editar.jsp">Editar</a></td>
					<td> <a href="${cp}/borrar/${tienda.getStoreId()}">Borrar</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
