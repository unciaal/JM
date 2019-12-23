package service;

import dao.UserDao;
import dao.UserDaoFactory;
import model.User;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserDao userDAO = null;
    private static UserServiceImpl userService = null;

    public UserServiceImpl() throws Exception {
        userDAO = new UserDaoFactory().getUserDao();
    }

    public static UserServiceImpl getUserService() throws Exception {
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
