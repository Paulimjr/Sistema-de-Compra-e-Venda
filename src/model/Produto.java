/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Paulo Cesar
 */
public class Produto {

    private long cod;
    private String nome;
    private String tipo;
    private String descricao;
    private double valorc;
    private double valorv;
    public String categoria;
    public static int totalDeprodutos;

    public Produto(int codigo)
    {
        this.cod = codigo;
        
    }
    
    public Produto(){
        totalDeprodutos++;
        setCod(totalDeprodutos);
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorc() {
        return valorc;
    }

    public void setValorc(float valorc) {
        this.valorc = valorc;
    }

    public double getValorv() {
        return valorv;
    }

    public void setValorv(float valorv) {
        this.valorv = valorv;
    }
    public static int getTotalDeprodutos() {
        return totalDeprodutos;
    }

    public static void setTotalDeprodutos(int totalDeprodutos) {
        Produto.totalDeprodutos = totalDeprodutos;
    }

    public Object getVendaCollection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
   
}
