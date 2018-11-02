package br.com.fatec.model;

import java.util.Date;

public class Item implements java.io.Serializable {
    private String descricao;
    private float valoMinimo;
    private float valorAtual;
    private Date inicio;
    private Date fim;
    private String senha;
    private Participante vencedor;

    private static int _id = 0;
    
    private int id;
    
    

    public Item(String descricao, float valorMinimo, String senha){
        this.descricao = descricao;
        this.valoMinimo = valorMinimo;
        this.valorAtual = valorMinimo;
        this.senha = senha;
        
        id = _id;
        _id++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public Participante getVencedor() {
        return vencedor;
    }

    public void setVencedor(Participante vencedor) {
        this.vencedor = vencedor;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValoMinimo() {
        return valoMinimo;
    }

    public void setValoMinimo(float valoMinimo) {
        this.valoMinimo = valoMinimo;
    }

    public float getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(float valorAtual) {
        this.valorAtual = valorAtual;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
