package br.com.fatec.DAO;

import br.com.fatec.enums.TipoConta;
import br.com.fatec.exceptions.ContaInexistenteException;
import br.com.fatec.model.Conta;
import br.com.fatec.model.Item;
import br.com.fatec.model.Leiloeiro;
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
                     "values (?, ?, ?, ?, ?)";
        
        Banco.conectar();
        
        pst = Banco.getConexao().prepareStatement(sql);
        pst.setString(1, obj.getNome());
        pst.setString(2, obj.getDescricao());
        pst.setFloat(3, obj.getValorAtual());
        pst.setFloat(4, obj.getValoMinimo());
        pst.setString(5, obj.getSenha());
        
        pst.executeUpdate();
        Banco.desconectar();
    }

    @Override
    public void update(Item obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item select(Item obj) throws ClassNotFoundException, SQLException, ContaInexistenteException {        
        Banco.conectar();
        Item item = new Item();
        
        String sql = "select * from item where id = ?";
        System.out.println(sql);
        pst = Banco.getConexao().prepareStatement(sql);
        pst.setInt(1, obj.getId());
        rs = pst.executeQuery();
        
        if (rs.next()){
           
        }else{
            throw new ContaInexistenteException();
        }
        usuario.setConta(conta);
        Banco.desconectar();
        return null;
    }

    @Override
    public void delete(Item obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Item> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
