package com.iftm.edu.crud_aula0321.service;

import java.util.List;
import java.util.Optional;

import com.iftm.edu.crud_aula0321.domain.TodoList;
import com.iftm.edu.crud_aula0321.domain.TodoListItem;
import com.iftm.edu.crud_aula0321.repository.TodoListItemRepository;
import com.iftm.edu.crud_aula0321.repository.TodoListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TodoListItemService {

@Autowired
private TodoListItemRepository repository;
@Autowired
private TodoListRepository listRepository;

    public List<TodoListItem> GetAll (Integer iDList){
        TodoList todoList = listRepository.findById(iDList).get();
        return repository.findByTodoList(todoList);
    }

    public Optional<TodoListItemRepository> GetById(Integer id){ //dominio ou repository
        return repository.findById(id);
    }

    public TodoListItem create(TodoListItem todoListItem, Integer iDList){
        TodoList todoList = listRepository.findById(iDList).get();
        todoListItem.setTodoList(todoList);
        return repository.save(todoListItem);
    }


    public TodoListItem update (TodoListItem todoListItem, Integer id, Integer iDList){
        if (repository.existsById(id)){
            todoListItem.setId(id);
            todoListItem.setTodoList(listRepository.findById(iDList).get());
            return repository.save(todoListItem);
        }
        return null;
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
    
}


