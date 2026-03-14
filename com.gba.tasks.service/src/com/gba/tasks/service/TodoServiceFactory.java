package com.gba.tasks.service;

import com.gba.tasks.model.ITodoService;
import com.gba.tasks.service.internal.MyTodoServiceImpl;

/**
 * Factory provides access to the Todo service provider (ITodoService)
 */

public class TodoServiceFactory {
	// ocultamos la creacion la instancia concreta de la interface ITodoService
	private static ITodoService todoService = new MyTodoServiceImpl();
	
	public static ITodoService getInstance() {
		return todoService;
	}

}
