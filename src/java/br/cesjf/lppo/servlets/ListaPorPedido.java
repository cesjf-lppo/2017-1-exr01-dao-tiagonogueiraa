/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lppo.servlets;

import br.ces.lppo.classe.Item;
import br.ces.lppo.dao.ItemDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author alunoces
 */
@WebServlet(name = "ListaPorPedido", urlPatterns = {"/ListaPorPedido"})
public class ListaPorPedido extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Item> pedidos;
        
        try {
            ItemDAO dao = new ItemDAO();
            pedidos = dao.listByPedido(Long.parseLong(request.getParameter("pedido")));
        } catch (Exception ex) {
            Logger.getLogger(ListaPorPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
}
