package com.uncia.springboot.SpringBootThymeLeaf.controllers;

import com.uncia.springboot.SpringBootThymeLeaf.model.User;
import com.uncia.springboot.SpringBootThymeLeaf.service.RestRoleService;
import com.uncia.springboot.SpringBootThymeLeaf.service.RestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class RestAdminController {

    private RestUserService userService;

    private RestRoleService roleService;


    @Autowired
    public void setRoleService(RestRoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setUserService(RestUserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/users")
    public List<User> allUser() {
        return userService.allUsers();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId) {
        return userService.getById(userId);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addWithRolesID(user);
        return user;
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.editWithRolesID(user);
        return user;
    }

    @DeleteMapping(value = "/user")
    public String deleteUser(@RequestBody int idUser) {
        userService.delete(idUser);
        return "Delete " + idUser + "user";
    }
}

