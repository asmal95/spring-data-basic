package edu.spring.demo.repo;

import edu.spring.demo.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Long saveUser(User user) {
        return (Long) sessionFactory.getCurrentSession()
                .save(user);
    }

    public User findUserById(Long id) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("from User u where u.id = :id")
                .setParameter("id", id)
                .uniqueResult();
    }

    public void deleteUser(Long id) {
        User user = findUserById(id);
        sessionFactory.getCurrentSession().delete(user);
    }
}
