package com.example.Session.Controller;

import com.example.Session.Model.TodoJpa;
import com.example.Session.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<TodoJpa> findAll() {
        return todoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TodoJpa> findById(@PathVariable Long id) {
        return todoService.findById(id);
    }

    @PostMapping
    public TodoJpa save(@RequestBody TodoJpa todo) {
        System.out.println("Create route:" + todo);
        return todoService.save(todo);
    }

    @PutMapping("/{id}")
    public TodoJpa update(@PathVariable Long id, @RequestBody TodoJpa todo) {
        return todoService.update(id,todo);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        todoService.deleteById(id);
    }
}
