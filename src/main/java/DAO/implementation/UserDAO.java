package DAO.implementation;

import DAO.IGeneralDAO;
import model.implementation.User;
import persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDAO implements IGeneralDAO<User, Integer> {
    private static final String GET_ALL = "SELECT * FROM polotskyi_lab3.user";
    private static final String GET_BY_ID = "SELECT * FROM polotskyi_lab3.user WHERE id=?";
    private static final String CREATE =  "INSERT polotskyi_lab3.user "
            + "(id, first_name, last_name, phone_number, email, passport_number, driver_license_number, status, password_sha256) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE polotskyi_lab3.user " +
            "SET id=?, first_name=?, last_name=?, phone_number=?, email=?, passport_number=?, drivers_license_number=?, status=?, password=? WHERE id=?";
    private static final String DELETE = "DELETE FROM polotskyi_lab3.user WHERE id=?";

    @Override
    public final List<User> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<User> users = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String first_name = resultSet.getString(2);
                    String last_name = resultSet.getString(3);
                    String phone_number = resultSet.getString(4);
                    String email = resultSet.getString(5);
                    String passport_number = resultSet.getString(6);
                    String drivers_license_number = resultSet.getString(7);
                    String status = resultSet.getString(8);
                    String password = resultSet.getString(9);
                    users.add(new User(id, first_name, last_name, phone_number, email, passport_number, drivers_license_number, status, password));
                }
            }
        }
        return users;
    }

    @Override
    public final User getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        User user = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String first_name = resultSet.getString(2);
                    String last_name = resultSet.getString(3);
                    String phone_number = resultSet.getString(4);
                    String email = resultSet.getString(5);
                    String passport_number = resultSet.getString(6);
                    String drivers_license_number = resultSet.getString(7);
                    String status = resultSet.getString(8);
                    String password = resultSet.getString(9);
                    user = new User(foundId, first_name, last_name, phone_number, email, passport_number, drivers_license_number, status, password);
                }
            }
        }
        return user;
    }

    @Override
    public final int create(final User entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getFirst_name());
            preparedStatement.setString(3, entity.getLast_name());
            preparedStatement.setString(4, entity.getPhone_number());
            preparedStatement.setString(5, entity.getEmail());
            preparedStatement.setString(6, entity.getPassport_number());
            preparedStatement.setString(7, entity.getDrivers_license_number());
            preparedStatement.setString(8, entity.getStatus());
            preparedStatement.setString(9, entity.getPassword());
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public final int update(final User entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getFirst_name());
            preparedStatement.setString(3, entity.getLast_name());
            preparedStatement.setString(4, entity.getPhone_number());
            preparedStatement.setString(5, entity.getEmail());
            preparedStatement.setString(6, entity.getPassport_number());
            preparedStatement.setString(7, entity.getDrivers_license_number());
            preparedStatement.setString(8, entity.getStatus());
            preparedStatement.setString(9, entity.getPassword());
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public final int delete(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();
        }
    }
}
