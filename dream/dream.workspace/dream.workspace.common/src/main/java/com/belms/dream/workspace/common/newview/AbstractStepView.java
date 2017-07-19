package com.belms.dream.workspace.common.newview;

import com.vaadin.ui.Component;

public abstract class AbstractStepView implements StepView {

	private Component cache;

	@Override
	public Component getView() {
		if(cache ==null){
			cache = buildView();
		}
		return cache;
	}
	

	@Override
	public void loadData(Object data) {
		
	}



	protected abstract Component buildView();

	
	
}
