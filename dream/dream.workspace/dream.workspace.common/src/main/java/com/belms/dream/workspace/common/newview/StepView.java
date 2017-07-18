package com.belms.dream.workspace.common.newview;

import com.vaadin.ui.Component;

public interface StepView   {
	
	String getName();
	Component getStackView();
	boolean isValid();

}
