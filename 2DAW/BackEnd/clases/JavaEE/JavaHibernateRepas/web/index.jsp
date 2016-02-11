<%-- 
    Document   : index
    Created on : Feb 8, 2016, 8:22:41 PM
    Author     : Rumil
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Participante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		<h1>Listado Participantes</h1>
		<a href="insertar.jsp">Insertar nuevo participante</a>
		<table border="1">
			<tr>
				<th>Dorsal</th>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th>Población</th>
				<th>CLUB</th>
				<th>Editar</th>
				<th>Borrar</th>
			</tr>
		<% ArrayList<Participante> listaParticipantes = 
			(ArrayList<Participante>)request.getAttribute("listaParticipantes"); 
		
			for(Participante p : listaParticipantes){
		%>
	<tr>
		<td> <%= p.getDorsal()%></td>
		<td> <%= p.getNombre()%></td>
		<td> <%= p.getApellidos()%></td>
		<td> <%= p.getPoblacion()%></td>
		<td> <%= p.getClub()%></td>
		<td><a href="EditarParticipante?dorsal=<%= p.getDorsal() %>">Editar</a></td>
		<td><a href="BorrarParticipante?dorsal=<%= p.getDorsal() %>">Borrar</a></td>
		<td><a href="">Borrar</a></td>
	</tr>
		<%
			}
		%>
		</table>
	</body>
</html>
