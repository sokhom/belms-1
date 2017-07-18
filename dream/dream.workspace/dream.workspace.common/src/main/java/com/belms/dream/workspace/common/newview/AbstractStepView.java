package com.belms.dream.workspace.common.newview;

import com.vaadin.ui.Component;

public abstract class AbstractStepView implements StepView {

	private Component cache;

	@Override
	public Component getStackView() {
		if(cache ==null){
			cache = buildView();
		}
		return cache;
	}
	
	
	protected abstract Component buildView();
	
}
