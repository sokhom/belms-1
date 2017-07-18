package com.belms.dream.workspace.common.newview;

public class StepViewSelectedEvent {
	
	private final StepView stepView;
	
	public StepViewSelectedEvent(final StepView stepView) {
		this.stepView = stepView;
	}

	public StepView getStepView() {
		return stepView;
	}
	
	

}
