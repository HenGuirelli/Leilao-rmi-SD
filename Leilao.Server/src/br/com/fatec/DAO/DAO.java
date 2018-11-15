package br.com.fatec.DAO;

public interface DAO<T> {
    public void insert(T obj);
    public void update(T obj);
    public void select(T obj);
    public void delete(T obj);
}
