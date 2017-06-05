/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lppo.servlet;

import br.cesjf.lppo.classe.Item;
import br.cesjf.lppo.dao.ItemDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alunoces
 */
@WebServlet(name = "CriarItemServlet", urlPatterns = {"/NovoItem.html"})
public class CriarItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        request.getRequestDispatcher("WEB-INF/novo-item.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Item pedido = new Item();
	pedido.setPedido(Long.parseLong(request.getParameter("pedido")));
	pedido.setDono(request.getParameter("dono"));
	pedido.setValor(Double.parseDouble(request.getParameter("valor")));
	pedido.setDescricao(request.getParameter("descricao"));

	try {
            ItemDAO dao = new ItemDAO();
	    dao.cria(pedido);
	} catch (Exception ex) {
	    request.setAttribute("mensagem", ex);
	    request.getRequestDispatcher("WEB-INF/novo-item.jsp").forward(request, response);
	    return;
	}
  
	response.sendRedirect("Itens.html");
    }
      
    }

   


