package com.belms.dream.repository.common.vendor;

import org.apache.ibatis.session.SqlSession;

import com.belms.dream.repository.common.AbstractRepo;
import com.belms.dream.repository.common.mapper.VendorMapper;
import com.blems.dream.api.model.vendor.Vendor;

public class VendorRepo extends AbstractRepo<Vendor> {

	public VendorRepo(SqlSession session) {
		super(session);
		setObjectMapper(session.getMapper(VendorMapper.class));
	}

}
