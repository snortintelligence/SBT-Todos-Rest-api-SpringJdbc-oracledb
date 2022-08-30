package com.snort.intelli.app.controller;

import java.util.List;

import com.snort.intelli.app.dao.TodosDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.snort.intelli.app.model.Todos;

@RestController
@RequestMapping("/todos")
public class TodosController {

	@Autowired
	TodosDAO todosDAO;

	private Logger log = LoggerFactory.getLogger(TodosController.class);

	@PostMapping("/create")
	public String createTask(@RequestBody Todos todos) {
		log.info("TodosController : createTask executed!");
		todos = todosDAO.createTodo(todos);
		return todos.getTaskId()!=null? "New Todo created with id : "+todos.getTaskId():"No Todo created!";
	}

	@GetMapping("/")
	public List<Todos> findAll() {
		log.info("TodosController : findAll executed!");
		return todosDAO.findAllTodos();
	}
	
	@GetMapping("/{id}")
	public Todos findOneTodo(@PathVariable Long id) {
		log.info("TodosController : findOneTodo executed!");
		Todos todos = todosDAO.findOneTodo(id);
		return todos;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteOneTodo(@PathVariable Long id) {
		log.info("TodosController : deleteOneTodo executed!");
		Todos todos = todosDAO.deleteTodo(id);
		return todos.getTaskId()!=null? "Todo deleted with id : "+todos.getTaskId():"No Todo deleted with id : "+id;
	}
	
	@PutMapping("/update/{id}")
	public String updateOneTodo(@PathVariable Long id, @RequestBody Todos newTodo) {

		Todos todos = todosDAO.updateTodo(id, newTodo);
		log.info("TodosController : updateOneTodo() executed! ",todos);
		return todos.getTaskId()!=null? "Todo updated with id : "+todos.getTaskId(): "No Todo update with id : "+id;
	}
	
}
