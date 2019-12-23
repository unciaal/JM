package service;

import dao.UserDao;
import dao.UserHibernateDAO;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserDao userDAO = null;
    private static UserServiceImpl userService = null;

    public UserServiceImpl() {
        userDAO = new UserHibernateDAO();
    }

    public static UserServiceImpl getUserService() {
        if (userService == null) {
            userService = new UserServiceImpl();

        }
        return userService;
    }

    public List<User> selectAllUsers() throws SQLException {
        return userDAO.selectAllUsers();
    }

    public void insertUser(User user) throws SQLException {
        userDAO.insertUser(user);
    }

    public User selectUser(long id) throws SQLException {
        return userDAO.selectUser(id);
    }

    public boolean deleteUser(long id) throws SQLException {
        return userDAO.deleteUser(id);
    }

    public boolean updateUser(User user) throws SQLException {
        return userDAO.updateUser(user);
    }
}
