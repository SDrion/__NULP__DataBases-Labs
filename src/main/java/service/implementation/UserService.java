package service.implementation;

import DAO.IGeneralDAO;
import DAO.implementation.UserDAO;
import model.implementation.User;

public class UserService extends GeneralService<User> {
    private final IGeneralDAO<User, Integer> userDAOImplementation = new UserDAO();

    @Override
    public final IGeneralDAO<User, Integer> getDAO() {
        return userDAOImplementation;
    }
}
