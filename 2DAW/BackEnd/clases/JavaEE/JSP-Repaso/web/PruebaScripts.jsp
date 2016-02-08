<%-- 
    Document   : PruebaScripts
    Created on : Feb 2, 2016, 8:53:12 PM
    Author     : Rumil
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		<h1>Scripts JSP</h1>

		<ul>
			<li>Expresiones JSP<br>
				Fecha Actual: <%=new Date()%>
			</li>
			<li>Scriplets<br>
				<%
					Calendar cal = Calendar.getInstance();
					out.println("La fecha actual es: " + cal.get(Calendar.DATE));
				%>
			</li>
			<li>Declaración más expresión<br>
				<%! private int cuentaDeAcceso=0; %> <!-- Solo definiciones la primera vez que se accede a la página -->
				Accesos a la página: <%= ++cuentaDeAcceso %>
			</li>
		</ul>
			<b> La ip de tu ordenador es :</b> <%=request.getRemoteHost()%> <br>
			<b> El puero del servidor es:</b> <%=request.getServerPort()%> <br>
			<b> El protocolo usado es:</b> <%=request.getProtocol()%> <br> 
	</body>
</html>
