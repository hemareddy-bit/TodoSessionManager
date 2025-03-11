package com.example.Session.Repository.Dal;

import com.example.Session.Model.TodoJpa;
import com.example.Session.Repository.Hibernate.TodoHibernateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HibernateRepositoryWrapper implements TodoRepository{

    @Autowired
    private TodoHibernateRepository repository;

    @Override
    public List<TodoJpa> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<TodoJpa> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public TodoJpa save(TodoJpa todo) {
        return repository.save(todo);
    }

    @Override
    public TodoJpa update(TodoJpa todo) {
        return repository.update(todo);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
