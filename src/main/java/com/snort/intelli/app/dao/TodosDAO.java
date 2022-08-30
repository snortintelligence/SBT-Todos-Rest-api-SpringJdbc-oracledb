package com.snort.intelli.app.dao;


import com.snort.intelli.app.TodosRestApiApplication;
import com.snort.intelli.app.model.Todos;

import java.util.List;

public interface TodosDAO {

// CRUD : To declare all common methods to perform database operations for Todos

    public List<Todos> findAllTodos();
    public Todos findOneTodo(Long id);
    public Todos deleteTodo(Long id);
    public Todos createTodo(Todos todos);
    public Todos updateTodo(Long id, Todos todos);


}
