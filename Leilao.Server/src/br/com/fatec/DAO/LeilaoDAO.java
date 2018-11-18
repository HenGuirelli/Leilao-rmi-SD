package br.com.fatec.DAO;

import br.com.fatec.exceptions.ContaInexistenteException;
import br.com.fatec.model.Conta;
import br.com.fatec.model.Item;
import br.com.fatec.model.Participante;
import br.com.fatec.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LeilaoDAO implements DAO<Item>, Listavel<Item>{
    private PreparedStatement pst;
    private ResultSet rs;
    
    
    @Override
    public void insert(Item obj) throws ClassNotFoundException, SQLException {
        String sql = "insert into item (nome, descricao, valor_atual, valor_inicial, senha) " +
                     "values ('"+obj.getNome()+"', '"+obj.getDescricao()+"', "
                + obj.getValorAtual()+", "+obj.getValoMinimo()+", '"+obj.getSenha()+"')";
        
       Banco.executeUpdate(sql);
    }

    @Override
    public void update(Item obj) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE usuario SET nome = '"+obj.getNome()+"', "
                + "descricao = '"+obj.getDescricao()+"', valor_atual = "+obj.getValorAtual()+", "
                + "valor_inicial = "+obj.getValoMinimo()+", senha = '"+obj.getSenha()+"'";
    }

    @Override
    public Item select(Item obj) throws ClassNotFoundException, SQLException, ContaInexistenteException {        
        Banco.conectar();
        Item item;
        
        String sql = "select * from item where id = ?";
        pst = Banco.getConexao().prepareStatement(sql);
        pst.setInt(1, obj.getId());
        rs = pst.executeQuery();
        
        if (rs.next()){
           item = new Item(rs.getString("descricao"), rs.getFloat("valor_minimo"), rs.getString("senha"));
           item.setValorAtual(rs.getFloat("valor_atual"));
           if (rs.getString("vencedor") != null){
               Usuario usuario = new Usuario();
               Conta conta = new Conta();
               conta.setLogin(rs.getString("vencedor"));
               usuario.setConta(conta);
               item.setVencedor((Participante)new UsuarioDAO().select(usuario));
           }
        }else{
            throw new ContaInexistenteException();
        }
        //usuario.setConta(conta);
        Banco.desconectar();
        return item;
    }

    @Override
    public void delete(Item obj) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM usuario WHERE id = " + obj.getId();
        Banco.executeUpdate(sql);
    }

    @Override
    public List<Item> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
