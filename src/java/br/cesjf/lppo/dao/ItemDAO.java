/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lppo.dao;

import br.cesjf.lppo.classe.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cpd
 */
public class ItemDAO {
    
    private PreparedStatement opNovo;
    private PreparedStatement opListar;
    private PreparedStatement opListarPorPedido;
    private PreparedStatement opTotalValorPedido;
    private PreparedStatement opTotalValorPorDono;
    private PreparedStatement opAtualiza;
    private PreparedStatement opBuscaPorId;
    
    
    public ItemDAO() throws Exception {
        Connection conexao = ConnectionFactory.createConnection();
        
        opNovo = conexao.prepareStatement("INSERT INTO item (pedido,dono,valor,descricao) VALUES(?,?,?,?)");
        opListar = conexao.prepareStatement("SELECT * FROM item");
        opListarPorPedido = conexao.prepareStatement("SELECT * FROM item WHERE pedido = ? ");
        opTotalValorPedido = conexao.prepareStatement("SELECT SUM(valor) FROM item WHERE pedido = ?");
        opTotalValorPorDono = conexao.prepareStatement("SELECT SUM(valor) FROM item WHERE dono = ?");
        opAtualiza = conexao.prepareStatement("UPDATE item SET pedido = ?, dono = ?, valor = ?, descricao = ?, atualizacao = CURRENT_TIMESTAMP WHERE id = ?");
        opBuscaPorId = conexao.prepareStatement("SELECT * FROM item WHERE id=?");
	
        
        
        
    }   
    

    public void cria(Item pedido) throws Exception {
        try {
            
            opNovo.setLong(1, pedido.getPedido());
            opNovo.setString(2, pedido.getDono());
            opNovo.setDouble(3, pedido.getValor());
            opNovo.setString(4, pedido.getDescricao());
            opNovo.executeUpdate();


        } catch (SQLException ex) {
            throw new Exception("Erro ao inserir o pedido!", ex);
        }

    }

    public List<Item> listarItens() throws Exception {
        try {
            List<Item> itens = new ArrayList<>();
            ResultSet resultado = opListar.executeQuery();
            
            while(resultado.next()){
                
                Item item = new Item();
                item.setId(resultado.getLong("id"));
                item.setPedido(resultado.getLong("pedido"));
                item.setDono(resultado.getString("dono"));
                item.setValor(resultado.getDouble("valor"));
                item.setDescricao(resultado.getString("descricao"));
                
                itens.add(item);            
        }
            
            return itens;
        } catch (SQLException ex) {
            throw new Exception("Erro ao listar itens", ex);
        }
        
        
    }
    
    public List<Item> listarItemPorPedido(Long pedido) throws Exception {
	try{
	    List<Item> itens = new ArrayList<>();
	    opListarPorPedido.setLong(1, pedido);
	    ResultSet resultado = opListarPorPedido.executeQuery();
	    
	    while(resultado.next()){
                
                Item item = new Item();
                item.setId(resultado.getLong("id"));
                item.setPedido(resultado.getLong("pedido"));
                item.setDono(resultado.getString("dono"));
                item.setValor(resultado.getDouble("valor"));
                item.setDescricao(resultado.getString("descricao"));
                item.setDataEHora(resultado.getTimestamp("atualizacao"));
		
                itens.add(item);      
	}
	    return itens;
    } catch (SQLException ex) {
	throw new Exception("Erro ao listar itens por pedido", ex);
    }
    }
    
    public Item getById(Long id) throws Exception {
        try {
            Item item = null;
            opBuscaPorId.clearParameters();
            opBuscaPorId.setLong(1, id);
            ResultSet resultado = opBuscaPorId.executeQuery();

            while (resultado.next()) {
                item = new Item();
                item.setId(resultado.getLong("id"));
		item.setPedido(resultado.getLong("pedido"));
                item.setDono(resultado.getString("dono"));
                item.setValor(resultado.getDouble("valor"));
                item.setDescricao(resultado.getString("descricao"));
                item.setDataEHora(resultado.getDate("atualizacao"));

               
            }

            return item;
        } catch (SQLException ex) {
            throw new Exception("Erro ao buscar um contato no listar!", ex);
        }
    }
    
    public void atualiza(Item item) throws Exception {
	try {
	    opAtualiza.clearParameters();
	    opAtualiza.setLong(1, item.getPedido());
	    opAtualiza.setString(2, item.getDono());
	    opAtualiza.setDouble(3, item.getValor());
	    opAtualiza.setString(4, item.getDescricao());
	    opAtualiza.setLong(5, item.getId());
	    opAtualiza.executeUpdate();
	} catch (SQLException ex) {
	    throw new Exception("Erro ao inserir item", ex);
	}
	
    }

    

    public float calcularTotalPedido(Long numPedido) throws Exception {
	try{
         float valor = 0;
         opTotalValorPedido.setLong(1, numPedido);
         ResultSet resultado = opTotalValorPedido.executeQuery();
         while(resultado.next()){
            valor = resultado.getFloat(1);
         }
         return valor;
     }catch (SQLException ex){
            throw new Exception("Erro ao cao calcular valor pedido", ex);
     }
    }
    
    
    
}
    
    
    
    
    

