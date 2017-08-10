package com.belms.dream.repository.po;

import com.belms.dream.repository.common.AbstractRepo;
import com.belms.dream.repository.common.SqlSessionProvider;
import com.belms.dream.repository.po.mapper.PoMapper;
import com.blems.dream.api.model.po.Po;
import com.blems.dream.api.model.po.PoItem;

public class PoRepo extends AbstractRepo<Po> {

	private PoItemRepo poItemRepo ;
	public PoRepo(SqlSessionProvider sqlSessionProvider, boolean manualTran) {
		super(sqlSessionProvider, session->session.getMapper(PoMapper.class),manualTran);
		poItemRepo = new PoItemRepo(()->getSqlSession(), manualTran);
		
	}

	@Override
	public Po add(Po t) {
		super.add(t);
		if(t.getItems()!=null) {
			for (PoItem poItem: t.getItems()) {
				if(poItem.getPo() == null) {
					poItem.setPo(t);
				}
				poItemRepo.add(poItem);
			}
		}
		
		
		return t;
	}
	
	


}
