package com.belms.dream.repository.po;

import com.belms.dream.repository.common.AbstractRepo;
import com.belms.dream.repository.common.SqlSessionProvider;
import com.belms.dream.repository.po.mapper.PoItemMapper;
import com.blems.dream.api.model.po.PoItem;

public class PoItemRepo extends AbstractRepo<PoItem> {

	public PoItemRepo(SqlSessionProvider sqlSessionProvider, boolean manualTran) {
		super(sqlSessionProvider, session->session.getMapper(PoItemMapper.class),manualTran);
	}

}
