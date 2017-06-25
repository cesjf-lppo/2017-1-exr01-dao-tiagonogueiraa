<%-- 
    Document   : lista-pedido-dono
    Created on : 25/06/2017, 19:08:10
    Author     : tiago
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Pedido Dono</title>
    </head>
    <body>
	<%@include file="jspf/menu.jspf" %>
        <h1>Lista Pedido Dono</h1>
	
	<table>
	    <tr>
		<th>Id</th>
		<th>Pedido</th>
		<th>Dono</th>
		<th>Valor</th>
		<th>Nome</th>
		<th>Atualizacao</th>
	    </tr>
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
		
		<th>
		<td colspan="5">Total: </td>
		<td>${total}</td>
		</th>
	</table>
	
	
    </body>
</html>
