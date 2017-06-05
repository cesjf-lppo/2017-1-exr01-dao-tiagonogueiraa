/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lppo.classe;

import java.util.Date;

/**
 *
 * @author alunoces
 */
public class Item {
    
    private Long id;
    private Long pedido;
    private String dono;
    private double valor;
    private String descricao;
    private Date dataEHora;

    public Item() {
        
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPedido() {
        return pedido;
    }

    public void setPedido(Long pedido) {
        this.pedido = pedido;
    }

   
    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public Date getDataEHora() {
        return dataEHora;
    }

    public void setDataEHora(Date dataEHora) {
        this.dataEHora = dataEHora;
    }
    
    
    
    
    
}
