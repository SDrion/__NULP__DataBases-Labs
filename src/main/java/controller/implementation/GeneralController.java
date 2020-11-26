package controller.implementation;

import controller.IGeneralController;
import model.IGeneralModel;
import service.implementation.GeneralService;

import java.sql.SQLException;
import java.util.List;

public abstract class GeneralController<T extends IGeneralModel> implements IGeneralController<T> {

    @Override
    public abstract GeneralService<T> getService();

    @Override
    public final void create(final T entity) throws SQLException {
        getService().create(entity);
        System.out.println("Entity has been created now");
        System.out.println(entity);
    }

    @Override
    public final void update(final T entity) throws SQLException {
        getService().update(entity);
        System.out.println("Entity has been updated now");
        System.out.println(entity.getId());
    }

    @Override
    public final void delete(final int id) throws SQLException {
        getService().delete(id);
        System.out.println("Entity has been deleted now");
    }

    @Override
    public final void getAll() throws SQLException {
        List<T> ts =  getService().getAll();
        for (T t: ts) {
            System.out.println(t);
        }
    }

    @Override
    public final void getById(final int id) throws SQLException {
        T t = getService().getById(id);
        if (t != null) {
            System.out.println("Entity with id " + id + " found");
            System.out.println(t);
        } else {
            System.out.println("Entity with id " + id + " not found");
        }
    }
}
