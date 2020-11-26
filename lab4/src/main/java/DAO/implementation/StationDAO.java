package DAO.implementation;

import DAO.IGeneralDAO;
import model.implementation.Station;
import persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class StationDAO implements IGeneralDAO<Station, Integer> {
    private static final String GET_ALL = "SELECT * FROM polotskyi_lab3.station";
    private static final String GET_BY_ID = "SELECT * FROM polotskyi_lab3.station WHERE id=?";
    private static final String CREATE =  "INSERT polotskyi_lab3.station "
            + "(id, name, address, city) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE polotskyi_lab3.station " +
            "SET name=?, address=?, city=? WHERE id=?";
    private static final String DELETE = "DELETE FROM polotskyi_lab3.station WHERE id=?";

    @Override
    public final List<Station> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Station> stations = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String address = resultSet.getString(3);
                    String city = resultSet.getString(4);
                    stations.add(new Station(id, name, address, city));
                }
            }
        }
        return stations;
    }

    @Override
    public final Station getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Station station = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String address = resultSet.getString(3);
                    String city = resultSet.getString(4);
                    station = new Station(foundId, name, address, city);
                }
            }
        }
        return station;
    }

    @Override
    public final int create(final Station entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setString(3, entity.getAddress());
            preparedStatement.setString(4, entity.getCity());
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public final int update(final Station entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setString(3, entity.getAddress());
            preparedStatement.setString(4, entity.getCity());
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
