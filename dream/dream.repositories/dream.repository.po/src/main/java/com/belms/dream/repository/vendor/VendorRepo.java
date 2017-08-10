package com.belms.dream.repository.vendor;

import com.belms.dream.repository.common.AbstractRepo;
import com.belms.dream.repository.common.SqlSessionProvider;
import com.belms.dream.repository.common.mapper.AccountMapper;
import com.belms.dream.repository.vendor.mapper.VendorMapper;
import com.blems.dream.api.model.account.Account;
import com.blems.dream.api.model.common.ObjectType;
import com.blems.dream.api.model.vendor.Vendor;

public class VendorRepo extends AbstractRepo<Vendor> {

	public VendorRepo(SqlSessionProvider sqlSessionProvider) {
		super(sqlSessionProvider);
		setObjectMapperProvider(session->session.getMapper(VendorMapper.class));
	}

	@Override
	public Vendor add(Vendor t) {
		
		AccountMapper accountMapper = getSqlSession().getMapper(AccountMapper.class);
		Account account = new Account();
		account.setType(new ObjectType(10));
		
		accountMapper.insert(account);
		t.setAccount(account);
		
		return super.add(t);
	}
	
	

}
