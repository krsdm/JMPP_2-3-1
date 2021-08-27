package web.servise;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUserById(int id);
    void saveUser(User user);
}
