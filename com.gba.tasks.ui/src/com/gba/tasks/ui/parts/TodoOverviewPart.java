package com.gba.tasks.ui.parts;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.widgets.Composite;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;

public class TodoOverviewPart {
	
	@Inject
	public TodoOverviewPart(Composite parent) {
		System.out.println("Woh! got a  Composite	via DI");
		
		System.out.println("Layout: " + parent.getLayout().getClass().getName());
	}
	
	@PostConstruct
	public void createControls(Composite parent) {
	System.out.println(this.getClass().getSimpleName() 	+ " @PostConstruct method called.");
	}
}

