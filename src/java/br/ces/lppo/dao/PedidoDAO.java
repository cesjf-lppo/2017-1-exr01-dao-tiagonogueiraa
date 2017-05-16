/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ces.lppo.dao;

import br.ces.lppo.classe.Pedido;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.jms.ConnectionFactory;

/**
 *
 * @author tiago
 */
public class PedidoDAO {
            private PreparedStatement opNovo;
    public PedidoDAO() throws Exception {
        
        Connection conexao = ConnectionFactory.createConnection();
      opNovo = conexao.prepareStatement("INSERT INTO pedido (pedido, dono, valor, nome) VALUES(?,?,?,?)");
    
}
    
    public List<Pedido> listAll() throws Exception {
	try {
	    List<Pedido> pedidos = new ArrayList<>();
	    Class.forName("org.apache.derby.jdbc.ClientDriver");
	    
	    Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "senha");
	    
	    Statement operacao = conexao.createStatement();
	    ResultSet resultado = operacao.executeQuery("SELECT * FROM pedido");
	    while (resultado.next()){
		Pedido pedido = new Pedido();
		pedido.setPedido(Long.parseLong(resultado.getString("pedido")));
		pedido.setDono(resultado.getString("dono"));
		pedido.setValor(Double.parseDouble(resultado.getString("valor")));
		pedido.setNome(resultado.getString("nome"));
		
		pedidos.add(pedido);
		}
	    return pedidos;
	} catch (ClassNotFoundException ex){
	    throw new Exception("Erro ao carregar driver!", ex);
	} catch (SQLException ex){
	    throw new Exception("Erro ao inserir o pedido!", ex);
	}
	
    }

    public void criaPedido(Pedido pedido) throws Exception {
	try {
	    Class.forName("org.apache.derby.jdbc.CLientDriver");
	    Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "senha");
	    Statement operacao = conexao.createStatement();
	    operacao.executeUpdate("INSERT INTO pedido (pedido, dono, valor, nome) VALUES('"
		    + pedido.getNome() + "'"
		    + pedido.getDono() + "'"
		    + pedido.getValor() + "'"
		    + pedido.getNome() + "')");

	} catch (ClassNotFoundException ex) {
	    throw new Exception("Erro ao carregar driver!", ex);
	} catch (SQLException ex){
	    throw new Exception("Erro ao inserir o contato!", ex);
	}

    }
    
       public void cria(Pedido pedido) throws Exception {
        try {

            opPedido.setString(1, pedido.getNome());
            opPedido.setString(2, pedido.getSobrenome());
            opPedido.setString(3, pedido.getTelefone());
            opPedido.executeUpdate();


        } catch (SQLException ex) {
            throw new Exception("Erro ao inserir o pedido!", ex);
        }

    }

}
