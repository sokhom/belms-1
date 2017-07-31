package com.belms.dream.workspace.search;

import java.util.ArrayList;
import java.util.List;

import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.api.service.customer.CustomerService;
import com.blems.dream.api.model.ui.FilterItemList;

public class SearchViewPresenter implements OpenViewListener {
	private SearchView view;

	private CustomerService customerService;
	
	public SearchViewPresenter(SearchView view) {
		this.view = view;
		customerService = (CustomerService) ServiceProvider.getService(CustomerService.ID);
		initData();
		view.initView();
	}
	
	
	private void initData() {
		List<FilterItemList> filterItemLists = new ArrayList<>();
		filterItemLists.addAll(customerService.getAll());
		view.setResultList(filterItemLists);
	}


	@Override
	public void open(FilterItemList filterItemList) {
		System.out.println("open " + filterItemList.getName());
	}
}
