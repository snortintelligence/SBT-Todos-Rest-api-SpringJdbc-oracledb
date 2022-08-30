package com.snort.intelli.app.dao;

import com.snort.intelli.app.model.Todos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class TodosDAOImpl implements TodosDAO {

    private Logger log = LoggerFactory.getLogger(TodosDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Todos> findAllTodos() {
        List<Todos> todosList = new ArrayList<>();
        try {
            log.info("TodosDAOImpl : executed findAllTodos()");
            String queryString = "SELECT * FROM TBL_TODOS";
            todosList = jdbcTemplate.query(queryString, BeanPropertyRowMapper.newInstance(Todos.class));
            return todosList;
        }catch (Exception e){
            log.info("TodosDAOImpl : error in findAllTodos() ",e.getCause());
        }
        return todosList;
    }

    @Override
    public Todos findOneTodo(Long id) {
        Todos todos = new Todos();
        try {
            log.info("TodosDAOImpl : executed findOneTodo()");
            String queryString = "SELECT * FROM TBL_TODOS WHERE TASK_ID=?";
            todos = jdbcTemplate.queryForObject(queryString, BeanPropertyRowMapper.newInstance(Todos.class), id);
            return todos;
        }catch (Exception e){
            log.info("TodosDAOImpl : error in findOneTodo() ",e.getCause());
        }
        return todos;
    }

    @Override
    public Todos deleteTodo(Long id) {
        Todos todos = findOneTodo(id);
        try {
            log.info("TodosDAOImpl : executed deleteTodo()");
            String queryString = "delete from tbl_todos where task_id=?";
            if(todos.getTaskId()!=null){
               int status = jdbcTemplate.update(queryString, id);
               if(status>0){
                 return todos;
               }else{
                   return new Todos();
               }
            }
        }catch (Exception e){
            log.info("TodosDAOImpl : error in deleteTodo() ",e.getCause());
        }
        return todos;
    }

    @Override
    public Todos createTodo(Todos todos) {
        Long id =  Math.abs(new Random().nextLong());
        todos.setTaskId(Long.valueOf(String.valueOf(id).substring(1,4)));
        try {
            log.info("TodosDAOImpl : executed createTodo()");
            String queryString = "insert into tbl_Todos(TASK_ID,TITLE,DESCRIPTION,COMPLETED,ASSIGNED_DATE) values(?,?,?,?,sysdate)";
           int status =  jdbcTemplate.update(queryString, todos.getTaskId(), todos.getTitle(), todos.getDescription(), todos.getCompleted());
            if(status>0){
                log.info("TodosDAOImpl : "+todos+" new resource created in db!");
                return todos;
            }else{
                log.info("TodosDAOImpl : "+todos+" new resource unable to create now");
            }

        }catch (Exception e){
            log.info("TodosDAOImpl : error in createTodo() ",e.getCause());
        }
        return new Todos();
    }

    @Override
    public Todos updateTodo(Long id, Todos todos) {
        try {
            log.info("TodosDAOImpl : executed createTodo() ",todos);
            todos.setTaskId(id);
            String queryString = "update tbl_todos set TITLE=?, DESCRIPTION=?, COMPLETED=?, UPDATED_DATE=sysdate where TASK_ID=?";
            int status =  jdbcTemplate.update(queryString, todos.getTitle(), todos.getDescription(), todos.getCompleted() , id);

            if(status>0){
                log.info("TodosDAOImpl : "+todos+" resource updated in db!");
                return findOneTodo(id);
            }else{
                log.info("TodosDAOImpl : "+todos+" resource unable to update now!");
            }

        }catch (Exception e){
            log.info("TodosDAOImpl : error in updateTodo() ",e.getCause());
        }
        return new Todos();
    }
}
