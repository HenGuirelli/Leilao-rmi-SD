package br.com.fatec.fake.DAO;

import br.com.fatec.interfaces.IConta;

public class Conta implements IConta{
    private String login;
    private String senha;
    
    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getSenha() {
        return senha;
    }

    @Override
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
