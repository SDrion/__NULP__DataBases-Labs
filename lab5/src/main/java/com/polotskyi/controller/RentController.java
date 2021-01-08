package com.polotskyi.controller;

import com.polotskyi.model.dao.RentDao;
import com.polotskyi.model.entity.Rent;

import java.sql.SQLException;
import java.util.List;

public class RentController  implements IGenController<Rent>{
    private static final RentDao dao = new RentDao();

    public RentController() {

    }

    @Override
    public List<Rent> findAll() {
        return dao.findAll();
    }

    @Override
    public Rent find(Integer id) {
        return dao.find(id);
    }

    @Override
    public void create(Rent rent) throws SQLException {
        dao.create(rent);
    }

    @Override
    public void update(Integer id, Rent rent) {
        dao.update(id, rent);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }
}
