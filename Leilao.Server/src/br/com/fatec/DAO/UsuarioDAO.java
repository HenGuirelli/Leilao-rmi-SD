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
import java.text.MessageFormat;

public class UsuarioDAO implements DAO<Usuario>{
    private PreparedStatement pst;
    private ResultSet rs;    
    @Override
    public void insert(Usuario obj) throws ClassNotFoundException, SQLException {
        String sql = 
                "INSERT INTO usuario (nome, login, senha) " +
                "VALUES ('"+obj.getNome()+"', '"+obj.getConta().getLogin()+
                         "', '"+obj.getConta().getSenha()+"')";
        Banco.executeUpdate(sql);
    }

    @Override
    public void update(Usuario obj) throws ClassNotFoundException, SQLException  {
        Conta conta = obj.getConta();
        Banco.executeUpdate("UPDATE usuario SET nome = '"+obj.getNome()+"', "
                + "login = '"+conta.getLogin()+"', senha = '"+conta.getSenha()+"' "
                + "WHERE login = '"+conta.getLogin()+"'");
    }

    @Override
    public Usuario select(Usuario obj) throws ClassNotFoundException, SQLException, ContaInexistenteException  {
        Usuario usuario = new Usuario();
        Participante participante;
        Leiloeiro leiloeiro;
        Conta conta = obj.getConta();
        String sql = 
                "SELECT * FROM usuario WHERE login = '"+conta.getLogin()+"' AND senha = '"+conta.getSenha()+"'";        

        Banco.conectar();
        PreparedStatement pst = Banco.getConexao().prepareStatement(sql);
        rs = pst.executeQuery();
        
        if (rs.next()){
            if (rs.getString("tipo_conta").equals("participante")){            
                conta.setTipoConta(TipoConta.PARTICIPANTE);
                participante = new Participante();
                participante.setNome(rs.getString("nome"));
                participante.setTotalItensGanhos(rs.getInt("total_itens_ganhos"));
                participante.setTotalLances(rs.getInt("total_lances"));
                usuario = participante;
            }else{
                conta.setTipoConta(TipoConta.LEILOEIRO);
                leiloeiro = new Leiloeiro();
                leiloeiro.setNome(rs.getString("nome"));
                leiloeiro.setId(rs.getInt("id"));
                usuario =  leiloeiro;
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
        Conta conta = obj.getConta();
        String sql = "DELETE FROM usuario WHERE login = '"+conta.getLogin()+"'";
        Banco.executeUpdate(sql);
    }

}
