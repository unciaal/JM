package com.uncia.springboot.SpringBootThymeLeaf.service;

import com.uncia.springboot.SpringBootThymeLeaf.dao.RoleDAO;
import com.uncia.springboot.SpringBootThymeLeaf.dao.UserDAO;
import com.uncia.springboot.SpringBootThymeLeaf.model.Role;
import com.uncia.springboot.SpringBootThymeLeaf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    private RoleDAO roleDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Autowired
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override
    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    @Transactional
    public void addWithRolesID(User user) {
        if(user.getStrIdRoles() != null) {
            String[] strId = user.getStrIdRoles();
            for (String id : strId) {
                Role role = roleDAO.getById(Integer.parseInt(id));
                user.getRoles().add(role);
            }
        }
        userDAO.add(user);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        userDAO.delete(id);
    }

    @Override
    @Transactional
    public void edit(User user) {
        userDAO.edit(user);
    }

    @Override
    @Transactional
    public void editWithRolesID(User user) {

        if(user.getStrIdRoles() != null) {
            String[] strId = user.getStrIdRoles();
            for (String id : strId) {
                Role role = roleDAO.getById(Integer.parseInt(id));
                user.getRoles().add(role);
            }
        }
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
