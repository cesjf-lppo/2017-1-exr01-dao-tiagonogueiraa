/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ces.lppo.dao;

import br.ces.lppo.classe.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author tiago
 */
public class ItemDAO {
          private PreparedStatement opNovo;
          private PreparedStatement opListar;
          private PreparedStatement opListarPorPedido;
          private PreparedStatement opListarPedidos;
          
          
    public ItemDAO() throws Exception {
        
        Connection conexao = ConnectionFactory.createConnection();
        opNovo = conexao.prepareStatement("INSERT INTO item (pedido, dono, valor, nome) VALUES(?,?,?,?)");
        opListar = conexao.prepareStatement("SELECT * FROM item");
        opListarPorPedido = conexao.prepareStatement("SELECT * FROM item WHERE pedido = ?");
        opListarPedidos = conexao.prepareStatement("SELECT DISTINCT pedido FROM item GROUP BY pedido");
}
    
    public List<Item> listAll() throws Exception {
	try {
	    List<Item> pedidos = new ArrayList<>();
	    ResultSet resultado = opListar.executeQuery();
            
	    while (resultado.next()){
		Item pedido = new Item();
		pedido.setId(resultado.getLong("id"));
		pedido.setPedido(resultado.getLong("pedido"));
		pedido.setDono(resultado.getString("dono"));
		pedido.setValor(resultado.getDouble("valor"));
		pedido.setNome(resultado.getString("nome"));
		
		pedidos.add(pedido);
		}
            
	    return pedidos;
            
	} catch (SQLException ex){
	    throw new Exception("Erro ao listar o itens!", ex);
	}
	
    }
    
        public List<Item> listByPedido(Long id) throws Exception {
	try {
	    List<Item> pedidos = new ArrayList<>();
            opListarPorPedido.setLong(1, id);
	    ResultSet resultado = opListarPorPedido.executeQuery();
            
	    while (resultado.next()){
		Item pedido = new Item();
		pedido.setId(resultado.getLong("id"));
		pedido.setPedido(resultado.getLong("pedido"));
		pedido.setDono(resultado.getString("dono"));
		pedido.setValor(resultado.getDouble("valor"));
		pedido.setNome(resultado.getString("nome"));
		
		pedidos.add(pedido);
		}
            
	    return pedidos;
            
	} catch (SQLException ex){
	    throw new Exception("Erro ao listar o pedido!", ex);
	}
	
    }
        
        
    
       public void cria(Item pedido) throws Exception {
        try {
            
            opNovo.setLong(1, pedido.getPedido());
            opNovo.setString(2, pedido.getDono());
            opNovo.setDouble(3, pedido.getValor());
            opNovo.setString(4, pedido.getNome());
            opNovo.executeUpdate();


        } catch (SQLException ex) {
            throw new Exception("Erro ao inserir o pedido!", ex);
        }

    }

}
