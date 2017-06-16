package com.pay.service;

import org.apache.ibatis.session.SqlSession;

import com.pay.domain.Account;
import com.pay.dto.PaymentDto;

public interface UpdateAccontService {

	/**
	 * 更新account会员的余额信息
	 * 
	 * @param input
	 * @return
	 */
	public int updateAccount(PaymentDto record);
	
	

}
