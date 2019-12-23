package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDao {

        Connection connection;

        public UserJdbcDAO(Connection connection) {
            this.connection = connection;
        }
        @Override
        public void insertUser(User user) throws SQLException {
            try (PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO users(name, surname, patronymic, age) VALUES ( ?, ?, ?, ?);")) {
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
            }
        }
        @Override
        public User selectUser(long id) throws SQLException {
            User user = null;
            try (PreparedStatement preparedStatement = connection.prepareStatement("select id,name,surname,patronymic,age from users where id =?")) {
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
            }
            return user;
        }
        @Override
        public List<User> selectAllUsers() throws SQLException {
            List<User> users = new ArrayList<>();
            try (PreparedStatement preparedStatement = connection.prepareStatement("select * from users")) {
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
            }
            return users;
        }
        @Override
        public boolean deleteUser(long id) throws SQLException {
            boolean rowDeleted;
            try (PreparedStatement preparedStatement = connection.prepareStatement("delete from users where id = ?;")) {
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
            }
        }
        @Override
        public boolean updateUser(User user) throws SQLException {
            boolean rowUpdated;
            try (PreparedStatement preparedStatement = connection.prepareStatement("update users set age = ?,car = ?, work = ? where id = ?;")) {
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
