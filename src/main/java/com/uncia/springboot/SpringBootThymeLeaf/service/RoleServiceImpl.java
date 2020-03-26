package com.uncia.springboot.SpringBootThymeLeaf.service;


import com.uncia.springboot.SpringBootThymeLeaf.dao.RoleDAO;
import com.uncia.springboot.SpringBootThymeLeaf.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    private RoleDAO roleDAO;

    @Autowired
    @Transactional
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    @Transactional
    public void addRole(Role role) {
        roleDAO.add(role);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        roleDAO.delete(id);
    }

    @Override
    public Role getById(Integer id) {
        Role role = roleDAO.getById(id);
        return role;
    }

    @Override
    @Transactional
    public void editRole(Role role) {
        roleDAO.edit(role);
    }


    @Override
    public List<Role> getAll() {
        return (List<Role>) roleDAO.allRole();
    }

}
