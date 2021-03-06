package com.polotskyi.controller;

import java.sql.SQLException;
import java.util.List;

public interface IGenController<T> {

    List<T> findAll() throws SQLException;

    T find(Integer id) throws SQLException;

    void create(T entity) throws SQLException;

    void update(Integer id, T entity) throws SQLException;

    void delete(Integer id) throws SQLException;
}
