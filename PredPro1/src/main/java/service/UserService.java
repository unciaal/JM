package service;

import dao.UserDAO;
import dao.UserDaoImpl;
import model.User;
import util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserService implements UserServiceImpl {
    private static UserDaoImpl userDAO = null;
    private static UserService userService = null;
    private static Connection connection = null;
    public UserService() {
        userDAO = new UserDAO();
        connection = DBHelper.getDbHelperFactory();
    }

    public static UserService getUserService() {
        if (userService == null) {
            userService = new UserService();

        }
        return userService;
    }

    public List<User> selectAllUsers() throws SQLException {
        return userDAO.selectAllUsers(connection);
    }

    public void insertUser(User user) throws SQLException {
        userDAO.insertUser(user, connection);
    }

    public User selectUser(long id) throws SQLException {
        return userDAO.selectUser(id, connection);
    }

    public boolean deleteUser(long id) throws SQLException {
        return userDAO.deleteUser(id, connection);
    }

    public boolean updateUser(User user) throws SQLException {
        return userDAO.updateUser(user, connection);
    }
}
