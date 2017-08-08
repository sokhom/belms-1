package com.belms.dream.repository.po;

import com.belms.dream.repository.common.AbstractRepo;
import com.belms.dream.repository.common.SqlSessionProvider;
import com.belms.dream.repository.po.mapper.PoMapper;
import com.blems.dream.api.model.po.Po;

public class PoRepo extends AbstractRepo<Po> {

	public PoRepo(SqlSessionProvider sqlSessionProvider, boolean manualTran) {
		super(sqlSessionProvider, session->session.getMapper(PoMapper.class),manualTran);
	}


}
