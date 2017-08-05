package com.belms.dream.api.service;

import org.apache.ibatis.session.SqlSession;

import com.blems.dream.api.model.BasedModel;
import com.blems.dream.api.model.Repo;

public abstract class AbstractProcessService<T extends BasedModel> {

	private SqlSession sqlSession = null;

	@SuppressWarnings("unchecked")
	public void process(BasedModel object) {
		sqlSession = ServiceProvider.newSession();
		try {
			takeAction((T) object);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		} finally {
			sqlSession.close();
			sqlSession = null;
		}

	}

	protected abstract Repo<T> getRepo();

	protected SqlSession getSqlSession() {
		return sqlSession;
	}

	protected void takeAction(T t) {
		
		if (BasedModel.OPER.ADD == t.getOper()) {
			getRepo().add(t);
		} else if (BasedModel.OPER.EDIT == t.getOper()) {
			getRepo().edit(t);
		} else if (BasedModel.OPER.DELETE == t.getOper()) {
			getRepo().remove(t);
		}
	}

}
