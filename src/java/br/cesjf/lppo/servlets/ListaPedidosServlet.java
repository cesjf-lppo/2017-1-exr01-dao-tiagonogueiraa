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
@WebServlet(name = "ListaPedidosServlet", urlPatterns = {"/pedidos.html"})
public class ListaPedidosServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
	List<Pedido> pedidos;
	
	try {
            PedidoDAO dao = new PedidoDAO();
	    pedidos = dao.listAll();
	} catch (Exception ex) {
	    Logger.getLogger(ListaPedidosServlet.class.getName()).log(Level.SEVERE, null, ex);
	    pedidos = new ArrayList<>();
	    request.setAttribute("mensagem", ex.getLocalizedMessage());
	}
	
	request.setAttribute("pedidos", pedidos );
	request.getRequestDispatcher("WEB-INF/lista-pedido.jsp").forward(request, response);
	
    }

   
 

   

}
