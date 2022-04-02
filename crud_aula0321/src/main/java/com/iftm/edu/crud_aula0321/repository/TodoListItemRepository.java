package com.iftm.edu.crud_aula0321.repository;

import java.util.List;

import com.iftm.edu.crud_aula0321.domain.TodoList;
import com.iftm.edu.crud_aula0321.domain.TodoListItem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodoListItemRepository extends CrudRepository<TodoListItemRepository, Integer> {
    
    List<TodoListItem> findByTodoList (TodoList todoList);

    TodoListItem save(TodoListItem todoListItem);
    
}
