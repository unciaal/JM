package com.crud.spring5.dao;

import com.crud.spring5.model.User;


import java.util.List;
public interface UserDAO {
    List<User> allUsers();
    void add(User user);
    void delete(Integer id);
    void edit(User user);
    User getById(int id);
}
