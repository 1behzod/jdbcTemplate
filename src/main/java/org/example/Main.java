package org.example;

import org.example.config.PostgresConfig;
import org.example.dao.UserDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(PostgresConfig.class);

        UserDAO userDAO = context.getBean(UserDAO.class);

        userDAO.insert("John Doe", 30);
        userDAO.getAllUsers().forEach(user ->
                System.out.println(user.getId() + " " + user.getName() + " " + user.getAge()));
        userDAO.update(1, "John Smith", 35);
        userDAO.delete(1);
        context.close();
    }
}
