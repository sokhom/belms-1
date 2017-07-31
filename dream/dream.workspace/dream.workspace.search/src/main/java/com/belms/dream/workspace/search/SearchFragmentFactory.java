/**
 * @author ngounphanny
 */

package com.belms.dream.workspace.search;

import com.belms.dream.api.view.bridge.uifragments.UIFragmentFactory;
import com.belms.dream.api.view.bridge.uifragments.UIFragmentInfo;
import com.belms.dream.api.view.bridge.uifragments.UIFragmentInfo.VIEW_LEVEL;
import com.belms.dream.api.view.event.EventBusProvider;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Component;

public class SearchFragmentFactory implements UIFragmentFactory {

	
	private SearchViewImpl searchViewImpl = null;
	
	@Override
	public UIFragmentInfo getUIFagmentInfo() {
		UIFragmentInfo fragmentInfo = new UIFragmentInfo();
		fragmentInfo.setIcon(VaadinIcons.SEARCH);
		fragmentInfo.setId("global_search");
		fragmentInfo.setName("Search All");
		fragmentInfo.setViewLevel(VIEW_LEVEL.LEVEL1);
		fragmentInfo.setNavigateName("Global Search");
		fragmentInfo.setAccessCode("100-002");
		fragmentInfo.setDisplaySeq(2);
		fragmentInfo.setNavigate(true);
		return fragmentInfo;
	}

	@Override
	public Component getFragment(EventBusProvider eventBusProvider) {

		if(searchViewImpl == null ) {
			searchViewImpl = new SearchViewImpl(eventBusProvider); 
		}
		return searchViewImpl;
	}

	@Override
	public void initialSelfManaged(EventBusProvider eventBusProvider) {

	}

}
