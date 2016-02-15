<%-- 
    Document   : EditarPost
    Created on : Feb 15, 2016, 8:17:15 PM
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
		<%
			Post p = (Post)request.getAttribute("post");
			%>
		<form action="BlogNewController" method="POST">
			<input type="text" name="title" value="<%= p.getPost_title()%>" /><br>
			<input type="text" name="slug" value="<%= p.getPost_slug()%>" /><br>
			<textarea name="body" rows="20" cols="100"><br>
				<%= p.getPost_body()%>
			</textarea>
			<input type="submit" value="Guardar" />
		</form>
	</body>
</html>
