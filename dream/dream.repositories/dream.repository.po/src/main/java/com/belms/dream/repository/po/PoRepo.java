package com.belms.dream.repository.po;

import com.belms.dream.repository.common.AbstractRepo;
import com.belms.dream.repository.common.SqlSessionProvider;
import com.belms.dream.repository.po.mapper.PoMapper;
import com.blems.dream.api.model.BasedModel.OPER;
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
				
				if(poItem.getOper() == OPER.ADD) {
					poItemRepo.add(poItem);	
				}
			}
		}
		
		
		return t;
	}

	@Override
	public Po edit(Po t) {
		super.edit(t);
		for (PoItem item : t.getItems()) {
			if(item.getOper() == OPER.EDIT ) {
				poItemRepo.edit(item);	
			}else if(OPER.DELETE ==item.getOper()) {
				poItemRepo.remove(item);
			}
		}
		
		return t;
	}

	@Override
	public void remove(Po t) {
		for (PoItem item : t.getItems()) {
			poItemRepo.remove(item);
		}
		super.remove(t);
		
		
	}
	
	

}
