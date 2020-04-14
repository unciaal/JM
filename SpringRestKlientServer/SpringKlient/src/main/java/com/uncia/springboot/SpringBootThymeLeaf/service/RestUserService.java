package com.uncia.springboot.SpringBootThymeLeaf.service;

import com.uncia.springboot.SpringBootThymeLeaf.model.User;

import java.util.List;

public interface RestUserService {
    List<User> allUsers();

    void add(User user);

    void addWithRolesID(User user);

    void delete(Integer id);

    void edit(User user);

    void editWithRolesID(User user);

    User getById(Integer id);

    User getByLogin(String login);

    User getByLoginWihtRoles(String login);
}
