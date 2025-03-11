package com.example.Session.Repository.Dal;

import com.example.Session.Model.TodoJpa;
import com.example.Session.Repository.Jpa.TodoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaRepositoryWrapper implements TodoRepository{

    @Autowired
    private TodoJpaRepository repository;

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
        return repository.save(todo); // JpaRepository uses save for both insert and update
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
