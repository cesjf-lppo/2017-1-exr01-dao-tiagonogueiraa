<%-- 
    Document   : lista-pedidos
    Created on : 30/05/2017, 20:38:23
    Author     : tiago
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Pedidos</title>
    </head>
    <body>
	<%@include file="jspf/menu.jspf" %>
        <h1>Lista Por Pedido</h1>
	<table>
	    <thead>
		<tr>
		    <th>ID</th>
		    <th>Numero Pedido</th>
		    <th>Dono</th>
		    <th>Valor</th>
		    <th>Descricao</th>
		    <th>Modificado Em</th>
		</tr>
	    </thead>
	    <tbody>
		<c:forEach var="pedido" items="${pedido}">
		    <tr>
			<td>${pedido.id}</td>
			<td>${pedido.pedido}</td>
			<td>${pedido.dono}</td>
			<td>${pedido.valor}</td>
			<td>${pedido.descricao}</td>
			<td>${pedido.dataEHora}</td>
			
		    </tr>
		</c:forEach>
		    
		    <tr>
                    <td colspan="5"> Total Pedido: </td>
                    <td>${total}</td>
                </tr>
	    </tbody>
	</table>
	
    </body>
</html>
