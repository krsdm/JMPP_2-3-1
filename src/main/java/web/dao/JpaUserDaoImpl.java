package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class JpaUserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(int id) {
        return entityManager.createQuery("select u from User u where u.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User updatedUser, int id) {
        entityManager.createQuery(
                "update User u set u.name = :name, u.surname = :surname, u.age = :age, u.email = :email where u.id = :id")
                .setParameter("name", updatedUser.getName())
                .setParameter("surname", updatedUser.getSurname())
                .setParameter("age", updatedUser.getAge())
                .setParameter("email", updatedUser.getEmail())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void removeUser(int id) {
        entityManager.createQuery("delete from User u where u.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
