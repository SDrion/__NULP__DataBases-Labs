package controller.implementation;

import model.implementation.User;
import service.implementation.GeneralService;
import service.implementation.UserService;

public class UserController extends GeneralController<User> {
    private static final UserService USER_SERVICE = new UserService();

    @Override
    public final GeneralService<User> getService() {
        return USER_SERVICE;
    }
}
