package com.polotskyi.controller.imp;

import com.polotskyi.domain.imp.User;
import com.polotskyi.service.IGeneralService;
import com.polotskyi.service.imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController extends GeneralController<User> {

    @Autowired
    UserService userService;

    @Override
    public final IGeneralService<User> getService() {
        return userService;
    }
}
