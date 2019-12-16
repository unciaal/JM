package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements UserDaoImpl {

    public UserDAO() {
    }

    public void insertUser(User user, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement
                    ("INSERT INTO users(name, surname, patronymic, age) VALUES ( ?, ?, ?, ?);");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getPatronymic());
            preparedStatement.setInt(4, user.getAge());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
            if (connection != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    connection.rollback();
                } catch (SQLException ex) {
                    printSQLException(ex);
                }
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public User selectUser(long id, Connection connection) throws SQLException {
        User user = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select id,name,surname,patronymic,age from users where id =?");
            preparedStatement.setLong(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String patronymic = rs.getString("patronymic");
                int age = rs.getInt("age");
                user = new User(id, name, surname, patronymic, age);
            }
        } catch (SQLException e) {
            printSQLException(e);
            if (connection != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    connection.rollback();
                } catch (SQLException ex) {
                    printSQLException(ex);
                }
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return user;
    }

    public List<User> selectAllUsers(Connection connection) throws SQLException {
        List<User> users = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from users");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String patronymic = rs.getString("patronymic");
                int age = rs.getInt("age");
                String car = rs.getString("car");
                String work = rs.getString("work");
                User user = new User(id, name, surname, patronymic, age);
                user.setCar(car);
                user.setWork(work);
                users.add(user);
            }
        } catch (SQLException e) {
            printSQLException(e);
            if (connection != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    connection.rollback();
                } catch (SQLException ex) {
                    printSQLException(ex);
                }
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return users;
    }

    public boolean deleteUser(long id, Connection connection) throws SQLException {
        boolean rowDeleted;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from users where id = ?;");
            preparedStatement.setLong(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
            return rowDeleted;
        } catch (SQLException e) {
            printSQLException(e);
            if (connection != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    connection.rollback();
                } catch (SQLException ex) {
                    printSQLException(ex);
                }
            }
            return false;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public boolean updateUser(User user, Connection connection) throws SQLException {
        boolean rowUpdated;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update users set age = ?,car = ?, work = ? where id = ?;");
            preparedStatement.setInt(1, user.getAge());
            preparedStatement.setString(2, user.getCar());
            preparedStatement.setString(3, user.getWork());
            preparedStatement.setLong(4, user.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
            return rowUpdated;
        } catch (SQLException e) {
            printSQLException(e);
            if (connection != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    connection.rollback();
                } catch (SQLException ex) {
                    printSQLException(ex);
                }
            }
            return false;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
