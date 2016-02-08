<%-- 
    Document   : formulario
    Created on : Feb 2, 2016, 9:15:02 PM
    Author     : Rumil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuario" scope="request" class="entidad.Usuario" />
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		<% if(request.getParameter("name") == null){
		%>	
		<form action="" method="POST">
			<input type="text" name="name" value="" />
			<input type="text" name="email" value="" />
			<input type="submit" value="Enviar" />
		</form>
		<%
		}else {
			String nombre =request.getParameter("name");
			String email =request.getParameter("email");
		
		%>
		<jsp:setProperty name="usuario" property="name" value="<%= nombre %>" />
		<jsp:setProperty name="usuario" property="email" value="<%= email %>" />
		<jsp:forward page="/procesar.jsp"></jsp:forward>
		<%
		}
		%>
	</body>
</html>
