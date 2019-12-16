package service;

import model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserServiceImpl {
    public List<User> selectAllUsers() throws SQLException;
    public void insertUser(User user) throws SQLException;
    public User selectUser(long id) throws SQLException;
    public boolean deleteUser(long id) throws SQLException;
    public boolean updateUser(User user) throws SQLException;
}
