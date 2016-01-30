<%-- 
    Document   : datosChat
    Created on : Jan 26, 2016, 2:22:30 PM
    Author     : Rumil
--%>

<%@page import="org.apache.jasper.tagplugins.jstl.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>

<%
	ArrayList<String[]> historial = (ArrayList)request.getAttribute("historial");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		<% String userName = (String)session.getAttribute("nickName"); %>
		<h1><%= userName %></h1>
		<%
			for(String[] message : historial){
			
		%>
		<%= message[0]%> : <%= message[1] %> <br>
		<%
			}
		%>

		<form action="recogerDatosChat">
			<input type="text" name="message" value="" size="100" /><input type="submit" value="send" />
		</form>

		
			
	</body>
</html>
