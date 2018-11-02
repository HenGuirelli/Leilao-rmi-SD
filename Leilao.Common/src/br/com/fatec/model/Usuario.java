package br.com.fatec.model;

public class Usuario implements java.io.Serializable {
    private Conta conta;

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
