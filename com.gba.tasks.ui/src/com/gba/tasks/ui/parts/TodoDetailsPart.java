package com.gba.tasks.ui.parts;

import org.eclipse.swt.widgets.Composite;

import jakarta.annotation.PostConstruct;

public class TodoDetailsPart {
	
	public TodoDetailsPart() {
		
	}
	
	@PostConstruct
	public void createControls(Composite parent) {
		//System.out.println(this.getClass().getSimpleName() 	+ " @PostConstruct method called.");
	}
}
