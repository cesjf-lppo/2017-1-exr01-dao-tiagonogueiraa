/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lppo.servlets;

import br.ces.lppo.classe.Pedido;
import br.ces.lppo.dao.PedidoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alunoces
 */
@WebServlet(name = "CriaPedidoServlet", urlPatterns = {"/pedido.html"})
public class CriaPedidoServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        request.getRequestDispatcher("WEB-INF/novo-pedido.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	
	Pedido pedido = new Pedido();
	pedido.setPedido(Long.parseLong(request.getParameter("pedido")));
	pedido.setDono(request.getParameter("dono"));
	pedido.setValor(Double.parseDouble(request.getParameter("valor")));
	pedido.setNome(request.getParameter("nome"));

	try {
            PedidoDAO dao = new PedidoDAO();
	    dao.cria(pedido);
	} catch (Exception ex) {
	    request.setAttribute("mesangem", ex);
	    request.getRequestDispatcher("WEB-INF/novo-pedido.jsp").forward(request, response);
	    return;
	}
  
	response.sendRedirect("pedidos.html");
    }

 

}
