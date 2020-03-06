package com.crud.spring5.service;

import com.crud.spring5.model.Role;
import com.crud.spring5.model.User;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    void addRole(Role role);

    void delete(Integer id);

    Role getById(Integer id);

    void editRole(Role role);

    List<Role> getAll();
}
