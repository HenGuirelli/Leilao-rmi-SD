package br.com.fatec.DAO;

import br.com.fatec.exceptions.ContaInexistenteException;
import java.sql.SQLException;

public interface DAO<T> {
    public void insert(T obj) throws ClassNotFoundException, SQLException;
    public void update(T obj) throws ClassNotFoundException, SQLException;
    public T    select(T obj) throws ClassNotFoundException, SQLException, ContaInexistenteException;
    public void delete(T obj) throws ClassNotFoundException, SQLException;
}
