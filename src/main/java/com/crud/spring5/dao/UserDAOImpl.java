package com.crud.spring5.dao;

import com.crud.spring5.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override

    public List<User> allUsers() {
        return (List<User>) entityManager.createQuery("from User ").getResultList();
    }

    @Override

    public void add(User user) {
        entityManager.persist(user);
    }

    @Override

    public void delete(Integer id) {
        entityManager.remove(entityManager.find(User.class,id));
    }

    @Override

    public void edit(User user) {
        entityManager.merge(user);
    }

    @Override

    public User getById(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }
}
