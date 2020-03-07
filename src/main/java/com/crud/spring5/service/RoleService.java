package com.crud.spring5.service;

import com.crud.spring5.model.Role;

import java.util.List;

public interface RoleService {
    void addRole(Role role);

    void delete(Integer id);

    Role getById(Integer id);

    void editRole(Role role);

    List<Role> getAll();
}
