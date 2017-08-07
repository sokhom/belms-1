/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.api.service;

import com.blems.dream.api.model.BasedModel;

public interface ServiceFactory {
	String getId();
	<T extends BasedModel>ProcessingService<T> getService();
	<E,T extends BasedModel>LookupService<E,T> getLookupService();
	
}
