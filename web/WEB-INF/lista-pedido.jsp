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
        <title>Lista de pedidos</title>
    </head>
    <body>
        <h1>Lista de Pedidos</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Numero</th>
                    <th>Dono</th>
                    <th>Valor</th>
                    <th>Descricao</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="pedido" items="${pedidos}">
                    <tr>
                        <td><a href="detalhes.html?id=${pedido.id}">${pedido.id}</a><td>
                        <td>${pedido.pedido}</td>
                        <td>${pedido.dono}</td>
                        <td>${pedido.valor}</td>
                        <td>${pedido.nome}</td>
                        
                </c:forEach>            </tbody>
        </table>   </body>
</html>
