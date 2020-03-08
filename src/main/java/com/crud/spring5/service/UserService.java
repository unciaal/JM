package com.crud.spring5.service;

import com.crud.spring5.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();

    void add(User user);

    void delete(Integer id);

    void edit(User user);

    User getById(Integer id);

    User getByLogin(String login);

    User getByLoginWihtRoles(String login);
}
