package com.gba.contribute.parts;

import org.eclipse.jface.widgets.TextFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import jakarta.annotation.PostConstruct;

public class AdditionalInformationPart {
	@PostConstruct
	public void postConstruct(Composite parent) 
	{
		TextFactory.newText(SWT.BORDER_SOLID | SWT.MULTI).create(parent);
	}
}
