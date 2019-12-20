package dao;

import model.User;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void insertUser(User user) throws SQLException;
    User selectUser(long id) throws SQLException;
    List<User> selectAllUsers() throws SQLException;
    boolean deleteUser(long id) throws SQLException;
    boolean updateUser(User user) throws SQLException;
}
