package com.iftm.edu.crud_aula0321.repository;

import java.util.List;

import com.iftm.edu.crud_aula0321.domain.TodoList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends CrudRepository <TodoList, Integer> {

    @Override
    public List<TodoList> findAll();

    

}
