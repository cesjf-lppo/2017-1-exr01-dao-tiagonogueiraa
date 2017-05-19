/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ces.lppo.dao;

import br.ces.lppo.classe.Pedido;
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
public class PedidoDAO {
          private PreparedStatement opNovo;
          private PreparedStatement opListar;
          
          
    public PedidoDAO() throws Exception {
        
        Connection conexao = ConnectionFactory.createConnection();
        opNovo = conexao.prepareStatement("INSERT INTO pedido (pedido, dono, valor, nome) VALUES(?,?,?,?)");
        opListar = conexao.prepareStatement("SELECT * FROM pedido");
}
    
    public List<Pedido> listAll() throws Exception {
	try {
	    List<Pedido> pedidos = new ArrayList<>();
	    ResultSet resultado = opListar.executeQuery();
            
	    while (resultado.next()){
		Pedido pedido = new Pedido();
		pedido.setPedido(Long.parseLong(resultado.getString("pedido")));
		pedido.setDono(resultado.getString("dono"));
		pedido.setValor(Double.parseDouble(resultado.getString("valor")));
		pedido.setNome(resultado.getString("nome"));
		
		pedidos.add(pedido);
		}
            
	    return pedidos;
            
	} catch (SQLException ex){
	    throw new Exception("Erro ao inserir o pedido!", ex);
	}
	
    }
    
       public void cria(Pedido pedido) throws Exception {
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
