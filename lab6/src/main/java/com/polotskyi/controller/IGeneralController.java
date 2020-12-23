package com.polotskyi.controller;

import com.polotskyi.service.IGeneralService;

import java.util.List;

public interface IGeneralController<T> {
    IGeneralService<T> getService();
    List<T> findAll();
    T findById(Integer id);
    void create(T t);
    void update(Integer id, T t);
    void delete(Integer id);
}
