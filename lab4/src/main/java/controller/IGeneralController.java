package controller;

import service.IGeneralService;

import java.sql.SQLException;

public interface IGeneralController<T> {

    void create(T entity) throws SQLException;
    void update(T entity) throws SQLException;
    void delete(int id) throws SQLException;
    void getAll() throws SQLException;
    void getById(int id) throws SQLException;

    IGeneralService<T> getService();

}