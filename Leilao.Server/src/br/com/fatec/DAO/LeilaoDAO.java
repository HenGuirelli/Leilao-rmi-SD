package br.com.fatec.DAO;

import br.com.fatec.exceptions.ContaInexistenteException;
import br.com.fatec.model.Conta;
import br.com.fatec.model.Item;
import br.com.fatec.model.Participante;
import br.com.fatec.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeilaoDAO implements DAO<Item>, Listavel<Item>{
    private PreparedStatement pst;
    private ResultSet rs;
    
    public int ultimoID() throws ClassNotFoundException, SQLException {
        String sql = "select max(id) as maior_id from item";
        Banco.conectar();
        
        pst = Banco.getConexao().prepareStatement(sql);
        rs = pst.executeQuery();        
        rs.next();
        
        int resp = rs.getInt("maior_id");       
        Banco.desconectar();
        return resp;
    }
    
    @Override
    public void insert(Item obj) throws ClassNotFoundException, SQLException {
       String sql = "insert into item (nome, descricao, valor_atual, valor_inicial, senha) " +
                     "values ('"+obj.getNome()+"', '"+obj.getDescricao()+"', "
                + obj.getValorAtual()+", "+obj.getValoMinimo()+", '"+obj.getSenha()+"')";
        
       Banco.executeUpdate(sql);
       obj.setId(ultimoID());
    }

    @Override
    public void update(Item obj) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE item SET nome = '"+obj.getNome()+"', "
                + "descricao = '"+obj.getDescricao()+"', valor_atual = "+obj.getValorAtual()+", "
                + "valor_inicial = "+obj.getValoMinimo()+", senha = '"+obj.getSenha()+"', "
                + "vencedor = '"+obj.getVencedor().getConta().getLogin()+"'"
                + "WHERE id = " + obj.getId();
        System.out.println(sql);
        Banco.executeUpdate(sql);
    }

    @Override
    public Item select(Item obj) throws ClassNotFoundException, SQLException {        
        Banco.conectar();
        Item item = null;
        
        String sql = "select * from item where id = ?";
        pst = Banco.getConexao().prepareStatement(sql);
        pst.setInt(1, obj.getId());
        rs = pst.executeQuery();
        
        if (rs.next()){
           item = new Item(rs.getString("nome"), rs.getFloat("valor_minimo"), rs.getString("senha"));
           item.setValorAtual(rs.getFloat("valor_atual"));
           item.setDescricao(rs.getString("descricao"));
           item.setId(rs.getInt("id"));
           if (rs.getString("vencedor") != null){
               Usuario usuario = new Usuario();
               Conta conta = new Conta();
               conta.setLogin(rs.getString("vencedor"));
               usuario.setConta(conta);
               try{
                    item.setVencedor((Participante)new UsuarioDAO().select(usuario));
               }catch (ContaInexistenteException ex) {}
           }
        }
        //usuario.setConta(conta);
        Banco.desconectar();
        return item;
    }

    @Override
    public void delete(Item obj) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE item SET em_leilao = false WHERE id = " + obj.getId();
        Banco.executeUpdate(sql);
    }

    @Override
    public List<Item> listar() throws ClassNotFoundException, SQLException {
        List<Item> resp = new ArrayList<>();
        
        Banco.conectar();
        Item item = null;
        
        String sql = "select * from item";
        pst = Banco.getConexao().prepareStatement(sql);
        rs = pst.executeQuery();
        
        while (rs.next()){
           if (!rs.getBoolean("em_leilao")) { continue; }
           item = new Item(rs.getString("nome"), rs.getFloat("valor_inicial"), rs.getString("senha"));
           item.setValorAtual(rs.getFloat("valor_atual"));
           item.setDescricao(rs.getString("descricao"));
           item.setId(rs.getInt("id"));
           if (rs.getString("vencedor") != null){
               Usuario usuario = new Usuario();
               Conta conta = new Conta();
               conta.setLogin(rs.getString("vencedor"));               
               usuario.setConta(conta);
               try{
                   Participante participante = (Participante)new UsuarioDAO().select(usuario);
                   System.out.println(participante + "aaaaaaa");
                   item.setVencedor(participante);
               }catch (ContaInexistenteException ex) {}
           }
           resp.add(item);
        }
        //usuario.setConta(conta);
        Banco.desconectar();
        return resp;
    }
}
