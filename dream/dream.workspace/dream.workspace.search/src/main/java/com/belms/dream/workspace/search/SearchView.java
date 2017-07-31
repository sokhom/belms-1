package com.belms.dream.workspace.search;

import java.util.List;

import com.belms.dream.workspace.common.View;
import com.blems.dream.api.model.ui.FilterItemList;

public interface SearchView extends View {
	
	void setResultList(List<FilterItemList> filterItemLists);
}
