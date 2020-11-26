package DAO.implementation;

import DAO.IGeneralDAO;

import model.implementation.Car;
import persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CarDAO implements IGeneralDAO<Car, Integer> {
    private static final String GET_ALL = "SELECT * FROM polotskyi_lab3.car";
    private static final String GET_BY_ID = "SELECT * FROM polotskyi_lab3.car WHERE id=?";
    private static final String CREATE =  "INSERT polotskyi_lab3.car "
            + "(id, brand, model, year, plate_number, vin_number, status, station_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE polotskyi_lab3.car " +
            "SET brand=?, model=?, year=?, plate_number=?, vin_number=?, status=?, station_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM polotskyi_lab3.car WHERE id=?";


    @Override
    public final List<Car> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Car> cars = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String brand = resultSet.getString(2);
                    String model = resultSet.getString(3);
                    Integer year = resultSet.getInt(4);
                    String plate_number = resultSet.getString(5);
                    String vin_number = resultSet.getString(6);
                    String status = resultSet.getString(7);
                    Integer station_id = resultSet.getInt(8);
                    cars.add(new Car(id, brand, model, year, plate_number, vin_number, status, station_id));
                }
            }
        }
        return cars;
    }

    @Override
    public final Car getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Car car = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String brand = resultSet.getString(2);
                    String model = resultSet.getString(3);
                    Integer year = resultSet.getInt(4);
                    String plate_number = resultSet.getString(5);
                    String vin_number = resultSet.getString(6);
                    String status = resultSet.getString(7);
                    Integer station_id = resultSet.getInt(8);
                    car = new Car(foundId, brand, model, year, plate_number, vin_number, status, station_id);
                }
            }
        }
        return car;
    }

    @Override
    public final int create(final Car entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getBrand());
            preparedStatement.setString(3, entity.getModel());
            preparedStatement.setInt(4, entity.getYear());
            preparedStatement.setString(5, entity.getPlate_number());
            preparedStatement.setString(6, entity.getVin_number());
            preparedStatement.setString(7, entity.getStatus());
            preparedStatement.setInt(8, entity.getStation_id());
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public final int update(final Car entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getBrand());
            preparedStatement.setString(3, entity.getModel());
            preparedStatement.setInt(4, entity.getYear());
            preparedStatement.setString(5, entity.getPlate_number());
            preparedStatement.setString(6, entity.getVin_number());
            preparedStatement.setString(7, entity.getStatus());
            preparedStatement.setInt(8, entity.getStation_id());
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
