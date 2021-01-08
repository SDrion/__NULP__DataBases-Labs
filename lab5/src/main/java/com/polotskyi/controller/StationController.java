package com.polotskyi.controller;

import com.polotskyi.model.dao.StationDao;
import com.polotskyi.model.entity.Station;

import java.sql.SQLException;
import java.util.List;

public class StationController implements IGenController<Station> {

    private static final StationDao dao = new StationDao();

    public StationController() {

    }

    @Override
    public List<Station> findAll() {
        return dao.findAll();
    }

    @Override
    public Station find(Integer id) {
        return dao.find(id);
    }

    @Override
    public void create(Station station) throws SQLException {
        dao.create(station);
    }

    @Override
    public void update(Integer id, Station station) {
        dao.update(id, station);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }

}