<%-- 
    Document   : listaTiendas
    Created on : Feb 15, 2016, 10:56:42 AM
    Author     : Rumil
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="entity.CgStore"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
		<%
			ArrayList<CgStore> listaTiendas =
				(ArrayList < CgStore >)request.getAttribute("listaTiendas");
		%>
	</head>
	<body>
		<h1>Listado Tiendas</h1>
		
		<table border="1">
			<a href="formAddTienda.html">Añadir tienda</a>
			<%
				for(CgStore tienda : listaTiendas){
					%>
					<tr>
						<td><%=tienda.getStore_name()%></td>
						<td><%=tienda.getStore_address()%></td>
						<td><%=tienda.getStore_phone()%></td>
					</tr>
			<%
				}
			%>
		</table>
	</body>
</html>
