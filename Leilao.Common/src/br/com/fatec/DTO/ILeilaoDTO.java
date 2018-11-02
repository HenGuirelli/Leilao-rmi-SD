package br.com.fatec.DTO;

import br.com.fatec.model.Item;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ILeilaoDTO extends Remote {
    public void cadastrar(Item item) throws RemoteException;
    public void remover(Item item) throws RemoteException;
    public void encerrar() throws RemoteException;
    public void inciciar() throws RemoteException;
    public List<Item> listar() throws RemoteException;
}
