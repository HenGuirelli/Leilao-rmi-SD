package br.com.fatec.interfaces;

import br.com.fatec.model.Item;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public interface ILeilaoProvider {
    public void cadastrar(Item obj) throws RemoteException, ClassNotFoundException, SQLException;
    public void remover(Item obj) throws RemoteException, ClassNotFoundException, SQLException;
    public void atualizar(Item obj) throws RemoteException, ClassNotFoundException, SQLException;
    public List<Item> listar() throws RemoteException, ClassNotFoundException, SQLException;
    public void iniciar() throws RemoteException, ClassNotFoundException, SQLException;
}
