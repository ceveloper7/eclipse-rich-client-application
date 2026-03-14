package com.gba.tasks.service.internal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.gba.tasks.model.ITodoService;
import com.gba.tasks.model.Todo;

public class MyTodoServiceImpl implements ITodoService {

	private static int current = 1;
	private List<Todo> todos = null;

	public MyTodoServiceImpl() {
		todos = createInitialMode();
	}

	@Override
	public Todo getTodo(long id) {
		Todo todo = findById(id);
		if(todo != null) {
			return todo.copy();
		}
		return null;
	}

	// create new or update existing Todo object
	@Override
	public boolean saveTodo(Todo newTodo) {
		Todo updateTodo = findById(newTodo.getId());
		if(updateTodo == null) {
			updateTodo = new Todo(current++);
			todos.add(updateTodo);
		}
		
		updateTodo.setSummary(newTodo.getSummary());
		updateTodo.setDescription(newTodo.getDescription());
		updateTodo.setDone(newTodo.isDone());
		updateTodo.setDueDate(newTodo.getDueDate());
		
		return true;
	}

	@Override
	public boolean deleteTodo(long id) {
		Todo deleteTodo = findById(id);
		
		if(deleteTodo != null) {
			todos.remove(deleteTodo);
			return true;
		}
		return false;
	}

	@Override
	public List<Todo> getTodos() {
		List<Todo> list = new ArrayList<Todo>();
		for(Todo todo : todos) {
			list.add(todo.copy());
		}
		return list;
	}

	private Todo createTodo(String summary, String description) {
		return new Todo(current++, summary, description, false, LocalDate.now());
	}

	private Todo findById(long id) {
		for (Todo todo : todos) {
			if (id == todo.getId()) {
				return todo;
			}
		}
		return null;
	}
	
	private List<Todo> createInitialMode(){
		List<Todo> list = new ArrayList<Todo>();
		list.add(createTodo("Application model", "Flexible and extensible"));
		list.add(createTodo("DI", "@Inject as programming mode"));
		list.add(createTodo("OSGi", "Services"));
		list.add(createTodo("SWT", "Widgets"));
		list.add(createTodo("JFace", "Especially Viewers!"));
		list.add(createTodo("CSS Styling","Style your application"));
		list.add(createTodo("Eclipse services","Selection, model, Part"));
		list.add(createTodo("Renderer","Different UI toolkit"));
		list.add(createTodo("Compatibility Layer", "Run Eclipse 3.x"));
		
		return list;
	}

}
