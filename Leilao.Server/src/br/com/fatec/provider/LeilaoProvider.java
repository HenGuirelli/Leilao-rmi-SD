package br.com.fatec.provider;

import br.com.fatec.DAO.LeilaoDAO;
import br.com.fatec.DTO.ILeilaoDTO;
import br.com.fatec.model.Item;
import br.com.fatec.model.Leilao;
import br.com.fatec.model.Participante;
import br.com.fatec.model.Usuario;
import java.rmi.RemoteException;
import java.util.List;

public class LeilaoProvider implements ILeilaoDTO {
    private Leilao leilao = new Leilao();
    private LeilaoDAO dao = new LeilaoDAO();
    
    public void cadastrar(Item item) throws RemoteException {
        //dao.insert(leilao);
    }

    public void remover(Item item) throws RemoteException {
        //dao.delete(item);
    }

    public void encerrar(Participante vencedor, Item item) throws RemoteException {
        
    }

    public void iniciar() throws RemoteException {
        
    }

    public List<Item> listar() throws RemoteException {
        return dao.listar();
    }

    public void darLance(Item item, Usuario usuario, float valor) throws RemoteException {        
        
    }
}
