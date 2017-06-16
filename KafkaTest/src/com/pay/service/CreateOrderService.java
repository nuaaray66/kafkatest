package com.pay.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.pay.domain.Tradinfo;
import com.pay.dto.TradinfoDto;

public interface CreateOrderService {

	/**
	 * 从交易库中批量提取交易订单发送到消息服务器中
	 * 
	 * @param input
	 * @return
	 */
	public ArrayList<TradinfoDto> CreateTradOrder(int id);
	
	
	/**
	 * 根据会员信息及产品价格生成默认的交易订单
	 * 
	 * @param input
	 * @return
	 */
	public TradinfoDto CreateOneTradOrder(Tradinfo record);
	
	
}
