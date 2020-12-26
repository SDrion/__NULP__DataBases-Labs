package com.polotskyi.controller;

import com.polotskyi.domain.imp.User;
import com.polotskyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUser(
            @PathVariable("id") Integer id
    ) {
        User user;
        ResponseEntity<User> status = (user = userService.getUser(id)) == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(user, HttpStatus.OK);
        return status;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        ResponseEntity<User> status = user.getId() == null ?
                new ResponseEntity<>(HttpStatus.BAD_REQUEST) :
                (userService.getUser(user.getId())) == null
                        ? new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED)
                        : new ResponseEntity<>(HttpStatus.CONFLICT);
        return status;
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id) {
        HttpStatus status = userService.deleteUser(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).build();
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable("id") Integer id,
            @RequestBody User user
    ) {
        User updateUser = userService.updateUser(user, id);
        ResponseEntity<User> status = updateUser == null
                ? new ResponseEntity<User>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<User>(HttpStatus.OK);
        return status;
    }
}
