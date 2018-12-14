package br.com.fatec.DAO;

import java.sql.SQLException;
import java.util.List;

public interface Listavel<T> {
    public List<T> listar() throws ClassNotFoundException, SQLException;
}
