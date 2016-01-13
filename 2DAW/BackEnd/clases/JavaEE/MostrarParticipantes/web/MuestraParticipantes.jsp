<%-- 
    Document   : MuestraParticipantes
    Created on : 11-ene-2016, 20:35:45
    Author     : Rumil
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Participante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="MostrarDetallesParticipante" method="POST">
        
            <h2>Ver Datos Participante</h2>
            <select name="participanteElegido">
                <%
                    ArrayList<Participante> listadoParticipantes = (ArrayList)request.getAttribute("listadoParticipantes");
                    
                    for(int i = 0; i < listadoParticipantes.size(); i++){
                        Participante objetoParticipante = listadoParticipantes.get(i);
                %>
                <option value="<%= objetoParticipante.getDorsal() %>">
                    <%= objetoParticipante.getNombre() + " " + objetoParticipante.getApellidos() %>
                </option>
                <%
                    }
                 %>
            </select>
            <input type="submit" value="Buscar" />
        </form>
    </body>
</html>
