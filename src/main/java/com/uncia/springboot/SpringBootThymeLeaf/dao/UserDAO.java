package com.uncia.springboot.SpringBootThymeLeaf.dao;



import com.uncia.springboot.SpringBootThymeLeaf.model.User;

import java.util.List;

public interface UserDAO {
    List<User> allUsers();

    void add(User user);

    void delete(Integer id);

    void edit(User user);

    User getById(int id);

    User getByLogin(String login);

    User getByLoginWihtRoles(String login);

}
