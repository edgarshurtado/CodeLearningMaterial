<%-- 
    Document   : TablaAuto
    Created on : 13-ene-2016, 20:50:17
    Author     : Rumil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
	<jsp:include page="cabecera.html"></jsp:include><br>
        <table border="1">
        <%
            int celNum = 0;
            for(int i=0; i<10; i++){
        %>
            <tr>
        <%
                for(int j=0; j<6; j++){
        %>
                <td><%= celNum %></td>
        <%
                celNum++;
                }
        %>
            </tr>
        <%
            }
        %>
        </table>
    </body>
</html>
