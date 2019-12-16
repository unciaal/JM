package dao;

import model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDaoImpl {
    void insertUser(User user, Connection connection) throws SQLException;
    User selectUser(long id, Connection connection) throws SQLException;
    List<User> selectAllUsers(Connection connection) throws SQLException;
    boolean deleteUser(long id, Connection connection) throws SQLException;
    boolean updateUser(User user, Connection connection) throws SQLException;
}
