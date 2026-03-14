package com.gba.tasks.ui.parts;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.widgets.Composite;

import com.gba.tasks.model.ITodoService;
import com.gba.tasks.service.TodoServiceFactory;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;

public class TodoOverviewPart {
	
	// TodoOverview depende de una implementacion de ITodoService
	// La dependencia se puede mejorar con OSGi service
	private ITodoService todoService = TodoServiceFactory.getInstance();
	
	@Inject
	public TodoOverviewPart(Composite parent) {
		//System.out.println("Woh! got a  Composite	via DI");
		//System.out.println("Layout: " + parent.getLayout().getClass().getName());
	}
	
	@PostConstruct
	public void createControls(Composite parent) {
		// System.out.println(this.getClass().getSimpleName() 	+ " @PostConstruct method called.");
		
		System.out.println("Number of Todo Objects   " + todoService.getTodos().size());
	}
}

