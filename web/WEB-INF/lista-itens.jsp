<%-- 
    Document   : lista-pedido
    Created on : 15/05/2017, 21:23:31
    Author     : alunoces
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Itens</title>
    </head>
    <body>
        <%@include file="jspf/menu.jspf" %>
        <h1>Lista de Itens</h1>
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
                <c:forEach var="item" items="${itens}">
                    <tr>
                        <td><a href="atualizaItem.html?id=${item.id}">${item.id}</a></td>
                        <td><a href="itensPorPedido.html?pedido=${item.pedido}">${item.pedido}</a></td>
                        <td><a href="listaPorDono.html?dono=${item.dono}">${item.dono}</a></td>
                        <td>${item.valor}</td>
                        <td>${item.descricao}</td>
			<td>${item.dataEHora}</td>
                    </tr>
                    
                </c:forEach>           
            </tbody>
        </table>   </body>
</html>
