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

	private static final String NUMBER_OF_TODO_ITEMS = "Number of Todo items: ";
	private Button btnLoadData;
	private Label lblNumberOfTodo;

	// TodoOverview depende de una implementacion de ITodoService
	// La dependencia se puede mejorar con OSGi service
	// private ITodoService todoService = TodoServiceFactory.getInstance();

	@Inject
	public TodoOverviewPart(Composite parent) {
		// System.out.println("Woh! got a Composite via DI");
		// System.out.println("Layout: " + parent.getLayout().getClass().getName());
	}

	// OSGi service is injecting
	@PostConstruct
	public void createControls(Composite parent, ITodoService todoService) {

		parent.setLayout(new GridLayout(2, false));
		btnLoadData = new Button(parent, SWT.PUSH);
		btnLoadData.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblNumberOfTodo.setText(NUMBER_OF_TODO_ITEMS + todoService.getTodos().size());
			}
		});
		btnLoadData.setText("Load Data");
		lblNumberOfTodo = new Label(parent, SWT.NONE);
		lblNumberOfTodo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblNumberOfTodo.setText("Data not available.");

		// System.out.println(this.getClass().getSimpleName() + " @PostConstruct method
		// called.");

		// System.out.println("Number of Todo Objects " +
		// todoService.getTodos().size());
	}

	@Focus
	public void setFocus() {
		btnLoadData.setFocus();
	}
}
