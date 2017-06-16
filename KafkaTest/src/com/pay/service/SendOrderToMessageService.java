package com.pay.service;

import com.pay.dto.TradinfoDto;

public interface SendOrderToMessageService {
	
	/**
	 * 将交易订单信息发送往消息服务器中
	 * 
	 * @param input
	 * @return
	 */
	public int SendOrderToMessage(TradinfoDto record,int servertype);
	
	public int SendOrderToKafkaMessage(TradinfoDto record);
	
	public int SendOrderToActiveMqMessage(TradinfoDto record);
	
	public int SendOrderToRedisServer(TradinfoDto record);
	
	public int SendOrderToFileServer(TradinfoDto record);
	
}
