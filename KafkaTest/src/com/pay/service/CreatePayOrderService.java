package com.pay.service;


import org.apache.ibatis.session.SqlSession;

import com.pay.dto.PaymentDto;
import com.pay.dto.TradinfoDto;

public interface CreatePayOrderService {

	/**
	 * 根据交易订单信息生成支付订单
	 * 
	 * @param input
	 * @return
	 */
	public PaymentDto CreatePayOrder(TradinfoDto record);
	
	

}
