/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.common.mainview;

import com.belms.dream.api.view.event.EventBusProvider;
import com.belms.dream.api.view.event.RefreshEntityListener;
import com.belms.dream.api.view.event.SaveEnityListener;
import com.belms.dream.workspace.common.View;
import com.blems.dream.api.model.DefaultModel;
import com.blems.dream.api.model.ui.FilterItemList;

public interface MainLayoutView<T extends DefaultModel, E> extends View{
	
	void loadData(T data);	
	void setSaveEntityListener(SaveEnityListener<T> saveEnityListener);
	void setRefreshEntityListener(RefreshEntityListener<T> refreshEntityListener);
	void setDataInitWrapper(E data);
	E getDataInitWrapper();
	EventBusProvider getEventBusProvider();
	FilterItemList getSelectedItem();
	
}
