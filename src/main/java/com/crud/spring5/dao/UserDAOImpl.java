package com.crud.spring5.dao;

import com.crud.spring5.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
        return (List<User>) entityManager.createQuery("from User us JOIN FETCH us.roles ro").getResultList();
    }

    @Override

    public void add(User user) {
        entityManager.persist(user);
    }

    @Override

    public void delete(Integer id) {
        entityManager.remove(entityManager.find(User.class, id));
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

    @Override
    public User getByLogin(String login) {
        try {
            User user = entityManager.createQuery("FROM  User  WHERE login=:login", User.class)
                    .setParameter("login", login).getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        }

    }
    @Override
    public User getByLoginWihtRoles(String login) {
        try {
            User user = entityManager.createQuery("FROM  User  WHERE login=:login JOIN FETCH us.roles ro", User.class)
                    .setParameter("login", login).getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        }

    }
}