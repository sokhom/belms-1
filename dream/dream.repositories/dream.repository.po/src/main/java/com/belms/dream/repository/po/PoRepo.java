package com.belms.dream.repository.po;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.belms.dream.repository.common.AbstractRepo;
import com.blems.dream.api.model.po.Po;

public class PoRepo extends AbstractRepo<Po> {

	public PoRepo(SqlSession session) {
		super(session);
	}

	public List<Po> getAll() {
		return null;
	}

}
