package com.uncia.springboot.SpringBootThymeLeaf.service;

import com.uncia.springboot.SpringBootThymeLeaf.dao.UserDAO;
import com.uncia.springboot.SpringBootThymeLeaf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override

    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override

    public void add(User user) {
        userDAO.add(user);
    }

    @Override

    public void delete(Integer id) {
        userDAO.delete(id);
    }

    @Override

    public void edit(User user) {
        userDAO.edit(user);
    }

    @Override

    public User getById(Integer id) {
        return userDAO.getById(id);
    }

    @Override
    public User getByLogin(String login) {
        return userDAO.getByLogin(login);
    }

    public User getByLoginWihtRoles(String login) {
        return userDAO.getByLoginWihtRoles(login);
    }
}
