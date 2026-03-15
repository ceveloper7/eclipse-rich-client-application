package com.gba.tasks.ui.parts;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.widgets.Composite;

import com.gba.tasks.model.ITodoService;
import com.gba.tasks.service.TodoServiceFactory;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;

public class TodoOverviewPart {
	
	// TodoOverview depende de una implementacion de ITodoService
	// La dependencia se puede mejorar con OSGi service
	//private ITodoService todoService = TodoServiceFactory.getInstance();
	
	@Inject
	public TodoOverviewPart(Composite parent) {
		//System.out.println("Woh! got a  Composite	via DI");
		//System.out.println("Layout: " + parent.getLayout().getClass().getName());
	}
	
	// OSGi service is injecting
	@PostConstruct
	public void createControls(Composite parent, ITodoService todoService) {
		parent.setLayout(new GridLayout(3, false));
		
		
		
		Button btnData = new Button(parent, SWT.NONE);
		
		btnData.setText("Load data");
		//new Label(parent, SWT.NONE);
		Label lblData = new Label(parent, SWT.NONE);
		GridData gd_lblData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_lblData.widthHint = 293;
		lblData.setLayoutData(gd_lblData);
		lblData.setText("New Label");
		
		btnData.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblData.setText("Number of Todos objects " + todoService.getTodos().size());
			}
		});
		
		// System.out.println(this.getClass().getSimpleName() 	+ " @PostConstruct method called.");
		
		//System.out.println("Number of Todo Objects   " + todoService.getTodos().size());
	}
}

