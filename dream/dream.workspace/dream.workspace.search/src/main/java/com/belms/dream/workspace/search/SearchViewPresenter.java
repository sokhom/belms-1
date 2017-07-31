package com.belms.dream.workspace.search;

public class SearchViewPresenter {
	private SearchView view;

	public SearchViewPresenter(SearchView view) {
		this.view = view;
		
		view.initView();
	}
}
