package com.example.Session.Repository.Dal;

import com.example.Session.Model.TodoJpa;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    List<TodoJpa> findAll();
    Optional<TodoJpa> findById(Long id);
    TodoJpa save(TodoJpa todo);
    TodoJpa update(TodoJpa todo);
    void deleteById(Long id);
}
