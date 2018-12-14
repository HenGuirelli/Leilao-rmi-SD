package br.com.fatec.provider;

import br.com.fatec.DAO.LeilaoDAO;
import br.com.fatec.interfaces.ILeilaoProvider;
import br.com.fatec.model.Item;
import br.com.fatec.model.Leilao;
import br.com.fatec.model.Participante;
import br.com.fatec.model.Usuario;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeilaoProvider implements ILeilaoProvider {
    private Leilao leilao = new Leilao();
    private LeilaoDAO dao = new LeilaoDAO();
    
    @Override
    public void cadastrar(Item item) throws RemoteException, ClassNotFoundException, SQLException {
        try {
            dao.insert(item);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LeilaoProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(Item item) throws RemoteException, ClassNotFoundException, SQLException  {
        dao.delete(item);
    }

    public void encerrar(Participante vencedor, Item item) throws RemoteException {
        
    }

    @Override
    public List<Item> listar() throws RemoteException, ClassNotFoundException, SQLException {
        return dao.listar();
    }

    @Override
    public void atualizar(Item obj) throws RemoteException, ClassNotFoundException, SQLException {
        dao.update(obj);
    }

    @Override
    public void iniciar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
