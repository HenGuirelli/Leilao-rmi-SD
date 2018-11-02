package br.com.fatec.model;

import br.com.fatec.enums.TipoConta;
import java.io.Serializable;

public class Conta implements Serializable {
    
    private String login;
    private String senha;
    private TipoConta tipoConta;

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
