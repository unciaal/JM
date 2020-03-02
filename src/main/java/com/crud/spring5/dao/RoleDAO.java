package com.crud.spring5.dao;


import com.crud.spring5.model.Role;


import java.util.List;


public interface RoleDAO {
    List<Role> allRole();

    void add(Role role);

    void delete(Integer role);

    void edit(Role role);

    Role getById(int id);

    void addRoleUserDAO(Role role);

    void delRoleUserDAO(Integer roleId, Integer userId);

}
