package br.com.fatec.testes;

import br.com.fatec.DAO.*;
import br.com.fatec.enums.TipoConta;
import br.com.fatec.exceptions.ContaInexistenteException;
import br.com.fatec.model.Conta;
import br.com.fatec.model.Item;
import br.com.fatec.model.Usuario;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteDAO {
    public static void main(String[] args){
        try {
            /* Teste Usuario */
            // cria DAO
            UsuarioDAO dao = new UsuarioDAO();
            // cria Usuario
            Usuario usuario = new Usuario();
            Conta conta = new Conta();
            
            conta.setLogin("login@email.com");
            conta.setSenha("senha123");
            usuario.setConta(conta);
            
            dao.delete(usuario);
            dao.insert(usuario);
            usuario.getConta().setLogin("login@email.com");
            dao.update(usuario);
            
            usuario.setId(0);
            usuario = dao.select(usuario);
            System.out.println("-------------Usuario-------------");
            System.out.println("nome: " + usuario.getNome());
            System.out.println("login: " + usuario.getConta().getLogin());
            System.out.println("tipo conta: " + usuario.getConta().getTipoConta());
            
            /* Teste item */
            LeilaoDAO dao2 = new LeilaoDAO();
            Item item = new Item("descrição 1", 10, "senha123");
            dao2.delete(item);            
            dao2.insert(item);
            
            item = dao2.select(item);
            System.out.println("-------------Item-------------");
            System.out.println("nome: " + item.getNome());
            System.out.println("Descrição: " + item.getDescricao());
            
        } catch (ClassNotFoundException | SQLException | ContaInexistenteException ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
        }
    }
}
