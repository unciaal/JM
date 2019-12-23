package service;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserServiceImpl {
    List<User> selectAllUsers() throws SQLException;

    void insertUser(User user) throws SQLException;

    User selectUser(long id) throws SQLException;

    boolean deleteUser(long id) throws SQLException;

    boolean updateUser(User user) throws SQLException;
}
