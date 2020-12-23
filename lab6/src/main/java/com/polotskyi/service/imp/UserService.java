package com.polotskyi.service.imp;

import com.polotskyi.domain.imp.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.polotskyi.repository.UserRepository;

@Service
public class UserService extends GeneralService<User> {
    @Autowired
    UserRepository userRepository;

    @Override
    public JpaRepository<User, Integer> getRepository() {
        return userRepository;
    }
}
