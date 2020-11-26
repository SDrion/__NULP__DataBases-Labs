package service.implementation;

import DAO.IGeneralDAO;
import service.IGeneralService;

import java.sql.SQLException;
import java.util.List;

public abstract class GeneralService<T> implements IGeneralService<T> {

    @Override
    public abstract IGeneralDAO<T, Integer> getDAO();

    @Override
    public final List<T> getAll() throws SQLException {
        return getDAO().getAll();
    }

    @Override
    public final T getById(final Integer id) throws SQLException {
        return getDAO().getById(id);
    }

    @Override
    public final int create(final T entity) throws SQLException {
        return getDAO().create(entity);
    }

    @Override
    public final int update(final T entity) throws SQLException {
        return getDAO().update(entity);
    }

    @Override
    public final int delete(final Integer id) throws SQLException {
        return getDAO().delete(id);
    }
}
