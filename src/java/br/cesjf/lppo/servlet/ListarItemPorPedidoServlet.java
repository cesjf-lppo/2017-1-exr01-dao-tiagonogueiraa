/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lppo.servlet;

import br.cesjf.lppo.classe.Item;
import br.cesjf.lppo.dao.ItemDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ListarItemPorPedido", urlPatterns = {"/itensPorPedido.html"})
public class ListarItemPorPedidoServlet extends HttpServlet {

    
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
	List <Item> pedidos;
	
	Long numPedido = Long.parseLong(request.getParameter("pedido"));
	
	float total = 0;
	try {
	    ItemDAO dao  = new ItemDAO();
	    pedidos = dao.listarItemPorPedido(numPedido);
	    total = dao.calcularTotalPedido(numPedido);
	    
	} catch (Exception ex) {
	    Logger.getLogger(ListarItemPorPedidoServlet.class.getName()).log(Level.SEVERE, null, ex);
	    pedidos = new ArrayList<>();
	    request.setAttribute("mensagem", ex.getLocalizedMessage());
	}
	
//	request.setAttribute("pedido", pedidos);
//	request.getRequestDispatcher("WEB-INF/lista-pedidos.jsp").forward(request, response);
//	
	request.setAttribute("total", total);
	request.setAttribute("pedido", pedidos);
	request.getRequestDispatcher("WEB-INF/lista-pedidos.jsp").forward(request, response);
	
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

    }


}
