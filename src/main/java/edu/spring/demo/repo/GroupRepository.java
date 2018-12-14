package edu.spring.demo.repo;

import edu.spring.demo.model.Group;
import edu.spring.demo.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GroupRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Long saveGroup(Group group) {
        return (Long) sessionFactory.getCurrentSession()
                .save(group);
    }

    public Group findGroupById(Long id) {
        return (Group) sessionFactory.getCurrentSession()
                .createQuery("from Group u where u.id = :id")
                .setParameter("id", id)
                .uniqueResult();
    }

    public void deleteGroup(Long id) {
        Group group = findGroupById(id);
        sessionFactory.getCurrentSession().delete(group);
    }
}
