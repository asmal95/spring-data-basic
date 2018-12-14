package edu.spring.demo.d_repo;

import edu.spring.demo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRep extends CrudRepository<User, Long> {

    @Query("select u from User u, Group g where u.name = ?1 and g.name= ?2 and u.group = g")
    User findByUserAndGroup(String name, String group);

    User findByName(String name);
}
