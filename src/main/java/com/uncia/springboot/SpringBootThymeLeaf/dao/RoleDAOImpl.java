package com.uncia.springboot.SpringBootThymeLeaf.dao;


import com.uncia.springboot.SpringBootThymeLeaf.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public RoleDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Role> allRole() {
        List<Role> roleList = (List<Role>) entityManager.createQuery("select ro from Role ro").getResultList();
        return roleList;
    }

    @Override
    public void add(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void delete(Integer id) {
        entityManager.remove(entityManager.find(Role.class, id));
    }

    @Override
    public void edit(Role role) {
        entityManager.merge(role);
    }

    @Override
    public Role getById(int id) {
        Role role = entityManager.find(Role.class, id);
        return role;
    }


}
