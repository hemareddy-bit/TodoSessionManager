package com.example.Session.Service;

import com.example.Session.Model.TodoJpa;
import com.example.Session.Repository.Dal.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<TodoJpa> findAll() {
        return todoRepository.findAll();
    }

    public Optional<TodoJpa> findById(Long id) {
        return todoRepository.findById(id);
    }

    public TodoJpa save(TodoJpa todo) {
        System.out.println("Create route:" + todo);
        return todoRepository.save(todo);
    }

    public TodoJpa update(Long id, TodoJpa todo) {
        Optional<TodoJpa> existingTodo = todoRepository.findById(id);

        if (existingTodo.isPresent()) {
            TodoJpa updatedTodo = existingTodo.get();
            updatedTodo.setTitle(todo.getTitle());
            updatedTodo.setDescription(todo.getDescription());

            return todoRepository.save(updatedTodo);
        } else {
            throw new RuntimeException("Todo not found with id: " + id);
        }
    }


    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }
}
