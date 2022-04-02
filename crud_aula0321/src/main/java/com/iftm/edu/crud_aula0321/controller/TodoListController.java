package com.iftm.edu.crud_aula0321.controller;

import java.util.List;
import java.util.Optional;


import com.iftm.edu.crud_aula0321.domain.TodoList;
import com.iftm.edu.crud_aula0321.service.TodoListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/todolist")
class TodoListController {

    @Autowired
    TodoListService service;

    @GetMapping
    public ResponseEntity<List<TodoList>> getAll() {
        List<TodoList> items = service.GetAll();

        if (items.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoList> getById(@PathVariable("id") Integer id) {
        Optional<TodoList> existingItemOptional = service.GetById(id);

        if (existingItemOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(existingItemOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<TodoList> create(@RequestBody TodoList todoList) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(todoList));
    }

    @PutMapping("{id}")
    public ResponseEntity<TodoList> update(@PathVariable("id") Integer id, @RequestBody TodoList item) {
        TodoList todoList = service.update(item, id);
        if (todoList != null) {
            return ResponseEntity.status(HttpStatus.OK).body(todoList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recurso mão encontrado", exc);
        }
    }

        @ExceptionHandler({Exception.class})
        public ResponseEntity<String> handleException(){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("teste3");
        }

        



}
