package edu.spring.demo;

import edu.spring.demo.model.Group;
import edu.spring.demo.model.User;
import edu.spring.demo.repo.GroupRepository;
import edu.spring.demo.repo.UserRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Random;

public class BasicMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("basic.xml");

        PlatformTransactionManager manager = context.getBean(PlatformTransactionManager.class);

        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = manager.getTransaction(def);

        UserRepository repository = context.getBean(UserRepository.class);
        GroupRepository groupRepository = context.getBean(GroupRepository.class);

        Group group = new Group();
        group.setName("BasicMain");

        Long id = groupRepository.saveGroup(group);

        User user = new User();
        user.setName("A" + new Random().nextInt(1000));
        user.setPassword("123456");
        user.setGroup(group);

        repository.saveUser(user);

        manager.commit(status);


        status = manager.getTransaction(def);
        group = groupRepository.findGroupById(id);
        for (User user1 : group.getUsers()) {
            System.out.println(user1.getName());
        }
        manager.commit(status);
    }
}
