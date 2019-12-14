package service;

import dao.UserDAO;
import model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    private static UserDAO userDAO = null;
    private static UserService userService = null;

    public UserService() {
        userDAO = new UserDAO();
    }

    public static UserService getUserService() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public List<User> selectAllUsers(Connection connection) throws SQLException {
        return userDAO.selectAllUsers(connection);
    }

    public void insertUser(User user, Connection connection) throws SQLException {
        userDAO.insertUser(user, connection);
    }

    public User selectUser(long id, Connection connection) throws SQLException {
        return userDAO.selectUser(id, connection);
    }

    public boolean deleteUser(long id, Connection connection) throws SQLException {
        return userDAO.deleteUser(id, connection);
    }

    public boolean updateUser(User user, Connection connection) throws SQLException {
        return userDAO.updateUser(user, connection);
    }
}
