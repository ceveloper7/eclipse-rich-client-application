package com.gba.tasks.ui.parts;

import org.eclipse.swt.widgets.Composite;

import jakarta.annotation.PostConstruct;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TodoDetailsPart {
	
	public TodoDetailsPart() {
		
	}
	
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		//System.out.println(this.getClass().getSimpleName() 	+ " @PostConstruct method called.");
	}
}
