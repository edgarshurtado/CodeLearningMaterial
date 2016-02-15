<%-- 
    Document   : index
    Created on : Feb 15, 2016, 7:13:11 PM
    Author     : Rumil
--%>

<%@page import="java.util.ArrayList"%>
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
			ArrayList<Post> listaPosts = (ArrayList<Post>)request.getAttribute("listaPosts");
		%>

		<h1>NOTICIAS DEL BLOG</h1>
		<table border="1">
			<%
				for(Post p : listaPosts){
					%>
					<tr>
						<td><%=p.getPost_title()%></td>
						<td><img style="width:100px;" src="./images/<%=p.getPost_image()%>" /> </td>
					</tr>
			<%
				}
			%>
		</table>
	</body>
</html>
