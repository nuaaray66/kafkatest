package com.pay.service;

import com.pay.dto.TradinfoDto;

public interface ReceiveOrderFromMessageService {
	
	/**
	 * 从message server获取交易订单信息
	 * 
	 * @param input
	 * @return
	 */
	public TradinfoDto ReceiveOrder();
	
	
}
