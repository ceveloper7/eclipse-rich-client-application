package com.gba.tasks.ui.parts;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.gba.tasks.model.Todo;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Named;

public class TodoDetailsPart {
	private Text txtSummary;
	private Text txtDescription;
	private DateTime dateTime;
	private Button btnDone;

	private Todo todo;

	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(2, false));

		Label lblSummary = new Label(parent, SWT.NONE);
		lblSummary.setText("Summary");
		txtSummary = new Text(parent, SWT.BORDER);
		txtSummary.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblDescription = new Label(parent, SWT.NONE);
		lblDescription.setText("Description");
		txtDescription = new Text(parent, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		txtDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		Label lblNewLabel = new Label(parent, SWT.NONE);
		lblNewLabel.setText("Due Date");
		dateTime = new DateTime(parent, SWT.BORDER);
		dateTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(parent, SWT.NONE);

		btnDone = new Button(parent, SWT.CHECK);
		btnDone.setText("Done");
	}

	@Focus
	public void setFocus() {
		txtSummary.setFocus();
	}

	/**
	 * permite activar/deactivar los campos de usuario
	 */
	private void enableUserInterface(boolean enabled) {
		if (txtSummary != null && !txtSummary.isDisposed()) {
			txtSummary.setEnabled(enabled);
			txtDescription.setEnabled(enabled);
			dateTime.setEnabled(enabled);
			btnDone.setEnabled(enabled);
		}
	}

	private void updateUserInterface(Todo todo) {
		if (todo == null) {
			enableUserInterface(false);
			return;
		}

		if (txtSummary != null & !txtSummary.isDisposed()) {
			enableUserInterface(true);
			txtSummary.setText(todo.getSummary());
		}
	}

	@Inject
	public void setTodo(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) Todo todo) {
		if (todo != null) {
			this.todo = todo;
		}

		updateUserInterface(todo);
	}
}
