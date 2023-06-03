package com.codewithme.springboot.myfirstweebapp.todo.TodoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.codewithme.springboot.myfirstweebapp.todo.TodoModel.Todo;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static List<Todo>todos = new ArrayList<>();
	
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount, "codewithme", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "codewithme", "Learn Blockchain", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "codewithme", "Learn Backend Development", LocalDate.now().plusYears(3), false));
	}
	
	public List<Todo> findByUserName(String userName){
		Predicate<? super Todo> predicate = todo -> todo.getUserName().equalsIgnoreCase(userName);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String userName, String description, LocalDate targetDate, boolean isDone) {
		Todo todo = new Todo(++todosCount, userName, description, targetDate, isDone);
		todos.add(todo);
	}

	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}
	
	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo; 
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}
