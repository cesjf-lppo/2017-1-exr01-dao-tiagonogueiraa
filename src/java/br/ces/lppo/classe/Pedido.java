/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ces.lppo.classe;

import java.util.Date;

/**
 *
 * @author alunoces
 */
public class Pedido {
    
    private Long id;
    private Long pedido;
    private String dono;
    private double valor;
    private String nome;
    private Date dataEHora;

    public Pedido() {
        id = null;
        pedido = null;
        dono = null;
        valor = 0;
        nome = null;
        dataEHora = null;
        
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataEHora() {
        return dataEHora;
    }

    public void setDataEHora(Date dataEHora) {
        this.dataEHora = dataEHora;
    }
    
    
    
    
    
}
