package br.com.fatec.testes;

import br.com.fatec.DAO.*;
import br.com.fatec.enums.TipoConta;
import br.com.fatec.exceptions.ContaInexistenteException;
import br.com.fatec.model.Conta;
import br.com.fatec.model.Item;
import br.com.fatec.model.Participante;
import br.com.fatec.model.Usuario;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;
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
            usuario.setNome("Rodolfo");
            dao.update(usuario);
            
            usuario = dao.select(usuario);
            System.out.println("-------------Usuario-------------");
            System.out.println("nome: " + usuario.getNome());
            System.out.println("login: " + usuario.getConta().getLogin());
            System.out.println("tipo conta: " + usuario.getConta().getTipoConta());
            
            /* Teste item */
            LeilaoDAO dao2 = new LeilaoDAO();
            Item item = new Item("nome 1", 10, "senha123");
            dao2.delete(item);            
            dao2.insert(item);
            item.setVencedor((Participante)usuario);
            dao2.update(item);
            List<Item> itens = dao2.listar();
            for (Item _item : itens){
                System.out.println("-------------Item-------------");
                System.out.println("nome: " + _item.getNome());
                System.out.println("Descrição: " + _item.getDescricao());
                System.out.println("id: " + _item.getId());
                dao2.delete(_item);
            }
        } catch (ClassNotFoundException | SQLException | ContaInexistenteException ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
        }
    }
}
