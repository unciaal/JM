package users.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import users.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;

@PersistenceContext
@Repository
public class UserEntityManagerDAO implements UserDAO {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Autowired
    public void setEntityManager(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public List<User> allUsers() {

        List<User> userList = entityManager.createQuery("from User ").getResultList();
        return userList;
    }

    @Override
    public void add(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(User user) {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void edit(User user) {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public User getById(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }
}
