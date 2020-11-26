package DAO.implementation;

import DAO.IGeneralDAO;
import model.implementation.Rent;
import persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class RentDAO implements IGeneralDAO<Rent, Integer> {
    private static final String GET_ALL = "SELECT * FROM polotskyi_lab3.rent";
    private static final String GET_BY_ID = "SELECT * FROM polotskyi_lab3.rent WHERE id=?";
    private static final String CREATE =  "INSERT polotskyi_lab3.rent "
            + "(id, price, status, car_id, user_id) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE polotskyi_lab3.rent " +
            "SET id=?, price=?, status=?, car_id=?, user_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM polotskyi_lab3.rent WHERE id=?";

    @Override
    public final List<Rent> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Rent> rents = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Float price = resultSet.getFloat(2);
                    String status = resultSet.getString(3);
                    Integer car_id = resultSet.getInt(4);
                    Integer station_id = resultSet.getInt(5);
                    rents.add(new Rent(id, price, status, car_id, station_id));
                }
            }
        }
        return rents;
    }

    @Override
    public final Rent getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Rent rent = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    Float price = resultSet.getFloat(2);
                    String status = resultSet.getString(3);
                    Integer car_id = resultSet.getInt(4);
                    Integer station_id = resultSet.getInt(5);
                    rent = new Rent(foundId, price, status, car_id, station_id);
                }
            }
        }
        return rent;
    }

    @Override
    public final int create(final Rent entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setFloat(2, entity.getPrice());
            preparedStatement.setString(3, entity.getStatus());
            preparedStatement.setInt(4, entity.getCar_id());
            preparedStatement.setInt(5, entity.getUser_id());
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public final int update(final Rent entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setFloat(2, entity.getPrice());
            preparedStatement.setString(3, entity.getStatus());
            preparedStatement.setInt(4, entity.getCar_id());
            preparedStatement.setInt(5, entity.getUser_id());
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
