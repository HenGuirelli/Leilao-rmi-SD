package br.com.fatec.DAO;

import br.com.fatec.enums.TipoConta;
import br.com.fatec.exceptions.ContaInexistenteException;
import br.com.fatec.model.Conta;
import br.com.fatec.model.Leiloeiro;
import br.com.fatec.model.Participante;
import br.com.fatec.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO implements DAO<Usuario>{
    private PreparedStatement pst;
    private ResultSet rs;
    
    @Override
    public void insert(Usuario obj) throws ClassNotFoundException, SQLException {
        String sql = "insert into usuario (nome, login, senha) " +
                     "values (?, ?, ?)";
        
        Banco.conectar();
        
        pst = Banco.getConexao().prepareStatement(sql);
        pst.setString(1, obj.getNome());
        pst.setString(2, obj.getConta().getLogin());
        pst.setString(3, obj.getConta().getSenha());
        
        pst.executeUpdate();
        Banco.desconectar();
    }

    @Override
    public void update(Usuario obj) throws ClassNotFoundException, SQLException  {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario select(Usuario obj) throws ClassNotFoundException, SQLException, ContaInexistenteException  {
        Usuario usuario = new Usuario();
        Participante participante;
        Leiloeiro leiloeiro;
        Conta conta = obj.getConta();
        
        Banco.conectar();
        
        String sql = "select * from usuario where login = '" + obj.getConta().getLogin() + 
                "' and senha = '" + obj.getConta().getSenha() + "'";
        System.out.println(sql);
        pst = Banco.getConexao().prepareStatement(sql);
        rs = pst.executeQuery();
        
        if (rs.next()){
            if (rs.getString("tipo_conta").equals("participante")){
                conta.setTipoConta(TipoConta.PARTICIPANTE);
                participante = new Participante();
                participante.setNome(rs.getString("nome"));
                participante.setTotalItensGanhos(rs.getInt("total_itens_ganhos"));
                participante.setTotalLances(rs.getInt("total_lances"));
            }else{
                conta.setTipoConta(TipoConta.LEILOEIRO);
                leiloeiro = new Leiloeiro();
                leiloeiro.setNome(rs.getString("nome"));
            }
        }else{
            throw new ContaInexistenteException();
        }
        usuario.setConta(conta);
        Banco.desconectar();
        return usuario;
    }

    @Override
    public void delete(Usuario obj) throws ClassNotFoundException, SQLException  {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
