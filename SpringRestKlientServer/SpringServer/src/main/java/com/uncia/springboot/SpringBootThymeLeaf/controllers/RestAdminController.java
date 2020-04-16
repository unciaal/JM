package com.uncia.springboot.SpringBootThymeLeaf.controllers;

import com.uncia.springboot.SpringBootThymeLeaf.model.User;
import com.uncia.springboot.SpringBootThymeLeaf.service.RoleService;
import com.uncia.springboot.SpringBootThymeLeaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class RestAdminController {

    private UserService userService;

    private RoleService roleService;


    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/users")
    public List<User> allUser() {
        return userService.allUsers();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId) {
        User user1 = userService.getById(userId);
        return user1;
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        userService.addWithRolesID(user);
        return user;
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        userService.editWithRolesID(user);
        return user;
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.delete(id);
        return "Delete " + id + " user";
    }
}

