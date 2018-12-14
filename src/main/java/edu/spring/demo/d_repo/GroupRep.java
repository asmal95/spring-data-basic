package edu.spring.demo.d_repo;

import edu.spring.demo.model.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRep extends CrudRepository<Group, Long> { }