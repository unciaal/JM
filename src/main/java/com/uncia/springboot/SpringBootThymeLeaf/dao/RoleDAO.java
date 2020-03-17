package com.uncia.springboot.SpringBootThymeLeaf.dao;




import com.uncia.springboot.SpringBootThymeLeaf.model.Role;

import java.util.List;


public interface RoleDAO {
    List<Role> allRole();

    void add(Role role);

    void delete(Integer role);

    void edit(Role role);

    Role getById(int id);

}
