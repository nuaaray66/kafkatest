package com.pay.service.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

import com.dao.AccountMapper;
import com.dao.impl.AccountDaoImpl;
import com.db.ConnectionFactory;
import com.pay.domain.Account;
import com.pay.dto.PaymentDto;
import com.pay.service.UpdateAccontService;

public class UpdateAccountServiceImpl implements UpdateAccontService {
	
	@Override
	public int updateAccount(PaymentDto record) {
		// TODO Auto-generated method stub
		AccountMapper accdao = new AccountDaoImpl();
		
		Account acc = accdao.selectByCusCode(record.getPayCus());
		
		
		acc.setAccount(acc.getAccount().subtract(record.getPayAccount()));
		
		accdao.updateByPrimaryKeySelective(acc);
		
		accdao.commit();
		
		return 1;
		
	}

}
