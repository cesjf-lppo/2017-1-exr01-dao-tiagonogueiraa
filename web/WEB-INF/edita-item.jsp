<%-- 
    Document   : edita-item
    Created on : 31/05/2017, 14:46:07
    Author     : tiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edita Item</title>
    </head>
    <body>
        <h1>Edita Item</h1>
	<form method="post">
	    <input type="hidden" name="id" value="${item.id}"/>
	    <label>Pedido: <input type="text" name="pedido" value="${item.pedido}" size="10"/></label><br><br>
	    <label>Dono: <input type="text" name="dono" value="${item.dono}" size="30"/> </label><br><br>
	    <label>Valor: <input type="number" name="valor" value="${item.valor}" size="10"/> </label><br><br>
	    <label>Descrição: <input type="text" name="descricao"  size="30" value="${item.descricao}"/></label><br><br>
            </p>   
	    <label><input type="submit" value="Gravar" /></label>
	    <label><input type="reset" value="Limpar" /></label>
	</form>
    </body>
</html>
