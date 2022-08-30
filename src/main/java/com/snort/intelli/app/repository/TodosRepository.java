//package com.snort.intelli.app.repository;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import com.snort.intelli.app.model.Todos;
//
//@Repository
//public class TodosRepository {
//
//	// Data stored in db
//
//	private static List<Todos> todosList;
//
//	public TodosRepository() {
//		todosList = new ArrayList<>();
//		todosList.add(new Todos(101L, "Create UI Page", "Create user registration page.", false, new Date(), null));
//		todosList
//				.add(new Todos(102L, "Create Database", "Create Database in oracle with user", true, new Date(), null));
//		todosList.add(new Todos(103L, "Access payment api", "Use Payment api to accept payment from endusers.", false,
//				new Date(), null));
//	}
//
//	public List<Todos> findAll() {
//		return todosList;
//	}
//
//	public Todos findOne(Long id) {
//
//		for (Todos todos : todosList) {
//			if (todos.getTaskId().equals(id)) {
//				return todos;
//			}
//		}
//		return new Todos();
//	}
//
//	public String deleteOne(Long id) {
//
//		for (Todos todos : todosList) {
//			if(todos.getTaskId().equals(id)) {
//				todosList.remove(todos);
//				return "Todos deleted successfully with id : "+id;
//			}
//		}
//		return "Todos failed to delete given id : "+id;
//	}
//
//	public String update(Long id , Todos newTodos) {
//		for (Todos oldTodo: todosList) {
//			if(oldTodo.getTaskId().equals(id)) {
//			//update when match found
//				oldTodo.setTitle(newTodos.getTitle()!=null?newTodos.getTitle():oldTodo.getTitle());
//				oldTodo.setDescription(newTodos.getDescription()!=null?newTodos.getDescription():oldTodo.getDescription());
//				oldTodo.setCompleted(newTodos.isCompleted()!=null?newTodos.isCompleted():oldTodo.isCompleted());
//				oldTodo.setUpdatedDate(new Date());
//				return "Todos updated for id : "+id;
//			}
//		}
//		return "Todos failed to update for id : "+id;
//	}
//
//	public String createTask(Todos todos) {
//		todosList.add(todos);
//		return "successfully new task added with id : " + todos.getTaskId();
//	}
//
//}
