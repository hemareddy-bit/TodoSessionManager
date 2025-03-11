package com.example.Session.Repository.Hibernate;

import com.example.Session.Model.TodoJpa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TodoHibernateRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<TodoJpa> findAll() {
        Session session = sessionFactory.openSession();
        List<TodoJpa> todos = session.createQuery("FROM TodoJpa", TodoJpa.class).list();
        session.close();
        return todos;
    }

    public Optional<TodoJpa> findById(Long id) {
        Session session = sessionFactory.openSession();
        TodoJpa todo = session.get(TodoJpa.class, id);
        session.close();
        return Optional.ofNullable(todo);
    }

    public TodoJpa save(TodoJpa todo) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(todo);
        transaction.commit();
        session.close();
        return todo;
    }

    public TodoJpa update(TodoJpa todo) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(todo);
        transaction.commit();
        session.close();
        return todo;
    }

    public void deleteById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        TodoJpa todo = session.get(TodoJpa.class, id);
        if (todo != null) {
            session.remove(todo);
        }
        transaction.commit();
        session.close();
    }
}
