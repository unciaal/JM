package users.service;

import users.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    void add (User user);
    void delete (User user);
    void edit (User user);
    User getById (Integer id);
}
