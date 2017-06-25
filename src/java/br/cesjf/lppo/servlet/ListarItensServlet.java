/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lppo.servlet;

import br.cesjf.lppo.classe.Item;
import br.cesjf.lppo.dao.ItemDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 *
 * @author alunoces
 */
@WebServlet(name = "ListarItensServlet", urlPatterns = {"/Itens.html"})
public class ListarItensServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        List<Item> itens;
        
	
        try {
            ItemDAO dao = new ItemDAO();
            itens = dao.listarItens();
	    
        } catch (Exception ex) {
            Logger.getLogger(ListarItensServlet.class.getName()).log(Level.SEVERE, null, ex);
            itens = new ArrayList<>();
            request.setAttribute("mensagem", ex.getLocalizedMessage());
            
        }
   
        request.setAttribute("itens", itens );
	request.getRequestDispatcher("WEB-INF/lista-itens.jsp").forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

}
