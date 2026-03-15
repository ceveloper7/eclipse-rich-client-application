package com.gba.tasks.service;

import com.gba.tasks.model.ITodoService;
import com.gba.tasks.service.internal.MyTodoServiceImpl;

/**
 * Factory provides access to the Todo service provider (ITodoService)
 * Una vez que se implemento OSGi service ya no es necesaria esta clase.
 * La injeccion de dependencia la realiza OSGi por medio del archivo component.xml
 */

public class TodoServiceFactory {
	// ocultamos la creacion la instancia concreta de la interface ITodoService
	private static ITodoService todoService = new MyTodoServiceImpl();
	
	public static ITodoService getInstance() {
		return todoService;
	}

}
