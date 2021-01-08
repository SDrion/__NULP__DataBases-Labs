package com.polotskyi.controller;

import com.polotskyi.model.dao.UserDao;
import com.polotskyi.model.entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserController implements IGenController<User> {
    private static final UserDao dao = new UserDao();

    public UserController() {

    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User find(Integer id) {
        return dao.find(id);
    }

    @Override
    public void create(User user) throws SQLException {
        dao.create(user);
    }

    @Override
    public void update(Integer id, User user) {
        dao.update(id, user);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }
}
