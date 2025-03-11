package com.example.Session.Repository.Jpa;

import com.example.Session.Model.TodoJpa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TodoJpaEntityManagerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<TodoJpa> findAll() {
        return entityManager.createQuery("SELECT t FROM TodoJpa t", TodoJpa.class).getResultList();
    }

    public Optional<TodoJpa> findById(Long id) {
        return Optional.ofNullable(entityManager.find(TodoJpa.class, id));
    }

    @Transactional
    public TodoJpa save(TodoJpa todo) {
        entityManager.persist(todo);
        return todo;
    }

    @Transactional
    public TodoJpa update(TodoJpa todo) {
        return entityManager.merge(todo);
    }

    @Transactional
    public void deleteById(Long id) {
        TodoJpa todo = entityManager.find(TodoJpa.class, id);
        if (todo != null) {
            entityManager.remove(todo);
        }
    }
}
