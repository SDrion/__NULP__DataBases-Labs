package DAO.implementation;

import DAO.IGeneralDAO;
import model.implementation.Fine;
import persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class FineDAO implements IGeneralDAO<Fine, Integer> {
    private static final String GET_ALL = "SELECT * FROM polotskyi_lab3.fine";
    private static final String GET_BY_ID = "SELECT * FROM polotskyi_lab3.fine WHERE id=?";
    private static final String CREATE =  "INSERT INTO polotskyi_lab3.fine "
            + "(id, payment_due, status, user_id) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE polotskyi_lab3.fine " +
            "SET payment_due=?, status=?, user_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM polotskyi_lab3.fine WHERE id=?";

    @Override
    public final List<Fine> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Fine> fines = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Float paymant_due = resultSet.getFloat(2);
                    String status = resultSet.getString(3);
                    Integer user_id = resultSet.getInt(4);
                    fines.add(new Fine(id, paymant_due, status, user_id));
                }
            }
        }
        return fines;
    }

    @Override
    public final Fine getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Fine fine = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    Float paymant_due = resultSet.getFloat(2);
                    String status = resultSet.getString(3);
                    Integer user_id = resultSet.getInt(4);
                    fine = new Fine(foundId, paymant_due, status, user_id);
                }
            }
        }
        return fine;
    }

    @Override
    public final int create(final Fine entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setFloat(2, entity.getPaymant_due());
            preparedStatement.setString(3, entity.getStatus());
            preparedStatement.setInt(4, entity.getUser_id());
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public final int update(final Fine entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setFloat(1, entity.getPaymant_due());
            preparedStatement.setString(2, entity.getStatus());
            preparedStatement.setInt(3, entity.getUser_id());
            preparedStatement.setInt(4, entity.getId());
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
