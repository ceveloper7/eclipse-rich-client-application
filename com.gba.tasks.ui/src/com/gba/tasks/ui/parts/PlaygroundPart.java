package com.gba.tasks.ui.parts;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.widgets.Composite;

import jakarta.annotation.PostConstruct;

public class PlaygroundPart {
	
	public PlaygroundPart() {
		
	}
	
	@PostConstruct
	public void createControls(Composite parent) {
	System.out.println(this.getClass().getSimpleName() 	+ " @PostConstruct method called.");
	}
	
	@Focus
	private void setFocus() {
		System.out.println( this.getClass().getSimpleName() + "  @Focus method called");
	}
}
