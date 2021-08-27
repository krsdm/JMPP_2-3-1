package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUser();
    User getUserById(int id);
    void saveUser(User user);
}
