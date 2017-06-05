/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lppo.servlet;

import br.cesjf.lppo.classe.Item;
import br.cesjf.lppo.dao.ItemDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tiago
 */
@WebServlet(name = "AtualizaItemServlet", urlPatterns = {"/atualizaItem.html"})
public class AtualizaItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	try {
	    Long id = Long.parseLong(request.getParameter("id"));

	    ItemDAO dao = new ItemDAO();
	    Item item = dao.getById(id);
	    // achou o objeto, agora desenha ele
	    request.setAttribute("item", item);
	    request.getRequestDispatcher("WEB-INF/edita-item.jsp").forward(request, response);

	} catch (NumberFormatException e) {
	    response.sendRedirect("Itens.html");
	} catch (Exception ex) {
	    Logger.getLogger(AtualizaItemServlet.class.getName()).log(Level.SEVERE, null, ex);
	    response.sendRedirect("Itens.html");
	}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	try {
	    Long id = Long.parseLong(request.getParameter("id"));

	    ItemDAO dao = new ItemDAO();
	    Item item = dao.getById(id);

	    
	    item.setPedido(Long.parseLong(request.getParameter("pedido")));
	    item.setDono(request.getParameter("dono"));
	    item.setValor(Double.parseDouble(request.getParameter("valor")));
	    item.setDescricao(request.getParameter("descricao"));

	    dao.atualiza(item);
	    response.sendRedirect("Itens.html");

	} catch (NumberFormatException e) {
	    response.sendRedirect("Itens.html");
	} catch (Exception ex) {
	    Logger.getLogger(AtualizaItemServlet.class.getName()).log(Level.SEVERE, null, ex);
	    response.sendRedirect("Itens.html");
	}

    }
    
}




