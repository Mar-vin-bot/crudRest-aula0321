package com.iftm.edu.crud_aula0321.service;

import java.util.List;
import java.util.Optional;

import com.iftm.edu.crud_aula0321.domain.TodoList;
import com.iftm.edu.crud_aula0321.repository.TodoListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoListService {

    @Autowired
    private TodoListRepository repository;

    public List<TodoList> GetAll() {
        return repository.findAll();
    }

    public Optional<TodoList> GetById(Integer id) {
        return repository.findById(id);
    }

    public TodoList create(TodoList todoList) {
        return repository.save(todoList);
    }

   public TodoList update(TodoList todoList, Integer id){
     if(repository.existsById(id)){
         todoList.setId(id);
         return repository.save (todoList);
     } 
     return null; 
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
