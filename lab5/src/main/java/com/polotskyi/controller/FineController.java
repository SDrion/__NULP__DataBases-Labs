package com.polotskyi.controller;

import com.polotskyi.model.dao.FineDao;
import com.polotskyi.model.entity.Fine;

import java.sql.SQLException;
import java.util.List;

public class FineController implements IGenController<Fine> {
    private static final FineDao dao = new FineDao();

    public FineController() {

    }

    @Override
    public List<Fine> findAll() {
        return dao.findAll();
    }

    @Override
    public Fine find(Integer id) {
        return dao.find(id);
    }

    @Override
    public void create(Fine fine) throws SQLException {
        dao.create(fine);
    }

    @Override
    public void update(Integer id, Fine fine) {
        dao.update(id, fine);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }
}
