package com.polotskyi.service;

import com.polotskyi.domain.imp.User;
import com.polotskyi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getUser(Integer id) {
        if(userRepository.existsById(id)) {
            User user = userRepository.findById(id).get();
            return user;
        } else {
            return null;
        }
    }

    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(User upUser, Integer id) {
        if(userRepository.existsById(id)) {
            User user = userRepository.findById(id).get();
            user.setStatus(upUser.getStatus());
            user.setDriverLicenseNumber(upUser.getDriverLicenseNumber());
            user.setEmail(upUser.getEmail());
            user.setFirstName(upUser.getFirstName());
            user.setLastName(upUser.getLastName());
            user.setPassportNumber(upUser.getPassportNumber());
            user.setPasswordSha256(upUser.getPasswordSha256());
            user.setPhoneNumber(upUser.getPhoneNumber());

            return user;
        } else {
            return  null;
        }
    }

    @Transactional
    public boolean deleteUser(Integer id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
