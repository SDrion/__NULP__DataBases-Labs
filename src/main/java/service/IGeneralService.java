package service;

import DAO.IGeneralDAO;

import java.sql.SQLException;
import java.util.List;

public interface IGeneralService<T> {
    IGeneralDAO<T, Integer> getDAO();

    List<T> getAll() throws SQLException;
    T getById(Integer id) throws SQLException;
    int create(T entity) throws SQLException;
    int update(T entity) throws SQLException;
    int delete(Integer id) throws  SQLException;
}