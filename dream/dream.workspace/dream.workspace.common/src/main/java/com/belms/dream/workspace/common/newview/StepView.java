package com.belms.dream.workspace.common.newview;

import com.belms.dream.api.view.EntryView;

public interface StepView extends EntryView<Object>  {
	String getName();
	boolean validationRequired();

}
