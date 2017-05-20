<%-- 
    Document   : lista-por-pedido
    Created on : 19/05/2017, 21:55:41
    Author     : alunoces
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Itens por pedido</h1>
        
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
                <c:forEach var="item" items="${itens}">
                    <tr>
                        <td><a href="detalhes.html?id=${item.id}">${item.id}</a></td>
                        <td>${item.pedido}</td>
                        <td>${item.dono}</td>
                        <td>${item.valor}</td>
                        <td>${item.nome}</td>
                    </tr>
                    
                </c:forEach>           
            </tbody>
        </table>
    </body>
</html>
