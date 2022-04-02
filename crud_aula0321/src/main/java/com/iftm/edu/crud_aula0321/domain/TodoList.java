package com.iftm.edu.crud_aula0321.domain;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data   @NoArgsConstructor
@Entity
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<TodoList> getAll() {
        return null;
    }

    public Optional<TodoList> GetById(Integer id2) {
        return null;
    }

    public Object create(TodoList todoList) {
        return null;
    }

    public TodoList update(String todolist, Integer id2) {
        return null;
    }

    
}
