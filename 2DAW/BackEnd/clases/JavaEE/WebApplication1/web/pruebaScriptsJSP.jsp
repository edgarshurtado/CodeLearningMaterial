<%-- 
    Document   : pruebaScriptsJSP
    Created on : 11-dic-2015, 20:57:19
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
        <h1>Hello World!</h1>
        Contenido dinámico mediante scripts JSP
        
        <ul>
            <li><b>Expresiones JSP</b><br>
                Fecha actual : <%= new Date() %>
            </li>
            <li><b>Scriptlet JSP</b><br>
                <%
                    Calendar cal = Calendar.getInstance();
                    out.println("La fecha actual es: " + cal.get(Calendar.DATE)+
                            "/" + (cal.get(Calendar.MONTH) + 1) + "/" +
                            cal.get(Calendar.YEAR));
                %>
            </li>
            <li><b>Declaración mas expresión JSP</b><br>
                <%! private int accesCount = 0; %>              
                Accesos a la página: <%= ++accesCount%>
            </li>
        </ul>
    </body>
</html>
