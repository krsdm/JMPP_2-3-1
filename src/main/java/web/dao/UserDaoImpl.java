package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    private static int increment;
    private final List<User> users;

    public UserDaoImpl() {
        users = new ArrayList<>();
        users.add(new User(increment++, "Alex", "Ivanov", (byte) 17, "alexivanov@mail.com"));
        users.add(new User(increment++, "Ivan", "Alexandrov", (byte) 27, "ivanalexandrov@mail.com"));
        users.add(new User(increment++, "Dmitry", "Krasilnikov", (byte) 37, "dmitrykrasilnikov@mail.com"));
        users.add(new User(increment++, "Sveta", "Sergeeva", (byte) 47, "svetasergeeva@mail.com"));
        users.add(new User(increment++, "Nikolay", "Vasilev", (byte) 57, "nikolayvasilev@mail.com"));
    }

    @Override
    public List<User> getAllUser() {
        return users;
    }

    @Override
    public User getUserById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(new User());
    }

    @Override
    public void saveUser(User user) {
        user.setId(increment++);
        users.add(user);
    }

}
