package com.belms.dream.repository.po;

import org.apache.ibatis.session.SqlSession;

import com.belms.dream.repository.common.AbstractRepo;
import com.belms.dream.repository.po.mapper.PoMapper;
import com.blems.dream.api.model.po.Po;

public class PoRepo extends AbstractRepo<Po> {
	

	public PoRepo(SqlSession session) {
		super(session, PoMapper.class);
	}


}
