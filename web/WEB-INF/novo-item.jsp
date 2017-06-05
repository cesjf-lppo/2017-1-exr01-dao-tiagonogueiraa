<%-- 
    Document   : novo-pedido
    Created on : 08/05/2017, 21:38:08
    Author     : alunoces
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Item</title>
    </head>
    <body>
        <%@include file="jspf/menu.jspf" %>
        <h1>Novo item: </h1>
        ${mensagem}
        <form method="post">
            <p>
                <label>Pedido: <input type="text" name="pedido" placeholder="Numero pedido" size="10"/></label><br><br>
                <label>Dono: <input type="text" name="dono" placeholder="Dono" size="30"/> </label><br><br>
                <label>Valor: <input type="number" name="valor" placeholder="00,00" size="10"/> </label><br><br>
                <label>Descrição: <input type="text" name="descricao" placeholder="Nome" size="30"/></label><br><br>
            </p>   
	    <label><input type="submit" value="Gravar" /></label>
	    <label><input type="reset" value="Limpar" /></label>

        </form>
    </body>
</html>
