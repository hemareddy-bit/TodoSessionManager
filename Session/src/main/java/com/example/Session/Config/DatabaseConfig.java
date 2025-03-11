package com.example.Session.Config;

import com.example.Session.Repository.Dal.EntityManagerRepositoryWrapper;
import com.example.Session.Repository.Dal.HibernateRepositoryWrapper;
import com.example.Session.Repository.Dal.JpaRepositoryWrapper;
import com.example.Session.Repository.Dal.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    @Value("${app.database.method}")
    private String databaseMethod;

    @Autowired
    private JpaRepositoryWrapper jpaRepositoryWrapper;

    @Autowired
    private EntityManagerRepositoryWrapper entityManagerRepositoryWrapper;

    @Autowired
    private HibernateRepositoryWrapper hibernateRepositoryWrapper;

    public void init() {
        System.out.println("Database method: " + databaseMethod); // Log the value
    }

    @Bean
    public TodoRepository todoRepository() {
        switch (databaseMethod.trim().toLowerCase()) { // Trim and convert to lowercase
            case "jpa":
                return jpaRepositoryWrapper;
            case "entitymanager":
                return entityManagerRepositoryWrapper;
            case "hibernate":
                return hibernateRepositoryWrapper;
            default:
                throw new IllegalArgumentException("Invalid database method: " + databaseMethod);
        }
    }
}
