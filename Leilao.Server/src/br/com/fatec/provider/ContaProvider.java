package br.com.fatec.provider;

import br.com.fatec.DAO.UsuarioDAO;
import br.com.fatec.exceptions.ContaExisteException;
import br.com.fatec.model.Conta;
import br.com.fatec.exceptions.ContaInexistenteException;
import br.com.fatec.interfaces.ILoginProvider;
import br.com.fatec.model.Participante;
import br.com.fatec.model.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContaProvider implements ILoginProvider {
    
    public void save(Conta conta) throws ContaExisteException{
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario.setConta(conta);
        try {
            dao.insert(usuario);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Usuario signIn(Conta conta) {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            Usuario u = new Participante();
            u.setConta(conta);
            u = dao.select(u);
            return u;
        } catch (ClassNotFoundException | SQLException | ContaInexistenteException ex) {
            Logger.getLogger(ContaProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void update(Conta conta) {
        /* nada a fazer */
    }   
}
