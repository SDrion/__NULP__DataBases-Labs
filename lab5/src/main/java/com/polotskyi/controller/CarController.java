package com.polotskyi.controller;

import com.polotskyi.model.dao.CarDao;
import com.polotskyi.model.entity.Car;

import java.sql.SQLException;
import java.util.List;

public class CarController implements IGenController<Car> {
    private static final CarDao dao = new CarDao();

    public CarController() {

    }

    @Override
    public List<Car> findAll() {
        return dao.findAll();
    }

    @Override
    public Car find(Integer id) {
        return dao.find(id);
    }

    @Override
    public void create(Car car) throws SQLException {
        dao.create(car);
    }

    @Override
    public void update(Integer id, Car car) {
        dao.update(id, car);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }
}
