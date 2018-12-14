package edu.spring.demo;

import edu.spring.data.drep.AuthorRep;
import edu.spring.data.drep.PostRep;
import edu.spring.data.model.Author;
import edu.spring.data.model.Post;
import edu.spring.demo.d_repo.GroupRep;
import edu.spring.demo.d_repo.UserRep;
import edu.spring.demo.model.User;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Random;

public class DataMain {

    //spring data example
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("data.xml");
        GroupRep groupRep = context.getBean(GroupRep.class);
        UserRep userRep = context.getBean(UserRep.class);

        PlatformTransactionManager manager = context.getBean(PlatformTransactionManager.class);

        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = manager.getTransaction(def);

        User user = userRep.findByUserAndGroup("A604", "BasicMain");

        System.out.println(user.getPassword());

        manager.commit(status);
    }
}
