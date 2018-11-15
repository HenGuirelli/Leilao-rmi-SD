package br.com.fatec.DTO;

import br.com.fatec.model.Item;
import br.com.fatec.model.Participante;
import br.com.fatec.model.Usuario;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ILeilaoDTO extends Remote {
    public void cadastrar(Item item) throws RemoteException;
    public void remover(Item item) throws RemoteException;
    public void encerrar(Participante vencedor, Item item) throws RemoteException;
    public void iniciar() throws RemoteException;
    public List<Item> listar() throws RemoteException;
    public void darLance(Item item, Usuario usuario, float valor) throws RemoteException;
}
