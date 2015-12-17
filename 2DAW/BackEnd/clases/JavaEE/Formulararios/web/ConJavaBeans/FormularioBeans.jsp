<%-- 
    Document   : Formulario
    Created on : 14-dic-2015, 19:08:36
    Author     : Rumil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Cargar Bean -->
<jsp:useBean id="usuario" scope="request" class="Entidad.infoUsuario" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
        
            if(request.getParameter("nombre") == null 
                    || request.getParameter("email") == null
                    || request.getParameter("nombre").equals("") 
                    || request.getParameter("email").equals("")){
        %>
        <h1>Formulario</h1>
        <form action="FormularioBeans.jsp" method="POST">
            Su nombre <input type="text" name="nombre" size="26"/><br>
            Su email <input type="text" name="email" size="26"/><br>
            <input type="submit" value="enviar" name="send"/>
        </form>
        <%
            } else {
                String nombre = request.getParameter("nombre");
                String email = request.getParameter("email");
        %>
                <jsp:setProperty name="usuario" property="name" value="<%= nombre %>" />
                <jsp:setProperty name="usuario" property="email" value="<%= email %>" />
                
                <jsp:forward page="./Vista.jsp" />
        <%
            }
            
        %>
        
        
    </body>
</html>
