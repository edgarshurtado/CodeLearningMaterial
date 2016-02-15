<%-- 
    Document   : BlogDetalle
    Created on : Feb 15, 2016, 7:40:11 PM
    Author     : Rumil
--%>

<%@page import="entidad.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		<h1>Blog Detalle</h1>
		<table border="1">
			<%
				Post p = (Post)request.getAttribute("post");

			%>
			<tr>
				<td>
					<%= p.getPost_title()%>
				</td>
			</tr>
			<tr>
				<td>
					<%= p.getPost_body()%>
				</td>
			</tr>
			<tr>
				<td>
					<a href="#">Borrar</a>
					<a href="#">Editar</a>
				</td>
			</tr>
			
		</table>
	</body>
</html>
